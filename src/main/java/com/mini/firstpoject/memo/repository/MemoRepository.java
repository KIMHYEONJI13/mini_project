package com.mini.firstpoject.memo.repository;

import com.mini.firstpoject.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository <Memo, Integer> {

    List<Memo> findByMemoTitleContainingIgnoreCase(String memoTitle);

}
