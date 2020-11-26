package work;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "list")
public class ListRoot {
    private List<Slr> slrs = new ArrayList<>();

    @XmlElement(name="seller")
    public List<Slr> getItems() {
        return slrs;
    }

    public void setItems(List<Slr> slrs) {
        this.slrs = slrs;
    }

    @Override
    public String toString() {
        return "ListRoot{" +
                "items=" + slrs +
                '}';
    }
}

class Slr {
    private long id;
    private String last_name;
    private String first_name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return "Slr{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                '}';
    }
}