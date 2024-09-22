package com.mini.firstpoject.memo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MemoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private RequestBuilder request;

    @DisplayName("메모등록")
    @Test
    void insertMemo() throws Exception {

        request = MockMvcRequestBuilders.multipart(HttpMethod.POST, "/memos")
                .param("memo.memoNo", "1")
                .param("memo.memoTitle", "메모등록")
                .param("memo.memoContent", "메모내용");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());

    }


}
