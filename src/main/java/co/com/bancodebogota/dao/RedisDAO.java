package co.com.bancodebogota.dao;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDAO {

	 @Resource(name="redisTemplate")
	 private ListOperations<String, String> opsForList;	 	 
	  
	 public void addFriend(String json, String Key) {
		 opsForList.leftPush(Key, json);
	 }
	 
	 public long getNumberOfFriends(String Key) {
		 return opsForList.size(Key);
	 }
	 
	 public String getFriendAtIndex(Integer index, String Key) {
		 return opsForList.index(Key, index);
	 }
	 
	 public void removeFriend(String json, String Key) {
		 opsForList.remove(Key, 1, json);
	 }
}