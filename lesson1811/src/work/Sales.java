package work;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "sales")
public class Sales {
    private List<Sale> sales = new ArrayList<>();

    @XmlElement(name="sale")
    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "sales=" + sales +
                '}';
    }
}
class Sale {
    private int id;
    private int seller_id;
    private int product_id;
    private int amount;

    @XmlJavaTypeAdapter(Main.LocalDateAdapter.class)
    private LocalDate date;

    final DateTimeFormatter russianFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date, russianFormat);
    }
}