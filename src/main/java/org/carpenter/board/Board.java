package org.carpenter.board;

import lombok.Getter;
import org.carpenter.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Entity
public class Board {

    @Id
    private Long id;
    private String title;
    private String content;
    private Boolean published;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "board", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Comment> commentSet;
}
