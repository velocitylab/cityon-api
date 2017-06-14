package com.velo.cityon.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.velo.cityon.api.vo.PostVO;

@Repository
public interface PostRepository extends MongoRepository<PostVO, String> {
	Page<PostVO> findByCityId(String cityId, Pageable pageable);

	@Query("{cityId: ?0, _id:{ '$gt': ?1 }}")
	List<PostVO> findPrevPosts(String cityId, String id, Sort sort);

	@Query("{cityId: ?0, _id:{ '$lt': ?1 }}")
	List<PostVO> findNextPosts(String cityId, String id, Pageable pageable);
}
