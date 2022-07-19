package com.example.springbootwebprojectboard.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDto {

    private String title;
    private String content;

    @Builder
    public BoardDto(String title, String content) {

        this.title = title;
        this.content = content;
    }
}
