package com.flow.extension_block.domain.extension.service;

import com.flow.extension_block.domain.extension.service.dto.CustomExtensionDto;

import java.util.List;

public interface CustomExtensionService {

    boolean isExist(String extensionName);

    boolean isExist(Integer extensionSeq);

    Integer save(String extensionName);

    List<CustomExtensionDto> getCustomExtensions();

    void delete(Integer extensionSeq);
}
