package system.entity;

import javax.persistence.*;

@Entity(name = "costs")
@Table(name = "costs")
public class Cost {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "value")
    private Long value;
    @Basic(optional = false, fetch = FetchType.LAZY)
    private String comment;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Date date;

  public Cost() {
  }

  public Cost(Long id, Long value, String comment, Category category, Date date) {
    this.id = id;
    this.value = value;
    this.comment = comment;
    this.category = category;
    this.date = date;
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

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "Cost{" +
            "id=" + id +
            ", value=" + value +
            ", comment='" + comment + '\'' +
            ", category" + category +
            ", date=" + date +
            '}';
  }
}
