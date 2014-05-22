package com.mypack.hashes;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	
	
	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	
	public void saveUser(){
			Map<String,String> usrMap = new  HashMap<String,String>();
	        usrMap.put("name","cz");
	        usrMap.put("age","12");
	
			HashOperations<String,String,String> userHo = redisTemplate.opsForHash();
			userHo.putAll("user:111111", usrMap);
			
		
	}
	
	
	public void getUser(){
		HashOperations<String,String,String> userHo = redisTemplate.opsForHash();
		Map<String,String> userMap = userHo.entries("user:111111");
		System.out.println(userMap.get("name")+"######"+userMap.get("age"));

	}
}
