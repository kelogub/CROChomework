package work;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static class LocalDateAdapter extends XmlAdapter<String, LocalDate> { //адаптер чтобы JAXB работал с LocalDate
        @Override
        public LocalDate unmarshal(String v) throws Exception {
            return LocalDate.parse(v, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        @Override
        public String marshal(LocalDate v) throws Exception {
            return v.toString();
        }
    }

    public static void main(String[] args) throws JAXBException, IOException {
        DateTimeFormatter russianFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        JAXBContext context = JAXBContext.newInstance(Sellers.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Sellers sellers = (Sellers) unmarshaller.unmarshal(new File("sellers.xml"));

        context = JAXBContext.newInstance(Products.class);
        unmarshaller = context.createUnmarshaller();
        Products products = (Products) unmarshaller.unmarshal(new File("products.xml"));

        context = JAXBContext.newInstance(Sales.class);
        unmarshaller = context.createUnmarshaller();
        Sales sales = (Sales) unmarshaller.unmarshal(new File("sales.xml"));

        context = JAXBContext.newInstance(Availability.class);
        unmarshaller = context.createUnmarshaller();
        Availability availability = (Availability) unmarshaller.unmarshal(new File("availability.xml"));

        //1. Для каждого товара вывести в файл общее количество проданных товаров этого типа

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<ProductAmount> ans1 = new ArrayList<>();
        products.getProducts()
                .forEach(product -> {
                    //System.out.println("\"" + product.getName() + "\"" + " : " + sales.getSales().stream().filter(sale -> sale.getProduct_id() == product.getId()).mapToInt(Sale::getAmount).sum());
                    ans1.add(new ProductAmount(product.getName(), sales.getSales().stream().filter(sale -> sale.getProduct_id() == product.getId()).mapToInt(Sale::getAmount).sum()));
                });

        objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValue(new File("1out.json"), ans1);

        //2. Вывести в файл распределение общего количества продаж по датам

        ArrayList<DateAmount> ans2 = new ArrayList<>();
        HashSet<LocalDate> dates = sales.getSales().stream().map(Sale::getDate).collect(Collectors.toCollection(HashSet::new));

        //можно собрать в многоуровневый стрим, но понятность пострадает.

        dates.stream()
                .sorted()
                .forEach(data -> {
//                    System.out.println("\"" + data.format(russianFormat) + "\"" + " : " + sales.getSales().stream()
//                            .filter(sale -> sale.getDate().equals(data))
//                            .mapToInt(Sale::getAmount)
//                            .sum()
//                    );
                    ans2.add(new DateAmount(data.format(russianFormat), sales.getSales().stream()
                            .filter(sale -> sale.getDate().equals(data))
                            .mapToInt(Sale::getAmount)
                            .sum()));
                });
        objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValue(new File("2out.json"), ans2);
    }
}