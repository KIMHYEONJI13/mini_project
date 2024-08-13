package com.mini.firstpoject.memo.service;

import com.mini.firstpoject.memo.repository.MemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemoService {

    private final MemoRepository memoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MemoService(MemoRepository memoRepository, ModelMapper modelMapper) {
        this.memoRepository = memoRepository;
        this.modelMapper = modelMapper;
    }

    /* 메모 목록 조회 */

    /* 메모 상세 조회 */

    /* 메모 등록 */

    /* 메모 수정 */

    /* 메모 삭제 */


}
