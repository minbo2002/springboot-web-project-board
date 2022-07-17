package com.example.springbootwebprojectboard.controller;

import com.example.springbootwebprojectboard.entity.Board;
import com.example.springbootwebprojectboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String createBoard(Board board) {

        boardService.create(board);

        return "hello";
    }
}
