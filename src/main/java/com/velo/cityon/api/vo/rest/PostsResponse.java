package com.velo.cityon.api.vo.rest;

import java.util.List;

import com.velo.cityon.api.vo.PostVO;

public class PostsResponse extends Response {
	private List<PostVO> posts;
	private List<PostVO> prevPosts;
	private List<PostVO> nextPosts;

	public List<PostVO> getPosts() {
		return posts;
	}
	public void setPosts(List<PostVO> posts) {
		this.posts = posts;
	}
	public List<PostVO> getPrevPosts() {
		return prevPosts;
	}
	public void setPrevPosts(List<PostVO> prevPosts) {
		this.prevPosts = prevPosts;
	}
	public List<PostVO> getNextPosts() {
		return nextPosts;
	}
	public void setNextPosts(List<PostVO> nextPosts) {
		this.nextPosts = nextPosts;
	}
}
