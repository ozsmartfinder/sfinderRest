package com.SfinderRest.Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.SfinderRest.Model.RequestResult;

public class StaticResource {
	public static SessionFactory sF = new Configuration().configure().buildSessionFactory();
	
	public static ResponseEntity<Collection<Object>> GetRequestResult(boolean IsSuccessful) {
		if (IsSuccessful == false) {
        	RequestResult requestResult = new RequestResult();
        	requestResult.setIsSuccessful(false);
        	Map<Integer, Object> rm = new HashMap<Integer, Object>();
        	rm.put(-1, requestResult);
            return new ResponseEntity<Collection<Object>>((Collection<Object>)rm.values(), HttpStatus.OK);
        }
    	
        RequestResult requestResult = new RequestResult();
    	requestResult.setIsSuccessful(true);
    	Map<Integer, Object> rm = new HashMap<Integer, Object>();
    	rm.put(-1, requestResult);
        return new ResponseEntity<Collection<Object>>((Collection<Object>)rm.values(), HttpStatus.OK);
	}
}
