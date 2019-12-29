package com.example;

public class Study {

    private String status;
    private Integer limit;

    public Study(Integer limit) {
        if (limit < 10) {
            throw new IllegalArgumentException("아놔 10보다 작다고");
        }
        this.limit = limit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
