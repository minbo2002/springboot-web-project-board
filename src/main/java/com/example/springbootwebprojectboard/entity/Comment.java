package com.example.springbootwebprojectboard.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "board")  // 해당변수 toString 제외  (lazy loading에서 필수)
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String replyer;

    @Column(nullable = false)
    private String replyconent;

    @Builder
    public Comment(Long id, String replyer, String replyconent, Board board) {
        this.id = id;
        this.replyer = replyer;
        this.replyconent = replyconent;
        this.board = board;
    }

    @ManyToOne
    private Board board;
}
