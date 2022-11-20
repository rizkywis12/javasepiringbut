package com.fztrck.apiLibrary.services.impl;

import com.fztrck.apiLibrary.model.dto.BorrowBookDto;
import com.fztrck.apiLibrary.model.dto.ResponseData;
import com.fztrck.apiLibrary.model.entity.Book;
import com.fztrck.apiLibrary.model.entity.BorrowBook;
import com.fztrck.apiLibrary.model.entity.User;
import com.fztrck.apiLibrary.repository.BookRepository;
import com.fztrck.apiLibrary.repository.BorrowBookRepository;
import com.fztrck.apiLibrary.repository.UserRepository;
import com.fztrck.apiLibrary.services.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class BorrowBookServiceImpl implements BorrowBookService {
    @Autowired
    BorrowBookRepository borrowBookRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;

    private ResponseData<Object> responseData;
    private Book book;
    private User user;
    private BorrowBook borrowBook;
    private Map<Object,Object> data;




        public ResponseData<Object> borrowBook(long id,BorrowBookDto request) {
            Optional<User> userOptional = userRepository.findById(id);
            if (userOptional.isPresent()) {
                user = userOptional.get();
                borrowBook = new BorrowBook();
                book = bookRepository.findByTitle(request.getBookName());
                borrowBook.setUser(user);
                borrowBook.setBook(book);
                borrowBookRepository.save(borrowBook);
                responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), "Buku Berhasil Di Pinjam", borrowBook);

            }else {
                    responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "user tidak ada", borrowBook);
            }
            return responseData;
        }



    @Override
    public ResponseData<Object> returnedBook(long id, BorrowBookDto request) {
        Optional<BorrowBook> borrowOpt = borrowBookRepository.findById(id);

        if (borrowOpt.isPresent()) {
            borrowBook = borrowOpt.get();
            borrowBook.setReturned_date(request.getReturndate());
            // update namenya
            borrowBook.setBorrowed(false);
            // save
            borrowBookRepository.save(borrowBook);

            // response data
            responseData = new ResponseData<Object>(HttpStatus.OK.value(), "Buku Di Kembalikan", borrowBook);
        } else {
            responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "data not found", null);


        }
        return responseData;
    }


}
