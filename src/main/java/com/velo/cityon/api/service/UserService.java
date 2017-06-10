package com.velo.cityon.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velo.cityon.api.repository.UserRepository;
import com.velo.cityon.api.util.Uid;
import com.velo.cityon.api.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public String addUser(UserVO userVo){
		String uid = Uid.getUid();
		userVo.setUid(uid);
		
		userRepository.save(userVo);
		return uid;
	}
	
	
	//get user by mongodb oid
	public UserVO getUserByOid(String uid){
		UserVO userVo = userRepository.findOne(uid);
		return userVo;
	}
	
	public UserVO getUser(String uid){
		UserVO userVo = userRepository.findByUid(uid);
		return userVo;
	}
	
	
	public void deleteUser(String uid){
		UserVO userVo = userRepository.findByUid(uid);
		userRepository.delete(userVo);
	}

	public void addUserCity(String uid, String cityId){
		UserVO userVo = userRepository.findByUid(uid);
		
		List<String> cityList = userVo.getCity();
		if(cityList==null){
			cityList = new ArrayList<String>();
		}
		
		if(!cityList.contains(cityId)){
			cityList.add(cityId);
		}
		userVo.setCity(cityList);
		userRepository.save(userVo);
	}
	
	public void removeUserCity(String uid, String cityId){
		UserVO userVo = userRepository.findByUid(uid);
		
		List<String> cityList = userVo.getCity();
		if(cityList==null){
			return;
		}
		cityList.remove(cityId);
		userVo.setCity(cityList);
		userRepository.save(userVo);
	}
	
}
