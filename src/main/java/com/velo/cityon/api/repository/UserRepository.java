package com.velo.cityon.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.velo.cityon.api.vo.UserVO;

@Repository
public interface UserRepository extends MongoRepository<UserVO, String>{

	@SuppressWarnings("unchecked")
	UserVO save(UserVO userVo);
	
	@Query("{ 'userId' : ?0 }")
	UserVO getUser(String uid);
	
	@Query("{ 'userId' : ?0 }")
	void delete(String uid);
}
