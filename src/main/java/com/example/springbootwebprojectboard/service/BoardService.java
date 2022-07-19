package com.example.springbootwebprojectboard.service;

import com.example.springbootwebprojectboard.dto.BoardDto;
import com.example.springbootwebprojectboard.entity.Board;

import java.util.List;

public interface BoardService{

    BoardDto create(BoardDto boardDto);

    List<BoardDto> getAll();

    BoardDto getById(Long id);

    BoardDto update(BoardDto boardDto, Long id);

    void deleteById(Long id);

    List<Board> selectList(BoardDto parameter);
}
