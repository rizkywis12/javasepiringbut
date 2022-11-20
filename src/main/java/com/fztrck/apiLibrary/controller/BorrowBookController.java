package com.fztrck.apiLibrary.controller;

import com.fztrck.apiLibrary.model.dto.BookDto;

import com.fztrck.apiLibrary.model.dto.ResponseData;
import com.fztrck.apiLibrary.model.dto.UserDetailDto;
import com.fztrck.apiLibrary.model.entity.BorrowBook;
import com.fztrck.apiLibrary.services.BorrowBookService;
import com.fztrck.apiLibrary.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrow")
public class BorrowBookController {
    @Autowired
    private BorrowBookService borrowBookService;

    private ResponseData<Object> responseData;

    @PostMapping("/book/{id}")
    public ResponseEntity<Object> postBook(@PathVariable long id, @RequestBody BookDto request) {
        responseData = borrowBookService.borrowBook(id,request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
    @PostMapping("/returned/{id}")
    public ResponseEntity<Object> returend(@PathVariable long id, @RequestBody BookDto request) {
        responseData = borrowBookService.returnedBook(id,request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
}
