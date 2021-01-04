package org.carpenter.domain.board;

import lombok.Getter;
import org.carpenter.domain.user.Carpenter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private Carpenter carpenter;

    @OneToMany(mappedBy = "board", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> commentList = new ArrayList<>();
}
