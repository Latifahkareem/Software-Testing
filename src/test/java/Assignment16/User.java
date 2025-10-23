package Assignment16;
import lombok.Getter;
import lombok.Setter;
import org.assertj.core.api.Condition;
import java.util.Collection;
@Setter
public class User extends Condition<Collection<?>> {
    // Getter و Setter لكل المتغيرات
    @Getter
    private long id;
    @Getter
    private String username;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public int userStatus;

    public User(long id, String username, String firstName, String lastName, String email,
                String password, String phone, int userStatus) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    @Override
    public Condition<Collection<?>> as(String description, Object... args) {
        return super.as(description, args);
    }

}