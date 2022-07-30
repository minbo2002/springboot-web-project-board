package com.example.springbootwebprojectboard.repository;

import com.example.springbootwebprojectboard.entity.Board;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    private Board board1;

    @BeforeEach
    void setup() {

        board1 = Board.builder()
                .id(1L)
                .title("title_1")
                .content("content_1")
                .build();

    }

    @Test
    @Rollback(value = false)
    @Commit
    void create() {
        // given
        Board saveBoard = boardRepository.save(board1);

        log.info("saveBoard :{}", saveBoard);
        // when

        // then
        assertThat(saveBoard.getTitle()).isEqualTo("title_1");
        assertThat(saveBoard.getContent()).isEqualTo("content_1");
    }

    @Test
    void update() {
        // given
        Board saveBoard = boardRepository.save(board1);

        log.info("saveBoard :{}", saveBoard);

        Board updateBoard = Board.builder()
                .id(1L)
                .title("update_title")
                .content("update_content")
                .build();

        // when
        boardRepository.save(updateBoard);

        log.info("updateBoard: {}", updateBoard);

        // then
        assertThat(updateBoard.getTitle()).isEqualTo("update_title");
        assertThat(updateBoard.getContent()).isEqualTo("update_content");
    }

    @Test
    void deleteById() {
        // given
        Board saveBoard = boardRepository.save(board1);
        log.info("saveBoard: {}", saveBoard);

        // when
        boardRepository.delete(saveBoard);
        log.info("deleteBoard: {}", saveBoard);

        Optional<Board> deleteBoard = boardRepository.findById(saveBoard.getId());
        log.info("result :{}", deleteBoard);

        // then
        assertThat(deleteBoard).isEmpty();
    }
}