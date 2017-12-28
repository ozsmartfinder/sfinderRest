package com.SfinderRest.Controller;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.SfinderRest.Model.UserInfo;

@RestController
public class UserInfoController {
	
	public UserInfoController() {
		
	}
	
	@RequestMapping(
			value = "/api/UpdateUser/{Username}/{Password}/{Email}/{Phone}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Object>> getDevicesByUser(
			@PathVariable("Username") String Username,
			@PathVariable("Password") String Password,
			@PathVariable("Email") String Email,
			@PathVariable("Phone") String Phone) {
		
		UserInfo ui = new UserInfo();
		ui.setUsername(Username);
		ui.setPassword(Password);
		ui.setPhone(Phone);
		ui.setEmail(Email);
		
		boolean isSuccessful; 
		Session session = StaticResource.sF.openSession();
		
	    try {  
	    	session.beginTransaction();
			session.saveOrUpdate(ui);
	        session.getTransaction().commit();  
	        isSuccessful = true;  
	    } catch (HibernateException Err) {
	    	System.out.println(Err.getMessage());
	    	isSuccessful = false;
	    } finally {  
	        session.close();  
	        session = null;  
	    }  

		return StaticResource.GetRequestResult(isSuccessful);
	}
	
	//TODO : POST METOD of updating user

}
