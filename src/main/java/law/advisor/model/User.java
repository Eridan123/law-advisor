package law.advisor.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String encryted_password;

    private String name;

    private String surname;

    @Email
    private String email;

    private String phone_number;

    private String avatar;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="lawyer_degree_id")
    private Content lawyer_degree_id;

    private boolean enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryted_password() {
        return encryted_password;
    }

    public void setEncryted_password(String encryted_password) {
        this.encryted_password = encryted_password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Content getLawyer_degree_id() {
        return lawyer_degree_id;
    }

    public void setLawyer_degree_id(Content lawyer_degree_id) {
        this.lawyer_degree_id = lawyer_degree_id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
