package com.fztrck.apiLibrary.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


@Table(name = "borrow")
@Data
@Entity
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // join entity User (user_id)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // join entity Book (book_id)
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // @CreationTimestamp
    private LocalDateTime BorrowAt = LocalDateTime.now();

    // @UpdateTimestamp
    @Column(name = "returned_date")
    private Date returned_date;

    private boolean borrowed = false;
}

