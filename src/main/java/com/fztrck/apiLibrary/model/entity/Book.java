package com.fztrck.apiLibrary.model.entity;
import lombok.Data;

import javax.persistence.*;

@Table(name = "books")
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 100)
    private String author;

    private boolean isDeleted = false;
    // many to one ke table category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // constructor
    public Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }


    // setter - getter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}