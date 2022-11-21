package com.fztrck.apiLibrary.validator;

import com.fztrck.apiLibrary.exception.custom.CustomNotFoundException;
import com.fztrck.apiLibrary.model.entity.Book;

import java.util.Optional;

public class BookValidator {
    public void validateBookNotFound( Optional<Book> bookOpt) throws Exception {
        if (bookOpt.isEmpty()) {
            throw new CustomNotFoundException("Buku TIdak Ditemukan");
        }
    }
}
