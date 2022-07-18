package com.example.springbootwebprojectboard.service;

import com.example.springbootwebprojectboard.dto.BoardDto;
import com.example.springbootwebprojectboard.entity.Board;
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
