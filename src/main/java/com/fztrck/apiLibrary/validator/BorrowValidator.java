package com.fztrck.apiLibrary.validator;

import com.fztrck.apiLibrary.exception.custom.CustomNotFoundException;
import com.fztrck.apiLibrary.model.entity.Book;
import com.fztrck.apiLibrary.model.entity.BorrowBook;

import java.util.Optional;

public class BorrowValidator {
    public void validateBorrowNotFound( Optional<BorrowBook> borrowOpt) throws Exception {
        if (borrowOpt.isEmpty()) {
            throw new CustomNotFoundException("Buku TIdak Ditemukan");
        }
    }
}
