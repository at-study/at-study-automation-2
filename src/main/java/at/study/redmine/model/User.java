package at.study.redmine.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import at.study.redmine.model.user.Language;
import at.study.redmine.model.user.MailNotification;
import at.study.redmine.model.user.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static at.study.redmine.utils.StringUtils.randomEnglishString;
import static at.study.redmine.utils.StringUtils.randomHexString;
import static org.apache.commons.codec.digest.DigestUtils.sha1Hex;

@NoArgsConstructor
@Getter
@Setter
public class User extends CreatableEntity implements Creatable<User> {

    private String login = "AutoLogin" + randomEnglishString(10);
    private String password = "1qaz@WSX";
    private String salt = randomHexString(32);
    private String hashedPassword = getHashedPassword();
    private String firstName = "AutoF" + randomEnglishString(10);
    private String lastName = "AutoL" + randomEnglishString(10);
    private Boolean isAdmin = false;
    private Status status = Status.ACTIVE;
    private LocalDateTime lastLoginOn;
    private Language language = Language.RUSSIAN;
    private String authSourceId;
    private String type = "User";
    private String identityUrl;
    private MailNotification mailNotification = MailNotification.NONE;
    private Boolean mustChangePassword = false;
    private LocalDateTime passwordChangedOn;
    private List<Token> tokens = new ArrayList<>();
    private List<Email> emails = new ArrayList<>();

    public String getHashedPassword() {
        return sha1Hex(salt + sha1Hex(password));
    }

    @Override
    public User create() {
        // TODO: Реализовать с помощью запроса к базе данных
        throw new UnsupportedOperationException();
    }
}
