package com.finder.project.company.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Product {
    
    private int productNo;
    private String productName;
    private int productCount;
    private int productPrice;
    private Date productDuration;
    
}
