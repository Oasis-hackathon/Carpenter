package org.carpenter.domain.board.dto;

import lombok.Data;
import org.carpenter.domain.board.Board;
import org.carpenter.domain.user.Carpenter;

@Data
public class PostBoardDto {
    private String title;
    private String content;
    private Boolean published;
    private Carpenter carpenter;

    public Board toEntity() {
        return Board.builder().title(title).content(content).published(published).carpenter(carpenter).build();
    }
}
