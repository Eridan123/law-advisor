package law.advisor.model;

import javax.persistence.*;

@Entity
@Table(name="message_resource")
public class MessageResource {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="message_key", nullable=false)
    private String message_key;

    @Column(name="eng")
    private String eng;

    @Column(name="rus")
    private String rus;

    @Column(name="kgz")
    private String kgz;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getMessage_key() {
        return message_key;
    }

    public void setMessage_key(String message_key) {
        this.message_key = message_key;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getRus() {
        return rus;
    }

    public void setRus(String rus) {
        this.rus = rus;
    }

    public String getKgz() {
        return kgz;
    }

    public void setKgz(String kgz) {
        this.kgz = kgz;
    }



}
