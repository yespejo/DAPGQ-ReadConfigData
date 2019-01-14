package co.com.bancodebogota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.com.bancodebogota.dao.RedisDAO;

@SpringBootApplication
public class SpringBootAppStarter implements CommandLineRunner {
	@Autowired
	private RedisDAO redisDAO;
	
    public static void main(String[] args) throws Exception {
       SpringApplication.run(SpringBootAppStarter.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
    	System.out.println("--Example of ListOperations--");
    	redisDAO.addFriend("{dddd:11}", "Entidad");
    	redisDAO.addFriend("{dddd:22}", "Entidad");
    	System.out.println("Number of friends: " + redisDAO.getNumberOfFriends("Entidad"));
    	System.out.println(redisDAO.getFriendAtIndex(1,"Entidad"));
    	redisDAO.removeFriend("{dddd:22}","Entidad");
    	System.out.println(redisDAO.getFriendAtIndex(1,"Entidad"));           	   
    }
}