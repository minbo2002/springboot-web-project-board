package com.example.springbootwebprojectboard.mapper;

import com.example.springbootwebprojectboard.dto.BoardDto;
import com.example.springbootwebprojectboard.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> select(BoardDto parameter);
}
