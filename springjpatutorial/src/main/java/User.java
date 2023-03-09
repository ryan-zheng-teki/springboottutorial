import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
public class User {
    @Id
    private String email;
    @Column(name = "userName")
    private String name;
    private Integer age;
}
