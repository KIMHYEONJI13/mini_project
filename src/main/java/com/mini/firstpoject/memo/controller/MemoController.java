package com.mini.firstpoject.memo.controller;

import com.mini.firstpoject.memo.service.MemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/memos")
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    /* 메모 목록 조회 */

    /* 메모 상세 조회 */

    /* 메모 등록 */

    /* 메모 수정 */

    /* 메모 삭제 */


}
