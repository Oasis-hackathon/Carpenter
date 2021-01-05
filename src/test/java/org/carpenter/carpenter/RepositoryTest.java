package org.carpenter.carpenter;

import org.carpenter.domain.user.Carpenter;
import org.carpenter.domain.user.CarpenterRepository;
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
    private CarpenterRepository carpenterRepository;

    @Test
    public void insertTest() {
        Carpenter carpenter = Carpenter.builder().email("jeongyong95@gmail.com").password("vmfhgod11").username("주정용").nickname("주주").build();
        assertThat(carpenterRepository.save(carpenter));
    }
}
