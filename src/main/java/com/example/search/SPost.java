package com.example.search;

import lombok.Data;

import java.util.Date;

@Data
public class SPost {
    private Long id;

    private String title;

    private Long authorId;

    private String authorName;
    private String authorAvatar;

    private Long categoryId;
    private String categoryName;

    private Integer level;
    private Boolean recomment;

    private Integer commentCount;
    private Integer viewCount;

    private Date created;
}
