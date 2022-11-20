package com.fztrck.apiLibrary.services;


import com.fztrck.apiLibrary.model.dto.BorrowBookDto;
import com.fztrck.apiLibrary.model.dto.ResponseData;
import com.fztrck.apiLibrary.model.entity.BorrowBook;

public interface BorrowBookService {
    ResponseData<Object> createBorrow(long id,BorrowBookDto request);

    ResponseData<Object> returnedBook(long id,BorrowBookDto request);

}
