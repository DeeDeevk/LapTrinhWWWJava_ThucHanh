package com.example.nguyenhoviekhoa_tuan3.model;

public class Qualification {
    private String no;
    private String Examination;
    private double per;
    private String yop;

    public Qualification(String no, String examination, double per, String yop) {
        this.no = no;
        Examination = examination;
        this.per = per;
        this.yop = yop;
    };

    public Qualification(){};

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getExamination() {
        return Examination;
    }

    public void setExamination(String examination) {
        Examination = examination;
    }

    public double getPer() {
        return per;
    }

    public void setPer(double per) {
        this.per = per;
    }

    public String getYop() {
        return yop;
    }

    public void setYop(String yop) {
        this.yop = yop;
    }
}
