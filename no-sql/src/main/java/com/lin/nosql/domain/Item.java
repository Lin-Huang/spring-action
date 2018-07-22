package com.lin.nosql.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Item implements Serializable {
    private static final long serialVersionUID = 4615276433775698459L;

    private Long id;
    private String product;
    private double price;
    private int quantity;
}
