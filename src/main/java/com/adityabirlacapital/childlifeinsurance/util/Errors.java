package com.adityabirlacapital.childlifeinsurance.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Errors {
    private String status;
    private Integer statusCode;
    private String errorCode;
    private String source;
    private List<Message> message;

}

