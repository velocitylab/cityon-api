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
	
	@RequestMapping(value="/_new", method=RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public PostsResponse getNewPosts(
			@RequestParam(value="cityId", required=true) String cityId,
			@RequestParam(value="size", required=false, defaultValue="10") Integer size) throws Exception {
		
		List<PostVO> posts = postService.getPostList(cityId, 0, size);

		PostsResponse resp = new PostsResponse();
		resp.setPosts(posts);
		return resp;
	}

	@RequestMapping(value="/_more", method=RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public PostsResponse getMorePosts(
			@RequestParam(value="cityId", required=true) String cityId,
			@RequestParam(value="first", required=false) String first,
			@RequestParam(value="last", required=false) String last,
			@RequestParam(value="size", required=false, defaultValue="10") Integer size) throws Exception {
		
		List<PostVO> prevPosts = null;
		List<PostVO> nextPosts = null;
		
		if(first == null && last == null) {
			throw new Exception("require first or last");
		}
		if(first != null) {
			prevPosts = postService.getPrevPostList(cityId, first);
		}
		if(last != null) {
			nextPosts = postService.getNextPostList(cityId, last, size);
		}

		PostsResponse resp = new PostsResponse();
		resp.setPrevPosts(prevPosts);
		resp.setNextPosts(nextPosts);
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
