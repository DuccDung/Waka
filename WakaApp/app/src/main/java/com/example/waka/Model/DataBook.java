package com.example.waka.Model;

import android.net.Uri;

public class DataBook {
    private String content; // uri or text
    private Uri uri;
    private Boolean type; // 0 là uri, 1 là text

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DataBook(String content) {
        this.content = content;
    }

    public DataBook(Uri uri) {
        this.uri = uri;
    }
}
