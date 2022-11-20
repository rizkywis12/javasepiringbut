package com.fztrck.apiLibrary.services;

import com.fztrck.apiLibrary.model.dto.BookDto;
import com.fztrck.apiLibrary.model.dto.ResponseData;

public interface CategoryService {
    ResponseData<Object> addCategory(BookDto request);

    ResponseData<Object> getCategory(Boolean status);

    ResponseData<Object> getCategoryById(long id);

    ResponseData<Object> updateCategory(long id, BookDto request);

    ResponseData<Object> deleteCategory(long id);
}