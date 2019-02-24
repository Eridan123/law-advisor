package law.advisor.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="content_id")
    private Content content;

    private Date date;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="lawyer_id", nullable=true)
    private User lawyer;

    @ManyToOne
    @JoinColumn(name="question_id", nullable=true)
    private Question question;

    @Column(columnDefinition = "varchar(20) default 'QUESTION'")
    @Enumerated(EnumType.STRING)
    private CommentTo comment_to = CommentTo.QUESTION;

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

    public User getLawyer() {
        return lawyer;
    }

    public void setLawyer(User lawyer) {
        this.lawyer = lawyer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public CommentTo getComment_to() {
        return comment_to;
    }

    public void setComment_to(CommentTo comment_to) {
        this.comment_to = comment_to;
    }
}
