package law.advisor.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="content_id")
    private Content content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
    private Date date;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<User> lawyers;

    @OneToMany
    @JoinColumn(name = "answer_id")
    private Set<Answer> answers;


    @Column(columnDefinition = "varchar(20) default 'ANSWER'")
    @Enumerated(EnumType.STRING)
    private CommentTo comment_to = CommentTo.ANSWER;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<User> getLawyers() {
        return lawyers;
    }

    public void setLawyers(Set<User> lawyers) {
        this.lawyers = lawyers;
    }

    public CommentTo getComment_to() {
        return comment_to;
    }

    public void setComment_to(CommentTo comment_to) {
        this.comment_to = comment_to;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}
