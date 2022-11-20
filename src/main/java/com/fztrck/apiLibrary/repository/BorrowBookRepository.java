package com.fztrck.apiLibrary.repository;

import com.fztrck.apiLibrary.model.entity.Book;
import com.fztrck.apiLibrary.model.entity.BorrowBook;
import com.fztrck.apiLibrary.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBook,Long> {
}
