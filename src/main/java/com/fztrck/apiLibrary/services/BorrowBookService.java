package com.fztrck.apiLibrary.services;


import com.fztrck.apiLibrary.model.dto.BookDto;

import com.fztrck.apiLibrary.model.dto.ResponseData;
import com.fztrck.apiLibrary.model.entity.BorrowBook;

public interface BorrowBookService {
    ResponseData<Object> borrowBook(long id, BookDto request);

    ResponseData<Object> returnedBook(long id,BookDto request);

}
