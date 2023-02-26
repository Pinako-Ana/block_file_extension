package com.flow.extension_block.global.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Schema(name = "기본 응답 Dto", description = "API 호출 성공시 사용되는 DTO 입니다.")
public class BaseResponseDto<T> {

    @Schema(name = "data", title = "data", description = "결과 값입니다.", defaultValue = "null", nullable = true)
    private final T data;

    @Builder
    public BaseResponseDto(T data) {
        this.data = data;
    }
}
