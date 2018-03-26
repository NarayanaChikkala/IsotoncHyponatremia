package com.narayana.IsotoncHyponatremia;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IsotonicHyponatermiaController {
	
	protected Logger logger = Logger
			.getLogger(IsotonicHyponatermiaController.class.getName());
	
	@Autowired
	IsotonicHyponatermiaRepository isotonicHyponatermiaRepository;
	
	@RequestMapping("/IsotonicHyponatermia/{SerumSodium}/{SerumOsmol}")
	public String IsotoncHyponatermia(@PathVariable("SerumSodium") String SerumSodium,@PathVariable("SerumOsmol") String SerumOsmol) {
		logger.info("accounts-changed byId() invoked: " + SerumOsmol);
		String retVal = isotonicHyponatermiaRepository.getIsotonicHyponatermia(SerumSodium,SerumOsmol);
		logger.info("accounts-microservice byId() found: " + retVal);
		return retVal;
	}

}
