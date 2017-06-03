package com.velo.cityon.api.vo.rest;

import com.velo.cityon.api.vo.UserVO;

public class UserResponse extends Response {
	private UserVO user;

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

}
