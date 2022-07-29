package com.example.springbootwebprojectboard.service;

import com.example.springbootwebprojectboard.entity.Board;
import com.example.springbootwebprojectboard.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
class BoardServiceTest {

    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
    private BoardServiceImpl boardService;

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