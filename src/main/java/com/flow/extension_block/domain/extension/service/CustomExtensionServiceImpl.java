package com.flow.extension_block.domain.extension.service;

import com.flow.extension_block.domain.extension.entity.CustomExtension;
import com.flow.extension_block.domain.extension.repository.CustomExtensionRepository;
import com.flow.extension_block.domain.extension.service.dto.CustomExtensionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomExtensionServiceImpl implements CustomExtensionService {
    private final CustomExtensionRepository customExtensionRepository;

    @Override
    public Integer save(String extensionName) {
        return customExtensionRepository.save(CustomExtension
                .builder()
                .extensionName(extensionName)
                .build()).getSeq();
    }

    @Override
    public List<CustomExtensionDto> getCustomExtensions() {
        List<CustomExtension> customExtensions = customExtensionRepository.findCustomExtensions();

        return customExtensions.stream().map(customExtension -> CustomExtensionDto
                .builder()
                .seq(customExtension.getSeq())
                .extensionName(customExtension.getExtensionName())
                .build()).collect(Collectors.toList());
    }

    @Override
    public boolean isExist(String extensionName) {
        return customExtensionRepository.existsByExtensionName(extensionName);
    }
}
