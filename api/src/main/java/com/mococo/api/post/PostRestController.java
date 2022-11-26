package com.mococo.api.post;

import com.mococo.api.common.constants.UrlConstants;
import com.mococo.api.dto.ApiResponseDto;
import com.mococo.api.post.controller.request.PostCreateRequest;
import com.mococo.api.post.controller.response.PostCreateResponse;
import com.mococo.api.post.service.PostService;
import com.mococo.core.post.domain.entity.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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

    @GetMapping(path = UrlConstants.GetPosts)
    @Operation(summary = "포스트 목록 조회 (수정 중)")
    public  ResponseEntity<ApiResponseDto<List<Post>>> getPosts(Pageable pageable) {

        final List<Post> response = postService.gets(pageable);

        final URI createdResourceLocation = UriComponentsBuilder
                .fromPath(UrlConstants.GetPosts)
                .buildAndExpand()
                .toUri();

        return ResponseEntity.created(createdResourceLocation).body(ApiResponseDto.create(response));


    }

    @PostMapping(path = UrlConstants.CreatePost)
    @Operation(summary = "게시글 create")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "create success", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Post.class)) }),
            @ApiResponse(responseCode = "400", description = "create  fail", content = @Content)})
    public ResponseEntity<ApiResponseDto<PostCreateResponse>> create(@Valid @RequestBody PostCreateRequest request) {

        final PostCreateResponse response = postService.create(request);

        final URI createdResourceLocation = UriComponentsBuilder
                .fromPath(UrlConstants.CreatePost)
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(createdResourceLocation).body(ApiResponseDto.create(response));
    }

}
