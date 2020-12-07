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

        ArrayList<ProductAmount> ans1 = new ArrayList<>();

        var a1 = sales.getSales().stream()
                .collect(Collectors.groupingBy(Sale::getProduct_id, Collectors.summingInt(Sale::getAmount)));

        products.getProducts().forEach(product -> {
            ans1.add(new ProductAmount(product.getName(), a1.get(product.getId())));
        });

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValue(new File("1.2out.json"), ans1);

        //2. Вывести в файл распределение общего количества продаж по датам

        var a2 = sales.getSales().stream()
                .collect(Collectors.groupingBy(Sale::getDate, Collectors.summingInt(Sale::getAmount)));

        ArrayList<DateAmount> ans2 = new ArrayList<>();
        LinkedHashSet<LocalDate> dates = sales.getSales().stream().map(Sale::getDate).sorted().collect(Collectors.toCollection(LinkedHashSet::new));

        dates.forEach(date->{
            ans2.add(new DateAmount(date.format(russianFormat), a2.get(date)));
        });

        objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValue(new File("2.2out.json"), ans2);
    }
}