package com.flow.extension_block.domain.extension.repository;

import com.flow.extension_block.domain.extension.entity.CustomExtension;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class CustomExtensionRepositoryTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private CustomExtensionRepository customExtensionRepository;

    @BeforeEach
    void setUp() {
        customExtensionRepository.deleteAll();
        em.flush();
        em.clear();
    }

    @Test
    void getCustomExtensionSizeSuccess() {
        //given
        for (int i = 0; i < 200; i++) {
            customExtensionRepository.save(CustomExtension.builder()
                    .extensionName("test" + i)
                    .build());
        }
        //when
        Integer customExtensionSize = customExtensionRepository.getCustomExtensionSize();

        //then
        assertEquals(customExtensionSize, 200);
    }

    @Test
    public void getCustomExtensionSizeFail() throws IllegalStateException {
        //given
        for (int i = 0; i < 200; i++) {
            customExtensionRepository.save(CustomExtension.builder()
                    .extensionName("test" + i)
                    .build());
        }
        //when
        em.flush();
        em.clear();
        //then
        assertThrows(IllegalStateException.class, () -> {
            customExtensionRepository.save(CustomExtension.builder().extensionName("201").build());
        });
    }
}