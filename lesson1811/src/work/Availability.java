package work;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "avialability")
public class Availability {
    private List<Available> availability = new ArrayList<>();

    @XmlElement(name="avialable")
    public List<Available> getAvailability() {
        return availability;
    }

    public void setAvailability(List<Available> availability) {
        this.availability = availability;
    }
}

class Available {
    private int seller_id;
    private int product_id;
    private int price;
    private int amount;

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Available{" +
                "seller_id=" + seller_id +
                ", product_id=" + product_id +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
