package system.entity;

import javax.persistence.*;

@Embeddable
public class Date {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "date")
    // Почему не работает при добавлении аннотации?
    //@Temporal(TemporalType.DATE)
    private java.time.LocalDate date;

    public Date() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.time.LocalDate getDate() {
        return date;
    }

    public void setDate(java.time.LocalDate date) {
        this.date = date;
    }
}
