package com.finder.project.company.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Order {
    
    private int orderNo;
    private int userNo;
    private int productNo;
    private int totalQuantity;
    private int totalPrice;
    private String orderStatus;
    private Timestamp orderedDate;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private Timestamp expirationDate;

}
