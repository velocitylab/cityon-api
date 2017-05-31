package com.velo.cityon.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.velo.cityon.api.service.PostService;
import com.velo.cityon.api.vo.PostDetailVO;
import com.velo.cityon.api.vo.PostVO;
import com.velo.cityon.api.vo.rest.PostResponse;
import com.velo.cityon.api.vo.rest.PostsResponse;

@RestController
@RequestMapping("/v1/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/_list", method=RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public PostsResponse getPostList(
			@RequestParam(value="page", required=false, defaultValue="0") Integer page,
			@RequestParam(value="size", required=false, defaultValue="10") Integer size,
			@RequestParam(value="first", required=false) String first,
			@RequestParam(value="last", required=false) String last) throws Exception {
		
		List<PostVO> newPosts = null;
		List<PostVO> posts = null;
		
		if(first == null && last == null) {
			posts = postService.getPostList(page, size);
		}
		else {
			if(first != null) {
				newPosts = postService.getPrevPostList(first);
			}
			if(last != null) {
				posts = postService.getNextPostList(last, size);
			}
		}

		PostsResponse resp = new PostsResponse();
		resp.setNewPosts(newPosts);
		resp.setPosts(posts);
		return resp;
	}

	@RequestMapping(value="/{postId}", method=RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public PostResponse getPostDetail(
			@PathVariable(required=true) String postId) throws Exception {

		PostDetailVO post = postService.getPostDetail(postId);

		PostResponse resp = new PostResponse();
		resp.setPost(post);
		return resp;
	}

}
