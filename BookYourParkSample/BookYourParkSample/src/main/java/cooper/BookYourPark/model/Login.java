package cooper.BookYourPark.model;
import javax.persistence.*;
import java.time.LocalDateTime;



@Entity
@Table(name="LOGIN", uniqueConstraints = { @UniqueConstraint(columnNames = "MAILID")})

public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String mailid;
    private String password;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

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
}