package org.carpenter.domain.board;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.carpenter.domain.board.dto.UpdateCommentDto;
import org.carpenter.domain.common.BaseEntity;
import org.carpenter.domain.user.Carpenter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends BaseEntity {

//    TODO : 비식별 관계 매핑 고민
    @Id
    private Long id;
    private String content;

    @ManyToOne
    private Carpenter carpenter;

    @ManyToOne
    private Board board;

    @Builder
    public Comment(String content, Carpenter carpenter, Board board) {
        this.content = content;
        this.carpenter = carpenter;
        this.board = board;
    }

    void update(UpdateCommentDto dto) {
        this.content = dto.getContent();
    }
}
