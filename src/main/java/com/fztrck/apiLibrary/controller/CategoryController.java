package com.fztrck.apiLibrary.controller;

import com.fztrck.apiLibrary.model.dto.BookDto;
import com.fztrck.apiLibrary.model.dto.ResponseData;
import com.fztrck.apiLibrary.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    private ResponseData<Object> responseData;

    @GetMapping
    public ResponseEntity<Object> getAllCategories(@RequestParam(value = "status", defaultValue = "") Boolean status) {
        responseData = categoryService.getCategory(status);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategory(@PathVariable long id) {
        responseData = categoryService.getCategoryById(id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @PostMapping
    public ResponseEntity<Object> addCategory(@RequestBody BookDto request) {
        responseData = categoryService.addCategory(request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable long id, @RequestBody BookDto request) {
        responseData = categoryService.updateCategory(id, request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable long id) {
        responseData = categoryService.deleteCategory(id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
}

