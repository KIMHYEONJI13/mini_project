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
    private char memoFix;
    private String memoTitle;
    private String memoContent;
    private Timestamp memoCreateDttm;
    private Timestamp memoUpdateDttm;
    private boolean deleteMemo;

    /* 메모장 넣고 싶은 기능
      - 메모지 목록(정렬(등록, 가나다))
      - 메모지 상세
      - 메모번호 no
      - 상단고정 fix
      - 제목 title
      - 내용(꾸미기(에디터)) content
      - 등록일시 createdttm
      - 수정일시 updatedttm
      - 휴지통 trash
      - 삭제일시 deletedttm
      - 복구 restore
      - (사진 등록 수정 삭제)
      - 메모지 색상변경
     */

}
