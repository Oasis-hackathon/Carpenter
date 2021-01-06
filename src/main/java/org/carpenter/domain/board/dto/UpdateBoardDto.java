package org.carpenter.domain.board.dto;

import lombok.Data;

@Data
public class UpdateBoardDto {
    private Long id;
    private String title;
    private String content;
    private Boolean published;
}
