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

import com.SfinderRest.Model.DeviceInfo;

@RestController
public class DeviceInfoController {
	
	public DeviceInfoController() {
		
	}
	
	
	@RequestMapping(
			value = "/api/LoadDevices",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<DeviceInfo>> getAllDevices() {
		
		Session session = StaticResource.sF.openSession();
		session.beginTransaction();
		Criteria cR = session.createCriteria(DeviceInfo.class);
		List<DeviceInfo> Result = (List<DeviceInfo>) cR.list();
		Collection<DeviceInfo> allDevices = Result;
		session.close();

		return new ResponseEntity<Collection<DeviceInfo>>(allDevices, HttpStatus.OK);
		
	}
    
	@RequestMapping(
			value = "/api/LoadDevices/{Username}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<DeviceInfo>> getDevicesByUser(
			@PathVariable("Username") String Username) {
		
		Session session = StaticResource.sF.openSession();
		session.beginTransaction();
		Criteria cR = session.createCriteria(DeviceInfo.class);
		cR.add(Restrictions.eq("Username", Username));
		List<DeviceInfo> Result = (List<DeviceInfo>) cR.list();
		Collection<DeviceInfo> device = Result;
		session.close();

		return new ResponseEntity<Collection<DeviceInfo>>(device, HttpStatus.OK);
		
	}
	
	@RequestMapping(
			value = "/api/UpdateDevice/{DevId}/{Username}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Object>> getDevicesByUser(
			@PathVariable("DevId") String DevId,
			@PathVariable("Username") String Username) {
		
		DeviceInfo di = new DeviceInfo();
		di.setDevId(DevId);
		di.setUsername(Username);
		
		boolean isSuccessful; 
		Session session = StaticResource.sF.openSession();
		
	    try {  
	    	session.beginTransaction();
			session.saveOrUpdate(di);
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
