package com.mini.firstpoject.memo.service;

import com.mini.firstpoject.memo.dto.MemoDTO;
import com.mini.firstpoject.memo.repository.MemoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class MemoServiceTests {

    @Autowired
    private MemoService memoService;

    @Autowired
    private MemoRepository memoRepository;

    @DisplayName("메모 등록")
    @Test
    void insertMemo() {
        MemoDTO memoInfo = new MemoDTO();
        memoInfo.setMemoTitle("제목1");
        memoInfo.setMemoContent("내용1");
        memoInfo.setMemoFix('N');

        Assertions.assertDoesNotThrow(
                () -> memoService.insertMemo(memoInfo)
        );
    }

    @DisplayName("메모 조회")
    @Test
    void selectMemoList() {

        String memoTitle = "";

        Map<String, Object> memoMap = memoService.selectMemoList(memoTitle);

        Assertions.assertNotNull(memoMap, "Memo Map NULL");

        List<MemoDTO> fixedMemos = (List<MemoDTO>) memoMap.get("fixedMemos");
        List<MemoDTO> normalMemos = (List<MemoDTO>) memoMap.get("normalMemos");

        Assertions.assertNotNull(fixedMemos);
        Assertions.assertNotNull(normalMemos);

        fixedMemos.forEach(System.out::println);
        normalMemos.forEach(System.out::println);
    }

    @DisplayName("메모상세조회")
    @Test
    void selectMemoDetail() {

        int memoNo = 1;

        MemoDTO memoDTO = memoService.selectMemoDetail(memoNo);

        System.out.println("TEST memoDTO : " + memoDTO);

        Assertions.assertNotNull(memoDTO);
    }




}
