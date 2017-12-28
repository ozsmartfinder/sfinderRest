package com.SfinderRest.Controller;

import java.util.Collection;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SfinderRest.Model.DeviceInfoHistory;

@RestController
public class DeviceInfoHistoryController {
	
	public DeviceInfoHistoryController() {
		
	}
	
	@RequestMapping(
			value = "/api/LoadDevicesHistory/{Username}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<DeviceInfoHistory>> getDevicesByUser(
			@PathVariable("Username") String Username) {
		
		Session session = StaticResource.sF.openSession();
		session.beginTransaction();
		Criteria cR = session.createCriteria(DeviceInfoHistory.class);
		cR.add(Restrictions.eq("Username", Username));
		List<DeviceInfoHistory> Result = (List<DeviceInfoHistory>) cR.list();
		Collection<DeviceInfoHistory> device = Result;
		session.close();

		return new ResponseEntity<Collection<DeviceInfoHistory>>(device, HttpStatus.OK);
		
	}

}
