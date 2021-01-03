package org.carpenter.board;

import lombok.Getter;
import org.carpenter.user.User;

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
    private User user;

    @ManyToOne
    private Board board;
}
