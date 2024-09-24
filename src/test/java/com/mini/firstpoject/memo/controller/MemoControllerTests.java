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

    @DisplayName("메모목록조회")
    @Test
    void selectMemoList() throws Exception {

        String search = "";

        request = MockMvcRequestBuilders.get("/memos?search=" + search);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("메모상세조회")
    @Test
    void selectMemoDetail() throws Exception {
        int memoNo = 1;

        request = MockMvcRequestBuilders.get("/memos/" + memoNo);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("메모수정")
    @Test
    void updateMemo() throws Exception {
        int memoNo = 1;
        String updateMemo = "{\"action\": \"수정\", \"refusal\": \"수정제목\"}";

        request = MockMvcRequestBuilders.put("/memos/" + memoNo)
                .contentType(updateMemo);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("메모삭제")
    @Test
    void deleteMemo() throws Exception {
        int memoNo = 1;

        request = MockMvcRequestBuilders.delete("/memos/" + memoNo);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

}
