package org.carpenter.domain.goal.service;

import lombok.RequiredArgsConstructor;
import org.carpenter.domain.goal.GoalNode;
import org.carpenter.domain.goal.GoalNodeRepository;
import org.carpenter.domain.goal.GoalRoot;
import org.carpenter.domain.goal.GoalRootRepository;
import org.carpenter.domain.goal.dto.PostNodeDto;
import org.carpenter.domain.goal.dto.PostRootDto;
import org.carpenter.domain.goal.dto.UpdateNodeDto;
import org.carpenter.domain.goal.dto.UpdateRootDto;
import org.carpenter.domain.goal.mapper.GoalNodeMapper;
import org.carpenter.domain.goal.mapper.GoalRootMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRootRepository rootRepository;
    private final GoalNodeRepository nodeRepository;
    private final GoalRootMapper rootMapper;
    private final GoalNodeMapper nodeMapper;

    @Override
    public UpdateRootDto getRoot(Long id) {
        GoalRoot root = rootRepository.getOne(id);
        return rootMapper.toDto(root);
    }

    @Override
    public void saveRoot(PostRootDto dto) {
    }

    @Override
    public void updateRoot(UpdateRootDto dto) {

    }

    @Override
    public void deleteRoot(Long id) {

    }

    @Override
    public UpdateNodeDto getNode(Long id) {
        GoalNode node = nodeRepository.getOne(id);
        return nodeMapper.toDto(node);
    }

    @Override
    public void saveNode(PostNodeDto dto) {

    }

    @Override
    public void updateNode(UpdateNodeDto dto) {

    }

    @Override
    public void deleteNode(Long id) {

    }
}
