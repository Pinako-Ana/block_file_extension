package com.flow.extension_block.domain.extension.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(of = {"seq", "extensionName"})
public class CustomExtensionDto {

    private Integer seq;

    private String extensionName;

    @Builder
    public CustomExtensionDto(Integer seq, String extensionName) {
        this.seq = seq;
        this.extensionName = extensionName;
    }
}
