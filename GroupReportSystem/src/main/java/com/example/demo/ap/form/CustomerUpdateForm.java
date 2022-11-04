package com.example.demo.ap.form;



import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class CustomerUpdateForm {


    private int customerId;

    @NotBlank(groups=ValidGroup1.class)
    private String customerCode;

    @NotBlank(groups=ValidGroup1.class)
    private String customerName;


    private String phone;


    private String address;


    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date moveDate;

    @NotNull(groups=ValidGroup1.class)
    private int payState;
}

