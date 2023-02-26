package com.flow.extension_block.domain.extension.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(of = {"seq", "extensionName", "isChecked"})
public class FixedExtensionsDto {

    private Integer seq;

    private String extensionName;

    private boolean isChecked;

    @Builder
    public FixedExtensionsDto(Integer seq, String extensionName, boolean isChecked) {
        this.seq = seq;
        this.extensionName = extensionName;
        this.isChecked = isChecked;
    }
}
