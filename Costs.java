package com.my.db;

public class Costs {
  private Long id;
  private Long value;
  private String comment;
  private Long category_id;
  private Long date_id;

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
}
