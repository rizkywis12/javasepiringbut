package com.fztrck.apiLibrary.repository;

import com.fztrck.apiLibrary.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findByTitle(String title);
}
