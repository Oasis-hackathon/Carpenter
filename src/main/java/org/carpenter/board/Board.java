package org.carpenter.board;

import org.carpenter.user.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;

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

    @OneToMany(mappedBy = "board")
    private Set<Comment> commentSet;
}
