package org.carpenter.goal;

import org.carpenter.domain.goal.*;
import org.carpenter.domain.goal.dto.PostRootDto;
import org.carpenter.domain.user.Carpenter;
import org.carpenter.domain.user.CarpenterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class RepositoryTest {

    @Resource
    private CarpenterRepository carpenterRepository;
    @Resource
    private GoalRootRepository rootRepository;
    @Resource
    private GoalNodeRepository nodeRepository;
    @Resource
    private CategoryRepository categoryRepository;

    @Test
    public void insertRoot() {
        Carpenter carpenter = carpenterRepository.getOne(1l);
        Category category = categoryRepository.getOne(2l);

        PostRootDto rootDto = new PostRootDto();
        rootDto.setTitle("다이어트 하기!");
        rootDto.setDescription("살을 뺀다 10Kg");
        rootDto.setPublished(Boolean.TRUE);
        rootDto.setStartDate(LocalDate.now());
        rootDto.setEndDate(LocalDate.now().plusMonths(1));
        rootDto.setCategory(category);
        GoalRoot root = rootDto.toEntity(carpenter);
        assertThat(rootRepository.save(root));
    }
}
