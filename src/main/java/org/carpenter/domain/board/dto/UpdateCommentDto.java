package org.carpenter.domain.board.dto;

import lombok.Data;

@Data
public class UpdateCommentDto {
    private Long id;
    private String content;
}
