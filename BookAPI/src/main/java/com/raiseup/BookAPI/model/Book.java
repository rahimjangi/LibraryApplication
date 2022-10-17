package com.raiseup.BookAPI.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_seq")
        private Long id;
        private String title;
        private String author;

}
