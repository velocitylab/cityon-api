package com.velo.cityon.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velo.cityon.api.service.PostService;

@RestController
@RequestMapping("/v1/post")
public class PostController {
	
	@Autowired
	private PostService postService;

}
