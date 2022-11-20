package com.fztrck.apiLibrary.services.impl;

import com.fztrck.apiLibrary.model.dto.BookDto;
import com.fztrck.apiLibrary.model.dto.ResponseData;
import com.fztrck.apiLibrary.model.entity.Category;
import com.fztrck.apiLibrary.repository.CategoryRepository;
import com.fztrck.apiLibrary.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    private Category category;
    private ResponseData<Object> responseData;
    private List<Category> categories;

    @Override
    public ResponseData<Object> addCategory(BookDto request) {
        // TODO Auto-generated method stub
        category = new Category();
        category.setName(request.getCategoryName());
        categoryRepository.save(category);

        responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), "Add category success", category.getName());
        return responseData;
    }

    @Override
    public ResponseData<Object> getCategory(Boolean status) {
        // TODO Auto-generated method stub
        // validasi statusnya, user mengirimkan data status?
        if (status == null) {
            categories = categoryRepository.findAll();
        } else {
            categories = categoryRepository.findByIsDeleted(status);
        }

        // bisa dikasih validasi kalau list category masih kosong, belum ada data
        // category
        responseData = new ResponseData<Object>(HttpStatus.OK.value(), "success", categories);
        return responseData;
    }

    @Override
    public ResponseData<Object> updateCategory(long id, BookDto request) {
        // TODO Auto-generated method stub
        // dicari berdasarkan id category untuk diupdate namenya
        Optional<Category> categoryOpt = categoryRepository.findById(id);
        // bisa dikasih validasi kalau buku ada atau tidak
        category = categoryOpt.get();
        // update namenya
        category.setName(request.getCategoryName());
        // save
        categoryRepository.save(category);

        // response data
        responseData = new ResponseData<Object>(HttpStatus.OK.value(), "Update success", category);
        return responseData;
    }

    @Override
    public ResponseData<Object> deleteCategory(long id) {
        // TODO Auto-generated method stub
        // dicari berdasarkan id category untuk diupdate namenya
        Optional<Category> categoryOpt = categoryRepository.findById(id);
        // bisa dikasih validasi kalau buku ada atau tidak
        category = categoryOpt.get();
        // update namenya
        category.setDeleted(true);
        // save
        categoryRepository.save(category);

        // response data
        responseData = new ResponseData<Object>(HttpStatus.OK.value(), "Delete success", null);
        return responseData;
    }

    @Override
    public ResponseData<Object> getCategoryById(long id) {
        // TODO Auto-generated method stub
        // dicari berdasarkan id category untuk diupdate namenya
        Optional<Category> categoryOpt = categoryRepository.findById(id);
        // bisa dikasih validasi kalau buku ada atau tidak
        category = categoryOpt.get();

        // response data
        responseData = new ResponseData<Object>(200, "success", category);
        return responseData;
    }

}
