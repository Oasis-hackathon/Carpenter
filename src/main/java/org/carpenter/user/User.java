package org.carpenter.user;

import org.carpenter.board.Board;
import org.carpenter.board.Comment;
import org.carpenter.goal.GoalRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class User {

//    TODO : Embedded Type 적용 고민하기

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String username;
    private String nickname;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    @OneToMany(mappedBy = "user")
    private Set<GoalRoot> rootSet;

    @OneToMany(mappedBy = "user")
    private Set<Board> boardSet;

    @OneToMany(mappedBy = "user")
    private Set<Comment> commentSet;
}
