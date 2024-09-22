package com.mini.firstpoject.memo.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.sql.Timestamp;

@Entity
@Table(name = "tbl_memo")
@Builder(toBuilder = true)
public class Memo {

    @Id
    @Column(name = "memo_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memoNo;

    @Column(name = "memo_fix")
    private char memoFix;

    @Column(name = "memo_title", nullable = true, length = 150)
    private String memoTitle;

    @Column(name = "memo_content", nullable = true)
    private String memoContent;

    @Column(name = "memo_create_dttm", nullable = false)
    private Timestamp memoCreateDttm;

    @Column(name = "memo_update_dttm")
    private Timestamp memoUpdateDttm;

    @Column(name = "delete_memo")
    private boolean deleteMemo;

    protected Memo() {}

    public Memo(int memoNo, char memoFix, String memoTitle, String memoContent, Timestamp memoCreateDttm, Timestamp memoUpdateDttm, boolean deleteMemo) {
        this.memoNo = memoNo;
        this.memoFix = memoFix;
        this.memoTitle = memoTitle;
        this.memoContent = memoContent;
        this.memoCreateDttm = memoCreateDttm;
        this.memoUpdateDttm = memoUpdateDttm;
        this.deleteMemo = deleteMemo;
    }

    public Memo memoFix(char val) {
        this.memoFix = val;
        return this;
    }

    public Memo memoTitle(String val) {
        this.memoTitle = val;
        return this;
    }

    public Memo memoContent(String val) {
        this.memoContent = val;
        return this;
    }

    public Memo memoCreateDttm(Timestamp val) {
        this.memoCreateDttm = val;
        return this;
    }

    public Memo memoUpdateDttm(Timestamp val) {
        this.memoUpdateDttm = val;
        return this;
    }

    public Memo deleteMemo(boolean val) {
        this.deleteMemo = val;
        return this;
    }

    public int getMemoNo() {
        return memoNo;
    }

    public char getMemoFix() { return memoFix; }

    public String getMemoTitle() {
        return memoTitle;
    }

    public String getMemoContent() {
        return memoContent;
    }

    public Timestamp getMemoCreateDttm() {
        return memoCreateDttm;
    }

    public Timestamp getMemoUpdateDttm() {
        return memoUpdateDttm;
    }

    public boolean isDeleteMemo() {
        return deleteMemo;
    }

    @Override
    public String toString() {
        return "Memo{" +
                "memoNo=" + memoNo + '\'' +
                ", memoFix='" + memoFix + '\'' +
                ", memoTitle='" + memoTitle + '\'' +
                ", memoContent='" + memoContent + '\'' +
                ", memoCreateDttm=" + memoCreateDttm +
                ", memoUpdateDttm=" + memoUpdateDttm +
                ", deleteMemo=" + deleteMemo +
                '}';
    }
}
