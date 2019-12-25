package com.ksh980212.springboot.web;

import com.ksh980212.springboot.web.dto.PostsResponseDto;
import com.ksh980212.springboot.web.dto.PostsSaveRequestDto;
import com.ksh980212.springboot.web.dto.PostsUpdateRequestDto;
import com.ksh980212.springboot.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

  private final PostsService postsService;

  @PostMapping("/api/v1/posts")
  public Long save(@RequestBody PostsSaveRequestDto requestDto){
    return postsService.save(requestDto);
  }

  @PutMapping("/api/v1/posts/{id}")
  public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
    return postsService.update(id, requestDto);
  }

  @GetMapping("/api/v1/posts/{id}")
  public PostsResponseDto findById (@PathVariable Long id){
    return postsService.findById(id);
  }

  @DeleteMapping("/api/v1/posts/{id}")
  public Long delete (@PathVariable Long id){
    postsService.delete(id);
    return id;
  }
}
