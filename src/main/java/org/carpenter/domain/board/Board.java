package org.carpenter.domain.board;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.carpenter.domain.board.dto.UpdateBoardDto;
import org.carpenter.domain.common.BaseEntity;
import org.carpenter.domain.user.Carpenter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Board extends BaseEntity {

    @Id
    private Long id;
    private String title;
    private String content;
    private Boolean published;

    @ManyToOne
    private Carpenter carpenter;

    @OneToMany(mappedBy = "board", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> commentList = new ArrayList<>();

    @Builder
    public Board(String title, String content, Boolean published, Carpenter carpenter) {
        this.title = title;
        this.content = content;
        this.published = published;
        this.carpenter = carpenter;
    }

    void update(UpdateBoardDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.published = dto.getPublished();
    }
}
