package com.velo.cityon.api.vo.rest;

import java.util.List;

import com.velo.cityon.api.vo.PostVO;

public class PostsResponse extends Response {
	private List<PostVO> newPosts;
	private List<PostVO> posts;

	public List<PostVO> getNewPosts() {
		return newPosts;
	}
	public void setNewPosts(List<PostVO> newPosts) {
		this.newPosts = newPosts;
	}
	public List<PostVO> getPosts() {
		return posts;
	}
	public void setPosts(List<PostVO> posts) {
		this.posts = posts;
	}
}
