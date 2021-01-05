package org.carpenter.domain.goal.service;

import org.carpenter.domain.goal.dto.PostNodeDto;
import org.carpenter.domain.goal.dto.PostRootDto;
import org.carpenter.domain.goal.dto.UpdateNodeDto;
import org.carpenter.domain.goal.dto.UpdateRootDto;

public interface GoalService {

    UpdateRootDto getRoot(Long id);

    void saveRoot(PostRootDto dto);

    void updateRoot(UpdateRootDto dto);

    void deleteRoot(Long id);

    UpdateNodeDto getNode(Long id);

    void saveNode(PostNodeDto dto);

    void updateNode(UpdateNodeDto dto);

    void deleteNode(Long id);
}
