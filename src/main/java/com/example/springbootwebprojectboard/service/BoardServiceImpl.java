package com.example.springbootwebprojectboard.service;

import com.example.springbootwebprojectboard.entity.Board;
import com.example.springbootwebprojectboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public void create(Board board) {

        Board save = boardRepository.save(board);
        log.info("board create : {}", save);
    }
}
