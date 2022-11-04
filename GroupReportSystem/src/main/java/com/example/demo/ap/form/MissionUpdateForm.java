package com.example.demo.ap.form;



import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MissionUpdateForm {

    @NotNull(groups=ValidGroup1.class)
    private int missionId;

    @NotBlank(groups=ValidGroup1.class)
    private String missionTitle;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date visitDate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date moveDate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date payDue;


    private String note;
}
