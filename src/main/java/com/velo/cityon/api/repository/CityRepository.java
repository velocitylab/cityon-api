package com.velo.cityon.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.velo.cityon.api.vo.CityVO;

@Repository
public interface CityRepository extends MongoRepository<CityVO, String> {
	@Query(value="{}", fields="{altname:0}")
	Page<CityVO> findWithoutAltname(Pageable pageable);
}
