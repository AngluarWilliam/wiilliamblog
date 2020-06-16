package com.example.vo;

import com.example.entity.MComment;
import lombok.Data;

@Data
public class CommentVo extends MComment {

    private Long authorId;
    private String authorName;
    private String authorAvatar;

}
