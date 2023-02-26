package com.flow.extension_block.domain.extension.service;

import com.flow.extension_block.domain.extension.repository.FixedRepository;
import com.flow.extension_block.domain.extension.service.dto.FixedExtensionsDto;
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
public class FixedExtensionServiceImpl implements FixedExtensionService {

    private final FixedRepository fixedRepository;

    @Override
    public List<FixedExtensionsDto> getFixedExtensions() {
        return fixedRepository.findFixedExtensions().stream().map(fixedExtension -> FixedExtensionsDto
                        .builder()
                        .seq(fixedExtension.getSeq())
                        .extensionName(fixedExtension.getExtensionName())
                        .isChecked(fixedExtension.isChecked()).build())
                .collect(Collectors.toList());
    }
}
