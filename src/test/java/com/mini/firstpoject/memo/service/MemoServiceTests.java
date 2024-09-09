package com.mini.firstpoject.memo.service;

import com.mini.firstpoject.memo.repository.MemoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

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


    }





}
