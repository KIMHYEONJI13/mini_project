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

    /* 메모장 넣고 싶은 기능
      - 메모지 색상변경
      - 메모지 목록
      - 메모지 상세
      - 상단고정
      - 제목
      - 내용
      - 등록일시
      - 수정일시
      - 휴지통
      - 삭제일시
      - 복구()
      - 내용입력 및 꾸미기(에디터)
      - 사진 등록 수정 삭제
     */

}
