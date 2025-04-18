package com.example.waka.Model;

public class Transaction {
    private String id;
    private String content;
    private String date;
    private int amount;

    public Transaction(String id, String content, String date, int amount) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.amount = amount;
    }

    public String getId() { return id; }
    public String getContent() { return content; }
    public String getDate() { return date; }
    public int getAmount() { return amount; }
}
