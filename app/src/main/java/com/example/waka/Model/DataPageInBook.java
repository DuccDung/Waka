package com.example.waka.Model;

import java.util.List;

public class DataPageInBook {
    private int IdPage; // id Page
    private List<DataBook> Data; // data in page (uri and text)

    public DataPageInBook(int idPage, List<DataBook> data) {
        IdPage = idPage;
        Data = data;
    }

    public int getIdPage() {
        return IdPage;
    }

    public void setIdPage(int idPage) {
        IdPage = idPage;
    }

    public List<DataBook> getData() {
        return Data;
    }

    public void setData(List<DataBook> data) {
        Data = data;
    }
}
