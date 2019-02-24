package law.advisor.model;

import javax.persistence.*;

@Entity
@Table(name="content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;
}
