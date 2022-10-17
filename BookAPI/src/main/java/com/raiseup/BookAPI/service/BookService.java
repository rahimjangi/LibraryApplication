package com.raiseup.BookAPI.service;

import com.raiseup.BookAPI.model.Book;
import com.raiseup.BookAPI.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long bookId) {
        return bookRepository.findById(bookId).orElse(new Book());
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public Book updateBook(Book book, Long bookId) {
        Book findedBook=bookRepository.findById(bookId).get();
        findedBook.setAuthor(book.getAuthor());
        findedBook.setTitle(book.getTitle());
        return bookRepository.save(findedBook);
    }
    public Book updateBook(Map<String,String>updates, Long bookId) {
        Book findedBook=bookRepository.findById(bookId).get();
        findedBook.setAuthor(updates.get("author"));
        findedBook.setTitle(updates.get("title"));
        return bookRepository.save(findedBook);
    }
}
