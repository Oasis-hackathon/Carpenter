package org.carpenter.recommend;

import kr.co.shineware.nlp.komoran.core.Komoran;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class KomoranTest {

    @Resource
    private Komoran komoran;

    @Test
    void getNounsToString() {
        String nouns = komoran.analyze("부산과 바다는 아름다워.").getNouns().get(0);
        assertEquals("부산", nouns);
    }
}
