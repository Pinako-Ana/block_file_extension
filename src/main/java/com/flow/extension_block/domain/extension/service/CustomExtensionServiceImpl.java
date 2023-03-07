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
public class CustomExtensionServiceImpl {
    private final CustomExtensionRepository customExtensionRepository;

    @Transactional
    public Integer save(String extensionName) {
        if (customExtensionRepository.isDeleted(extensionName)) {
            CustomExtension customExtension = customExtensionRepository.findByDeletedExtensionName(extensionName)
                    .orElseThrow(() -> new IllegalStateException("DB에 이름에 해당하는 확장자가 존재하지 않습니다."));
            customExtension.changeDeleteState();
            return customExtension.getSeq();
        }
        return customExtensionRepository.save(CustomExtension
                .builder()
                .extensionName(extensionName)
                .build()).getSeq();
    }

    public List<CustomExtensionDto> getCustomExtensions() {
        List<CustomExtension> customExtensions = customExtensionRepository.findCustomExtensions();

        return customExtensions.stream().map(customExtension -> CustomExtensionDto
                .builder()
                .seq(customExtension.getSeq())
                .extensionName(customExtension.getExtensionName())
                .build()).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Integer extensionSeq) {
        CustomExtension customExtension = customExtensionRepository.findBySeq(extensionSeq)
                .orElseThrow(() -> new IllegalStateException("이미 삭제된 확장자입니다."));
        customExtension.changeDeleteState();
    }

    public boolean isExist(String extensionName) {
        return customExtensionRepository.existsByExtensionName(extensionName);
    }


    public boolean isExist(Integer extensionSeq) {
        return customExtensionRepository.existsBySeq(extensionSeq);
    }

    public Integer getCustomExtensionsSize() {
        return customExtensionRepository.getCustomExtensionSize();
    }
}
