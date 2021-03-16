package com.xt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName: Email
 * @Version: 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Email {
    private String to;
    private String content;
    private String title;
    private String url;
}
