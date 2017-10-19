package system.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "budget")
public class Budget {
    @Id
    private Long id;
    private Long amount;
    private String comment;
    private Long category_id;
    private Long date_id;

    public Budget() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Long getDate_id() {
        return date_id;
    }

    public void setDate_id(Long date_id) {
        this.date_id = date_id;
    }
}
