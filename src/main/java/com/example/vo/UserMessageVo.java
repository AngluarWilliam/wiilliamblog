package com.example.vo;

import com.example.entity.MUserMessage;
import lombok.Data;

@Data
public class UserMessageVo extends MUserMessage {

    private String toUserName;
    private String fromUserName;
    private String postTitle;
    private String commentContent;

}
