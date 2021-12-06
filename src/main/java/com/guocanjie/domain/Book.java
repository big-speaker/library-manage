package com.guocanjie.domain;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
public class Book {
    private int id;
    private String type;
    private String name;
    private String descirption;
}
