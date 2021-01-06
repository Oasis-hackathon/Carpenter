package org.carpenter.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.carpenter.domain.board.CommentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
}
