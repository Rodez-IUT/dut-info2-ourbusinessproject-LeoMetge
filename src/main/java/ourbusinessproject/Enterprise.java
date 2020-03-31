package ourbusinessproject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
public class Enterprise {
//pour commit fix #2.3.3 Rest Controller OK
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String name;
    @NotEmpty @Length(min = 10, message = "Trop court")
    private String description;
    @NotEmpty
    private String contactName;
    @NotEmpty @Email
    private String contactEmail;
    @NotNull @OneToMany(mappedBy = "enterprise" ,cascade = CascadeType.ALL)
    private List<Project> projects;

    public Enterprise(){
        this.projects = new ArrayList<>();
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
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Long getId() {
        return this.id;
    }

    public void addProject(Project project){
        this.projects.add(project);
    }

    @JsonIgnore
    public List<Project> getProjects() {
        return projects.isEmpty() ? null : projects;
    }

    @Override
    public String toString() {
        return this.name;
    }
}