package com.velo.cityon.api.service;

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
	
	public UserVO getUser(String uid){
		UserVO userVo = userRepository.getUser(uid);
		return userVo;
	}
	
	public void deleteUser(String uid){
		userRepository.delete(uid);
	}
}
