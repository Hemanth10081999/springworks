package cooper.BookYourPark.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;



@Entity
@Table(name="LOGIN", uniqueConstraints = { @UniqueConstraint(columnNames = "MAILID")})

public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String mailid;
    @NotNull
    private String password;
    @NotNull
    private LocalDateTime createDate;
    @NotNull
    private Integer wallet;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;




    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMailid() {
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Integer getWallet() {
        return wallet;
    }

    public void setWallet(Integer wallet) {
        this.wallet = wallet;
    }
}