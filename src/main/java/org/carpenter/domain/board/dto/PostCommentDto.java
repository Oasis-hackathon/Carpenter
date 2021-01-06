package org.carpenter.domain.board.dto;

import lombok.Data;
import org.carpenter.domain.board.Board;
import org.carpenter.domain.board.Comment;
import org.carpenter.domain.user.Carpenter;

@Data
public class PostCommentDto {
    private String content;
    private Carpenter carpenter;
    private Board board;

    public Comment toEntity() {
        return Comment.builder().content(content).carpenter(carpenter).board(board).build();
    }
}
