package org.carpenter.domain.board.mapper;

import org.carpenter.config.MapStructConfiguration;
import org.carpenter.domain.board.Comment;
import org.carpenter.domain.board.dto.UpdateCommentDto;
import org.carpenter.domain.common.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfiguration.class)
public interface CommentMapper extends EntityMapper<Comment, UpdateCommentDto> {
}
