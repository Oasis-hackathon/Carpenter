package org.carpenter.domain.board;

import lombok.Getter;
import org.carpenter.domain.user.Carpenter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Entity
public class Comment {

//    TODO : 비식별 관계 매핑 고민
    @Id
    private Long id;
    private String content;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    @ManyToOne
    private Carpenter carpenter;

    @ManyToOne
    private Board board;
}