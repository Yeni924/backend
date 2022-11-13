package com.mococo.api.account.controller;

import com.mococo.api.account.controller.request.AccountCreateRequest;
import com.mococo.api.account.controller.response.AccountCreateResponse;
import com.mococo.api.account.controller.response.AccountResponse;
import com.mococo.api.account.service.AccountService;
import com.mococo.api.common.constants.UrlConstants;
import java.net.URI;
import javax.validation.Valid;

import com.mococo.api.dto.ApiResponseDto;
import com.mococo.core.account.domain.entity.Account;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping(UrlConstants.ACCOUNTS)
@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final AccountService accountService;

    @PostMapping(path = UrlConstants.JOIN)
    @Operation(summary = "회원가입 (API 토큰 필요없음)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원 가입 성공",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Account.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content) })

    public ResponseEntity<ApiResponseDto<AccountCreateResponse>> join(@Valid @RequestBody AccountCreateRequest request) {

        final AccountCreateResponse response = accountService.create(request);

        final URI createdResourceLocation = UriComponentsBuilder
            .fromPath(UrlConstants.ACCOUNTS + UrlConstants.PATH_ID)
            .buildAndExpand(response.getId())
            .toUri();

        return ResponseEntity.created(createdResourceLocation).body(ApiResponseDto.create(response));
    }

    @GetMapping(UrlConstants.PATH_ID)
    public ResponseEntity<ApiResponseDto<AccountResponse>> get(@PathVariable Long id) {

        final AccountResponse response = accountService.get(id);

        return ResponseEntity.ok(ApiResponseDto.create(response));
    }
}
