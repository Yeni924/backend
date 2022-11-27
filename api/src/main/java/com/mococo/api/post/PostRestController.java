package com.mococo.api.post;

import com.mococo.api.account.controller.response.AccountCreateResponse;
import com.mococo.api.common.constants.UrlConstants;
import com.mococo.api.common.exception.ErrorResponse;
import com.mococo.api.dto.ApiResponseDto;
import com.mococo.api.dto.BaseResponse;
import com.mococo.api.post.controller.request.PostCreateRequest;
import com.mococo.api.post.controller.response.PostCreateResponse;
import com.mococo.api.post.controller.response.PostGetResponse;
import com.mococo.api.post.controller.response.PostGetsResponse;
import com.mococo.api.post.service.PostService;
import com.mococo.core.post.domain.entity.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequestMapping(UrlConstants.Post)
@RestController
@RequiredArgsConstructor
public class PostRestController {

    private final PostService postService;

    @GetMapping(path = UrlConstants.GET_POSTS)
    @Operation(summary = "포스트 목록 조회 (수정 중)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "포스트 목록 조회", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PostGetResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "포스트 목록 조회 실패", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) )})
    public  ResponseEntity<ApiResponseDto<List<PostGetResponse>>> getPosts(Pageable pageable) {

        final var response = postService.gets(pageable);

        final URI createdResourceLocation = UriComponentsBuilder
                .fromPath(UrlConstants.GET_POSTS)
                .buildAndExpand()
                .toUri();

        return ResponseEntity.created(createdResourceLocation).body(ApiResponseDto.create(response));
    }


    @GetMapping(path = UrlConstants.GET_POST)
    @Operation(summary = "포스트 조회 (수정 중)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "포스트 목록 조회", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PostGetResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "포스트 목록 조회 실패", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) )})
    public  ResponseEntity<ApiResponseDto<PostGetResponse>> getPosts(@Parameter(name = "id", description = "post 의 id", in = ParameterIn.PATH) Long postID) {

        final var response = postService.get(postID);

        final URI createdResourceLocation = UriComponentsBuilder
                .fromPath(UrlConstants.GET_POST)
                .buildAndExpand()
                .toUri();

        return ResponseEntity.created(createdResourceLocation).body(ApiResponseDto.create(response));
    }

    @PostMapping(path = UrlConstants.CreatePost)
    @Operation(summary = "게시글 create / 필터 구현 해야함")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "게시물 생성", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PostCreateResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "게시물 생성 실패", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) )})
    public ResponseEntity<ApiResponseDto<PostCreateResponse>> create(@Valid @RequestBody PostCreateRequest request) {

        final PostCreateResponse response = postService.create(request);

        final URI createdResourceLocation = UriComponentsBuilder
                .fromPath(UrlConstants.CreatePost)
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(createdResourceLocation).body(ApiResponseDto.create(response));
    }

}
