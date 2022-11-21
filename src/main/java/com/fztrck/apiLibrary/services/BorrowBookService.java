package com.fztrck.apiLibrary.services;


import com.fztrck.apiLibrary.exception.custom.CustomNotFoundException;
import com.fztrck.apiLibrary.model.dto.request.BookDto;
import com.fztrck.apiLibrary.model.dto.response.ResponseData;


public interface BorrowBookService {
    ResponseData<Object> borrowBook(long id, BookDto request) throws CustomNotFoundException, Exception;

    ResponseData<Object> returnedBook(long id,BookDto request) throws Exception;

}
