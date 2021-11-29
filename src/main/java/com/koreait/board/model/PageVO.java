package com.koreait.board.model;

public class PageVO {
    private int record;
    private int sidx;
    private int page;

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public int getSidx() {
        return sidx;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
        this.sidx = (page -1) * record;
    }
}
