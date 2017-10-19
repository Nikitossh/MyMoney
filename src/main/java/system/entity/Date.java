package system.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "date")
public class Date {
    @Id
    private Long id;
    private java.sql.Date date;

    public Date() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }
}
