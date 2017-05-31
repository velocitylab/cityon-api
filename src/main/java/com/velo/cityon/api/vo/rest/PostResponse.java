package com.velo.cityon.api.vo.rest;

import com.velo.cityon.api.vo.PostDetailVO;

public class PostResponse extends Response {
	private PostDetailVO post;

	public PostDetailVO getPost() {
		return post;
	}
	public void setPost(PostDetailVO post) {
		this.post = post;
	}
	
}
