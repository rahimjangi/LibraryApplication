package com.raiseup.BookAPI.repository;

import com.raiseup.BookAPI.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
