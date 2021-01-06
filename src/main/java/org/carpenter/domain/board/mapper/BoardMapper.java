package org.carpenter.domain.board.mapper;

import org.carpenter.config.MapStructConfiguration;
import org.carpenter.domain.board.Board;
import org.carpenter.domain.board.dto.UpdateBoardDto;
import org.carpenter.domain.common.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfiguration.class)
public interface BoardMapper extends EntityMapper<Board, UpdateBoardDto> {
}
