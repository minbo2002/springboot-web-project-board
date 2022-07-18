package com.example.springbootwebprojectboard.controller;

import com.example.springbootwebprojectboard.dto.BoardDto;
import com.example.springbootwebprojectboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/create")
    public ResponseEntity<BoardDto> create(@RequestBody BoardDto boardDto) {

        log.info("boardDto: {}", boardDto);

        BoardDto newBoardDto = boardService.create(boardDto);

        return new ResponseEntity<>(newBoardDto, HttpStatus.CREATED);

        /*
        return new ResponseEntity<>(boardService.create(boardDto), HttpStatus.CREATED);
         */
    }
}
