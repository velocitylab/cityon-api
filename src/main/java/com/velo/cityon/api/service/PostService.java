package com.velo.cityon.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.velo.cityon.api.repository.PostRepository;
import com.velo.cityon.api.vo.PostDetailVO;
import com.velo.cityon.api.vo.PostVO;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	
	public List<PostVO> getPostList(Integer page, Integer size) throws Exception {
		PageRequest pr = new PageRequest(page, size, new Sort(Sort.Direction.DESC, "_id"));
		return postRepository.findAll(pr).getContent();
	}

	public List<PostVO> getPrevPostList(String id) throws Exception {
		Sort sort = new Sort(Sort.Direction.DESC, "_id");
		return postRepository.findPrevPosts(id, sort);
	}
	
	public List<PostVO> getNextPostList(String id, Integer size) throws Exception {
		PageRequest pr = new PageRequest(0, size, new Sort(Sort.Direction.DESC, "_id"));
		return postRepository.findNextPosts(id, pr);
	}
	
	public PostDetailVO getPostDetail(String id) throws Exception {
		return null;
	}
}
