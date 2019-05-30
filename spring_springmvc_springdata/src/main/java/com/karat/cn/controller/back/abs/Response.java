package com.karat.cn.controller.back.abs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Response {

    private long total = 0;
    private boolean sucflag;
    private String message;
    private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isSucflag() {
        return sucflag;
    }

    public void setSucflag(boolean sucflag) {
        this.sucflag = sucflag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public void setRows(List<Map<String, Object>> rows) {
        this.rows = rows;
    }
}
