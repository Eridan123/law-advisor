package law.advisor.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LawyerRateModel {

    @Id
    private Long user_id;
    private Integer num_answers;
    private String name;
    private String surname;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Integer getNum_answers() {
        return num_answers;
    }

    public void setNum_answers(Integer num_answers) {
        this.num_answers = num_answers;
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
}
