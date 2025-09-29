package com.uzsoft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightTO implements Serializable {
    private Integer id;
    private String weighingType;
    private String carNumber;
    private String carModel;
    private String productName;
    private String sender;
    private String receiver;
    private String carDriver;
    private String operator;
    private Integer gross;
    private Date grossDate;
    private Integer tare;
    private Date tareDate;
    private Integer net;
}
