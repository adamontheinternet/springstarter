package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.OverridesAttribute;

/**
 * Created by alaplante on 1/25/16.
 */
@Entity
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;

    protected Greeting() {}

    public Greeting(String content) {
//        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
       return String.format("Greeting[id=%d, content='%s']", id, content);
    }
}
