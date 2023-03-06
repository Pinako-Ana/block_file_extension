package com.flow.extension_block.domain.extension.controller;


import com.flow.extension_block.domain.extension.service.FixedExtensionServiceImpl;
import com.flow.extension_block.domain.extension.service.dto.FixedExtensionsDto;
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
public class FixedExtensionController {

    private final FixedExtensionServiceImpl fixedExtensionService;


    @Operation(
            summary = "고정 확장자 조회 API",
            description = "고정 확장자 리스트와 정보를 조회합니다.",
            tags = {"fixed_extension"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "고정 확장자 조회 성공",
                    content = @Content(schema = @Schema(implementation = BaseResponseDto.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "서버 에러",
                    content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    })
    @GetMapping("/fix")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<List<FixedExtensionsDto>> getFixedExtensions() {

        List<FixedExtensionsDto> fixedExtensionsDto = fixedExtensionService.getFixedExtensions();

        return BaseResponseDto.<List<FixedExtensionsDto>>builder()
                .data(fixedExtensionsDto)
                .build();
    }


    @Operation(
            summary = "고정 확장자 상태 변경 API",
            description = "선택한 고정 확장자의 체크 상태를 변경합니다.",
            tags = {"fixed_extension"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "고정 확장자 변경 성공",
                    content = @Content(schema = @Schema(implementation = BaseResponseDto.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "서버 에러",
                    content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    })
    @PatchMapping("/fix/{extensionSeq}/state")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<Void> changeExtensionState(@PathVariable Integer extensionSeq) {

        fixedExtensionService.changeExtensionState(extensionSeq);

        return BaseResponseDto.<Void>builder()
                .build();
    }


}
