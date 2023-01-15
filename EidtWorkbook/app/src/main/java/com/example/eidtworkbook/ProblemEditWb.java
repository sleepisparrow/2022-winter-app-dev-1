package com.example.eidtworkbook;

public class ProblemEditWb {
    private String title;
    private String text; // 문제 지문
    private int number;

    ProblemEditWb(String title, String text, int number) {
        this.title = title;
        this.text = text;
        this.number = number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }
}
