package com.uzsoft.dto;

import java.util.Date;

public class CarriageWeight {
    private String weightDocNumber;
    private String carriageNumber;
    private Integer gross;
    private Integer tare;
    private Integer net;
    private Date weighingDate;

    public CarriageWeight(String weightDocNumber, String carriageNumber, Integer gross, Integer tare, Integer net) {
        this.weightDocNumber = weightDocNumber;
        this.carriageNumber = carriageNumber;
        this.gross = gross;
        this.tare = tare;
        this.net = net;
    }

    public String getWeightDocNumber() {
        return weightDocNumber;
    }

    public void setWeightDocNumber(String weightDocNumber) {
        this.weightDocNumber = weightDocNumber;
    }

    public String getCarriageNumber() {
        return carriageNumber;
    }

    public void setCarriageNumber(String carriageNumber) {
        this.carriageNumber = carriageNumber;
    }

    public Integer getGross() {
        return gross;
    }

    public void setGross(Integer gross) {
        this.gross = gross;
    }

    public Integer getTare() {
        return tare;
    }

    public void setTare(Integer tare) {
        this.tare = tare;
    }

    public Integer getNet() {
        return net;
    }

    public void setNet(Integer net) {
        this.net = net;
    }

    public Date getWeighingDate() {
        return weighingDate;
    }

    public void setWeighingDate(Date weighingDate) {
        this.weighingDate = weighingDate;
    }

    @Override
    public String toString() {
        return getCarriageNumber() + "_" + getGross() + "_" + getTare() + "_" + getNet();
    }
}
