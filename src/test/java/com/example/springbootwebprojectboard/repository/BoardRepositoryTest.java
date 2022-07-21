package com.example.springbootwebprojectboard.repository;

import com.example.springbootwebprojectboard.entity.Board;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    private Board board1, board2;

    @BeforeEach
    void setup() {

        Board board1 = Board.builder()
                .title("title_1")
                .content("content_1")
                .build();

        Board board2 = Board.builder()
                .title("title_2")
                .content("content_2")
                .build();
    }

    @Test
    void create() {
        // given
        Board saveBoard = boardRepository.save(board1);

        // when

        // then
        assertThat(saveBoard.getTitle()).isEqualTo("title_1");
        assertThat(saveBoard.getContent()).isEqualTo("content_1");
    }
}