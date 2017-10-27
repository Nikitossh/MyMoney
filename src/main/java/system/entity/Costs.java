package system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "costs")
@Table(name = "costs")
public class Costs {
    @Id
    private Long id;

    @Column(name = "value")
    private Long value;
    private String comment;
    private Long category_id;
    private Long date_id;

  public Costs() {
  }

  public Costs(Long id, Long value, String comment, Long category_id, Long date_id) {
    this.id = id;
    this.value = value;
    this.comment = comment;
    this.category_id = category_id;
    this.date_id = date_id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getValue() {
    return value;
  }

  public void setValue(Long value) {
    this.value = value;
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

  @Override
  public String toString() {
    return "Costs{" +
            "id=" + id +
            ", value=" + value +
            ", comment='" + comment + '\'' +
            ", category_id=" + category_id +
            ", date_id=" + date_id +
            '}';
  }
}
