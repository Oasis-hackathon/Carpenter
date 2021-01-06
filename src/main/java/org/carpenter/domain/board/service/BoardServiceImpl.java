package org.carpenter.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.carpenter.domain.board.BoardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
}
