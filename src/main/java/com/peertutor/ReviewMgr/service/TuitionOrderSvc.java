package com.peertutor.ReviewMgr.service;

import com.peertutor.ReviewMgr.model.viewmodel.request.TuitionOrderReq;
import com.peertutor.ReviewMgr.repository.ReviewRepository;
import com.peertutor.ReviewMgr.util.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class TuitionOrderSvc {
	@Autowired
	AppConfig appConfig;

	public Long getTuitionOrderId() {
		String url = appConfig.getTuitionOrderMgr().get("url");
		String port = appConfig.getTuitionOrderMgr().get("port");

		String endpoint = url + "/tuitionOrder";
		System.out.println("endpoint" + endpoint);

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		TuitionOrderReq req = new TuitionOrderReq();
		Long tutorOrderId = req.getTutorOrderId();

		HttpEntity<AuthenticationReq> request = new HttpEntity<AuthenticationReq>(req, headers);

		tutorOrderId = restTemplate.postForObject(endpoint, request, Long.class);
		return tutorOrderId;
	}

	public Long getTutorId() {
		String url = appConfig.getTuitionOrderMgr().get("url");
		String port = appConfig.getTuitionOrderMgr().get("port");

		String endpoint = url + "/tuitionOrder";
		System.out.println("endpoint" + endpoint);

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		TuitionOrderReq req = new TuitionOrderReq();
		Long tutorID = req.getTutorId();

		HttpEntity<AuthenticationReq> request = new HttpEntity<AuthenticationReq>(req, headers);

		tutorID = restTemplate.postForObject(endpoint, request, Long.class);
		return tutorID;
	}
}
