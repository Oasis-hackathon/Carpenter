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

@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class GoalTest {

    @Resource
    private CarpenterRepository carpenterRepository;
    @Resource
    private CategoryRepository categoryRepository;
    @Resource
    private GoalRootRepository rootRepository;
    @Resource
    private GoalNodeRepository nodeRepository;

    @Test
    public void insertRoot() {
        Carpenter carpenter = carpenterRepository.findByEmail("jeongyong95@gmail.com").get();
        Category category = categoryRepository.save(Category.builder().title("운동").published(Boolean.TRUE).build());

        PostRootDto rootDto = new PostRootDto();
        rootDto.setTitle("다이어트 하기!");
        rootDto.setDescription("살을 뺀다 10Kg");
        rootDto.setPublished(Boolean.TRUE);
        rootDto.setStartDate(LocalDate.now());
        rootDto.setEndDate(LocalDate.now().plusMonths(1));
        rootDto.setCategory(category);
        GoalRoot root = rootDto.toEntity(carpenter);
        rootRepository.save(root);
    }
}
