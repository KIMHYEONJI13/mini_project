package com.mini.firstpoject.memo.service;

import com.mini.firstpoject.memo.dto.MemoDTO;
import com.mini.firstpoject.memo.entity.Memo;
import com.mini.firstpoject.memo.repository.MemoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public Map<String, Object> selectMemoList(String memoTitle) {

        List<Memo> memoList = memoRepository.findAll(Sort.by("memoNo").descending());
        List<Memo> fixedMemos = memoList.stream().filter(memo -> memo.getMemoFix() == 'Y').toList();
        List<Memo> normalMemos = memoList.stream().filter(memo -> memo.getMemoFix() != 'Y').toList();

        if (memoTitle != null && !memoTitle.isEmpty()) {
            normalMemos = normalMemos.stream()
                    .filter(memo -> memo.getMemoTitle().toLowerCase().contains(memoTitle.toLowerCase()))
                    .toList();
        }

        List<MemoDTO> fixesMemoDTOs = fixedMemos.stream()
                .map(memo -> modelMapper.map(memo, MemoDTO.class)).toList();
        List<MemoDTO> normalMemoDTOs = normalMemos.stream()
                .map(memo -> modelMapper.map(memo, MemoDTO.class)).toList();

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("fixedMemos", fixesMemoDTOs);
        responseData.put("normalMemos", normalMemoDTOs);

        return responseData;

    }

    /* 메모 상세 조회 */
    public MemoDTO selectMemoDetail(int memoNo) {

        Memo foundMemo = memoRepository.findById(memoNo).orElse(null);

        if(foundMemo == null) {
            return null;
        }

        MemoDTO memoDTO = modelMapper.map(foundMemo, MemoDTO.class);
        System.out.println("memoDTO : " + memoDTO);

        return memoDTO;
    }

    /* 메모 등록 */
    @Transactional
    public Object insertMemo(MemoDTO memoInfo) {
        try {
            memoInfo.setMemoCreateDttm(new Timestamp(System.currentTimeMillis()));

            Memo memo = modelMapper.map(memoInfo, Memo.class);

            Memo savedMemo = memoRepository.save(memo);
            log.info("~~~~~ 메모 등록 성공 ~~~~~");

            return savedMemo.getMemoNo();
        } catch (Exception e) {
            log.error("메모 등록 실패: {}", e.getMessage(), e);
            return null;
        }
    }

    /* 메모 수정 */


    /* 메모 삭제 */


}
