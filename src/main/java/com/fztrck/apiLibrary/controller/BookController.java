package com.fztrck.apiLibrary.controller;

import com.fztrck.apiLibrary.model.dto.request.BookDto;
import com.fztrck.apiLibrary.model.dto.response.ResponseData;
import com.fztrck.apiLibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    private ResponseData<Object> responseData;

    @GetMapping
    public ResponseEntity<Object> getBooks() {
        responseData = bookService.getAll();
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> postBook(@RequestBody BookDto request) {
        responseData = bookService.insertBook(request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) {
        responseData = bookService.getById(id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable long id, @RequestBody BookDto request) {
        responseData = bookService.updateBook(id, request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable long id) {
        responseData = bookService.deleteBook(id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
}
