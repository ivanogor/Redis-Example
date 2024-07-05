package com.example.webapplicationwithredis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Book")
public class Book implements Serializable {
    private Long id;
    private String title;
    private String author;
    private int year;
}
