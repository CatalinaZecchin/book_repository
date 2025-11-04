package com.bibliophile.book_repository.dto;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String authorName;
    private Integer year;
    private String genre;
    private Double rating;
}
