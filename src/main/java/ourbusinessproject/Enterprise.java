package ourbusinessproject;

import org.hibernate.validator.constraints.Length;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Entity
public class Enterprise {

    @Id
    @GeneratedValue // par defaut stratégie autoingrément
    private Long id;

    /*
     * Nom de l'entreprise
     */
    @NotEmpty
    private String name;

    /*
     * description de l'entreprise
     */
    @Length(min = 10)
    private String description;

    /*
     * Nom du contact
     */
    @NotEmpty
    private String ContactName;

    /*
     * mail du contact
     */
    @NotEmpty
    @Email
    private String ContactEmail;


    public Enterprise() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public void setContactEmail(String contactEmail) {
        ContactEmail = contactEmail;
    }
}
