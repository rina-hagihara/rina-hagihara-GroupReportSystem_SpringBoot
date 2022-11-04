package com.example.demo.domain.customer.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Customer {

    private Integer customerId;

    private String customerCode;

    private String customerName;

    private String phone;

    private String address;

    private Date moveDate;

    private Integer payState;
}
