package com.flow.extension_block.domain.extension.service;

import com.flow.extension_block.domain.extension.service.dto.CustomExtensionDto;

import java.util.List;

public interface CustomExtensionService {

    boolean isExist(String extensionName);

    Integer save(String extensionName);

    List<CustomExtensionDto> getCustomExtensions();
}
