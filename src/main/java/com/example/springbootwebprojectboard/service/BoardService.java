package com.example.springbootwebprojectboard.service;

import com.example.springbootwebprojectboard.dto.BoardDto;

import java.util.List;

public interface BoardService{

    BoardDto create(BoardDto boardDto);

    List<BoardDto> getAll();

    BoardDto getById(Long id);
}
