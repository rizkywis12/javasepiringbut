package com.fztrck.apiLibrary.services.impl;

import com.fztrck.apiLibrary.exception.custom.CustomNotFoundException;
import com.fztrck.apiLibrary.model.dto.request.BookDto;
import com.fztrck.apiLibrary.model.dto.response.ResponseData;
import com.fztrck.apiLibrary.model.entity.Book;
import com.fztrck.apiLibrary.model.entity.BorrowBook;
import com.fztrck.apiLibrary.model.entity.User;
import com.fztrck.apiLibrary.repository.BookRepository;
import com.fztrck.apiLibrary.repository.BorrowBookRepository;
import com.fztrck.apiLibrary.repository.UserRepository;
import com.fztrck.apiLibrary.services.BorrowBookService;
import com.fztrck.apiLibrary.validator.BookValidator;
import com.fztrck.apiLibrary.validator.BorrowValidator;
import com.fztrck.apiLibrary.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
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
    private UserValidator userValidator;
    private BookValidator bookValidator;
    private BorrowValidator borrowValidator;




        public ResponseData<Object> borrowBook(long id, BookDto request) throws CustomNotFoundException,Exception {
//            Find UserID
            Optional<User> userOptional = userRepository.findById(id);
            Optional<Book> bookOpt = bookRepository.findByTitle(request.getTitle());
            userValidator.validateUserNotFound(userOptional);
            bookValidator.validateBookNotFound(bookOpt);
//            Jika User Id ada
            if (userOptional.isPresent() && bookOpt.isPresent()) {
                user = userOptional.get();
                book = bookOpt.get();
                borrowBook = new BorrowBook();
//                FindByTitle
                borrowBook.setUser(user);
                borrowBook.setBook(book);
//                save
                borrowBookRepository.save(borrowBook);
                data = new HashMap<>();
                data.put("peminjam", user.getEmail());
                data.put("buku di pinjam", book.getTitle());
                data.put("Borrow_Date", borrowBook.getBorrowAt());
                data.put("Returned_Date", borrowBook.getReturned_date());
                data.put("status", borrowBook.getBorrowed());

                responseData = new ResponseData<Object>(HttpStatus.OK.value(), "Buku Berhasil Di Pinjam", data);
            }
            return responseData;
        }



    @Override
    public ResponseData<Object> returnedBook(long id, BookDto request) throws Exception {
        Optional<BorrowBook> borrowOpt = borrowBookRepository.findById(id);
     borrowValidator.validateBorrowNotFound(borrowOpt);

        if (borrowOpt.isPresent()) {
            borrowBook = borrowOpt.get();
            borrowBook.setReturned_date(request.getReturndate());
//         True False Borrowed
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
