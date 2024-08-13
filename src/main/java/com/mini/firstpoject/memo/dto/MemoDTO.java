package com.mini.firstpoject.memo.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemoDTO {

    private int memoNo;
    private String memoTitle;
    private String memoContent;
    private Timestamp memoCreateDttm;
    private Timestamp memoUpdateDttm;
    private boolean deleteMemo;

}
