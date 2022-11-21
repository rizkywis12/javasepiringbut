package com.fztrck.apiLibrary.services;

import com.fztrck.apiLibrary.model.dto.request.BookDto;
import com.fztrck.apiLibrary.model.dto.response.ResponseData;

public interface BookService {
 ResponseData<Object> insertBook(BookDto requestDto);
 ResponseData<Object> getAll();
 ResponseData<Object> getById(long id);
 ResponseData<Object> updateBook(long id, BookDto request);
 ResponseData<Object> deleteBook(long id);
}
