package com.mococo.api.account.controller;

import com.mococo.api.account.controller.request.AccountCreateRequest;
import com.mococo.api.account.controller.response.AccountCreateResponse;
import com.mococo.api.account.controller.response.AccountResponse;
import com.mococo.api.account.service.AccountService;
import com.mococo.api.common.constants.UrlConstants;
import com.mococo.api.dto.ApiResponse;
import java.net.URI;
import javax.validation.Valid;
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


    @PostMapping(UrlConstants.JOIN)
    public ResponseEntity<ApiResponse<AccountCreateResponse>> join(@Valid @RequestBody AccountCreateRequest request) {

        final AccountCreateResponse response = accountService.create(request);

        final URI createdResourceLocation = UriComponentsBuilder
            .fromPath(UrlConstants.ACCOUNTS + UrlConstants.PATH_ID)
            .buildAndExpand(response.getId())
            .toUri();

        return ResponseEntity.created(createdResourceLocation).body(ApiResponse.create(response));
    }

    @GetMapping(UrlConstants.PATH_ID)
    public ResponseEntity<ApiResponse<AccountResponse>> get(@PathVariable Long id) {

        final AccountResponse response = accountService.get(id);

        return ResponseEntity.ok(ApiResponse.create(response));
    }
}
