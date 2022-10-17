package com.raiseup.RatingAPI.mode;

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
public class Rating {
    @Id
    @GeneratedValue(generator = "rating_seq",strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long bookId;
    private int stars;
}
