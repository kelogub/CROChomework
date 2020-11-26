package work;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "sellers")
public class Sellers {
    private List<Seller> sellers = new ArrayList<>();

    @XmlElement(name="seller")
    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    @Override
    public String toString() {
        return "Sellers{" +
                "sellers=" + sellers +
                '}';
    }
}

class Seller {
    private int id;
    private String last_name;
    private String first_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                '}';
    }
}
