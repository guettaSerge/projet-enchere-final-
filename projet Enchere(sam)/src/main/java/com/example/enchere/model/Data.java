package com.example.enchere.model;

public class Data {
    private Object data;
    private Exception error;

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }

    public Object getData() {

        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
