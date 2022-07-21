package com.example.springbootwebprojectboard.service;

import com.example.springbootwebprojectboard.dto.BoardDto;
import com.example.springbootwebprojectboard.entity.Board;
import com.example.springbootwebprojectboard.mapper.BoardMapper;
import com.example.springbootwebprojectboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    @Transactional
    @Override
    public BoardDto create(BoardDto boardDto) {

        Board board = mapToEntity(boardDto);

        Board saveBoard = boardRepository.save(board);

        return mapToDto(saveBoard);

        /*
        BoardDto newBoardDto = mapToDto(saveBoard);
        return newBoardDto;
        */
    }

    @Transactional(readOnly = true)
    @Override
    public List<BoardDto> getAll() {

        List<Board> boards = boardRepository.findAll();

        return boards.stream()
                .map(s -> mapToDto(s))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public BoardDto getById(Long id) {

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return mapToDto(board);
    }

    @Transactional
    @Override
    public BoardDto update(BoardDto boardDto, Long id) {

        Board oldBoard = boardRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        log.info("oldBoard: {}", oldBoard);

        Board newBoard = Board.builder()
                .id(oldBoard.getId())
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .build();

        log.info("new Board: {}", newBoard);

        Board updateBoard = boardRepository.save(newBoard);

        log.info("updateBoard: {}", updateBoard);

        return mapToDto(updateBoard);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        boardRepository.delete(board);
    }

    // Mybatis 방식 전체조회
    @Override
    public List<Board> selectList(BoardDto parameter) {

        return boardMapper.select(parameter);
    }


    private Board mapToEntity(BoardDto boardDto) {

        Board board = Board.builder()
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .build();

        return board;
    }

    private BoardDto mapToDto(Board board) {

        BoardDto boardDto = BoardDto.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .build();

        return boardDto;
    }
}
