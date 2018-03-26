package com.narayana.IsotoncHyponatremia;

import java.util.Arrays;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Repository
public class IsotonicHyponatermiaImpl implements IsotonicHyponatermiaRepository {

	public static final String HYPONATERMIA_SERVICE_URL = "http://HYPONATEMIA";
	public static final String ISOTONIC_SERVICE_URL = "http://ISOTONICITY";
	protected RestTemplate restTemplate;

	

	@Override
	public String getIsotonicHyponatermia(String serumSodium, String serumOsmol) {
		String hyponatermia = restTemplate.getForObject(HYPONATERMIA_SERVICE_URL+"/hyponatemia/{serumSodium}",String.class);
		if(hyponatermia.equalsIgnoreCase("hyponatemia")) {
			String hypertonicity = restTemplate.getForObject(ISOTONIC_SERVICE_URL+"/Isotonicty/{serumOsmol}",String.class);
			if(hypertonicity.equalsIgnoreCase("isotonic")) {
				return "isotonichyponatermia";
			}
			else {
				return "notisotonichyponatermia";
			}
		}
		else {
			return "notisotonichyponatermia";
		}
	}

	

}
