package com.velo.cityon.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.velo.cityon.api.service.UserService;
import com.velo.cityon.api.vo.UserVO;
import com.velo.cityon.api.vo.rest.Response;
import com.velo.cityon.api.vo.rest.UserIdResponse;
import com.velo.cityon.api.vo.rest.UserResponse;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="", method=RequestMethod.POST, produces={"application/json; charset=UTF-8"} )
	@ResponseBody
	public UserIdResponse addUser(@RequestBody UserVO userBody)  throws Exception {
		
		String uid = userService.addUser(userBody);
		UserIdResponse resp = new UserIdResponse();
		resp.setUserId(uid);
		return resp;
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET, produces={"application/json; charset=UTF-8"} )
	@ResponseBody
	public UserResponse getUser(@PathVariable(required=true) String userId)  throws Exception {
		
		UserVO userVo = userService.getUser(userId);
		UserResponse resp = new UserResponse();
		resp.setUser(userVo);
		return resp;
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.DELETE, produces={"application/json; charset=UTF-8"} )
	@ResponseBody
	public Response deleteUser(@PathVariable(required=true) String userId)  throws Exception {
		
		userService.deleteUser(userId);
		Response resp = new Response();
		return resp;
	}

}
