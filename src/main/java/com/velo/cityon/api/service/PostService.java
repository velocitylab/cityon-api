package com.velo.cityon.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velo.cityon.api.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

}
