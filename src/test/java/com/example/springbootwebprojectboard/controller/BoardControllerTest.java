package com.example.springbootwebprojectboard.controller;

import com.example.springbootwebprojectboard.entity.Board;
import com.example.springbootwebprojectboard.service.BoardService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(BoardController.class)
class BoardControllerTest {

    @MockBean
    private BoardService boardService;

    @Autowired
    MockMvc mockMvc;

    private Board board;

    @BeforeEach
    void setup() {

        board = Board.builder()
                .id(1L)
                .title("title_1")
                .content("content_1")
                .build();
    }

}