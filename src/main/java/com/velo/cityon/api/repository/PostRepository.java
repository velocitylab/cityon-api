package com.velo.cityon.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.velo.cityon.api.vo.PostVO;

@Repository
public interface PostRepository extends MongoRepository<PostVO, String> {

	@Query("{_id:{ '$gt': ?0 }}")
	List<PostVO> findPrevPosts(String id, Sort sort);

	@Query("{_id:{ '$lt': ?0 }}")
	List<PostVO> findNextPosts(String id, Pageable pageable);
}
