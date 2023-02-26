package com.flow.extension_block.domain.extension.controller;


import com.flow.extension_block.domain.extension.service.CustomExtensionService;
import com.flow.extension_block.domain.extension.service.dto.CustomExtensionDto;
import com.flow.extension_block.global.entity.BaseResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/extensions")
public class CustomExtensionController {

    private final CustomExtensionService customExtensionService;

    @Operation(
            summary = "커스텀 확장자 추가 API",
            description = "중복 확인 후 커스텀 확장자를보를 조회합니다.",
            tags = {"custom_extension"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "커스텀 확장자 추가 성공",
                    content = @Content(schema = @Schema(implementation = BaseResponseDto.class))),
            @ApiResponse(
                    responseCode = "409",
                    description = "커스텀 확장자 중복 에러",
                    content = @Content(schema = @Schema(implementation = BaseResponseDto.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "서버 에러",
                    content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    })
    @PostMapping("/custom/{extensionName}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<Void> saveCustomExtension(@PathVariable String extensionName) {
        if (customExtensionService.isExist(extensionName)) {
            throw new IllegalStateException("이미 있는 확장자입니다.");
        }
        customExtensionService.save(extensionName);

        return BaseResponseDto.<Void>builder()
                .build();
    }

    @Operation(
            summary = "커스텀 확장자 조회 API",
            description = "커스텀 확장자 리스트와 정보를 조회합니다.",
            tags = {"custom_extension"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "custom 확장자 조회 성공",
                    content = @Content(schema = @Schema(implementation = BaseResponseDto.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "서버 에러",
                    content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    })
    @GetMapping("/custom")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<List<CustomExtensionDto>> getCustomExtensions() {

        List<CustomExtensionDto> customExtensionDtos = customExtensionService.getCustomExtensions();

        return BaseResponseDto.<List<CustomExtensionDto>>builder()
                .data(customExtensionDtos)
                .build();
    }


}
