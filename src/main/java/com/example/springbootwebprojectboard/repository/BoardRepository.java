package com.example.springbootwebprojectboard.repository;

import com.example.springbootwebprojectboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
