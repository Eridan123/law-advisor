package law.advisor.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CommentModel {
    @Id
    private Long id;
    private String user;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
