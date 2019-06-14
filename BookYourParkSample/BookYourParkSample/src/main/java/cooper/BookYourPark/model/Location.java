package cooper.BookYourPark.model;


import javax.persistence.*;

@Entity
@Table(name="LOCATION")

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer locId;
    private String locName;
    private String locCity;
    private Integer totalSlots;

    public Integer getLocId() {
        return locId;
    }

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getLocCity() {
        return locCity;
    }

    public void setLocCity(String locCity) {
        this.locCity = locCity;
    }

    public Integer getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(Integer totalSlots) {
        this.totalSlots = totalSlots;
    }
}
