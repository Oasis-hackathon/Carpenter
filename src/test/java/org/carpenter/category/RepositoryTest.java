package org.carpenter.category;

import org.carpenter.domain.goal.Category;
import org.carpenter.domain.goal.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class RepositoryTest {

    @Resource
    private CategoryRepository categoryRepository;

    @Test
    public void insertTest() {
        Category category = Category.builder().title("운동").published(Boolean.TRUE).build();
        assertThat(categoryRepository.save(category));
    }
}
