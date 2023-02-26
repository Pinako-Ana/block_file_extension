package com.flow.extension_block.domain.extension.service;

public interface CustomExtensionService {

    boolean isExist(String extensionName);

    Integer save(String extensionName);
}
