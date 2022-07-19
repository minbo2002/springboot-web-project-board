package com.example.springbootwebprojectboard.controller;

import com.example.springbootwebprojectboard.dto.BoardDto;
import com.example.springbootwebprojectboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<BoardDto>> getAll() {

        return ResponseEntity.ok(boardService.getAll());
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<BoardDto> getById(@PathVariable Long id) {

        return ResponseEntity.ok(boardService.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody BoardDto boardDto, @PathVariable Long id) {

        log.info("boardDto: {}, id: {}", boardDto, id);

        return ResponseEntity.ok(boardService.update(boardDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        boardService.deleteById(id);

        return ResponseEntity.ok("삭제가 완료되었습니다");
    }
}
