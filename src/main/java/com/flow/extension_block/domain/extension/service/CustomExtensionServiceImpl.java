package com.flow.extension_block.domain.extension.service;

import com.flow.extension_block.domain.extension.entity.CustomExtension;
import com.flow.extension_block.domain.extension.repository.CustomExtensionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomExtensionServiceImpl implements CustomExtensionService {
    private final CustomExtensionRepository customExtensionRepository;

    public Integer save(String extensionName) {
        return customExtensionRepository.save(CustomExtension
                .builder()
                .extensionName(extensionName)
                .build()).getSeq();
    }

    public boolean isExist(String extensionName) {
        return customExtensionRepository.existsByExtensionName(extensionName);
    }
}
