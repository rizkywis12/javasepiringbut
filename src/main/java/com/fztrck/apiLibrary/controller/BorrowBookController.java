package com.fztrck.apiLibrary.controller;

import com.fztrck.apiLibrary.exception.custom.CustomNotFoundException;
import com.fztrck.apiLibrary.model.dto.request.BookDto;

import com.fztrck.apiLibrary.model.dto.response.ResponseData;
import com.fztrck.apiLibrary.services.BorrowBookService;
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
    public ResponseEntity<Object> postBook(@PathVariable long id, @RequestBody BookDto request) throws CustomNotFoundException, Exception {
            responseData = borrowBookService.borrowBook(id, request);
            return ResponseEntity.status(responseData.getStatus()).body(responseData);
}
    @PostMapping("/returned/{id}")
    public ResponseEntity<Object> returend(@PathVariable long id, @RequestBody BookDto request) throws CustomNotFoundException, Exception {
        responseData = borrowBookService.returnedBook(id,request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
}
