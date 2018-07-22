package com.lin.nosql.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 3873270149045937907L;

    @Id
    private String id;
    private String customer;
    private String type;
    private List<Item> items;
}
