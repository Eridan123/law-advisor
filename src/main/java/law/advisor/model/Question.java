package law.advisor.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "question")
public class Question {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private Date date;

    private int status;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=true)
    private Category category;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
