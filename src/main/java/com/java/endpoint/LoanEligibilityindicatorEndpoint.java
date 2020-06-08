package com.java.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.java.loaneligibility.Acknowledgement;
import com.java.loaneligibility.CustomerRequest;
import com.java.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityindicatorEndpoint {

	private static final String NAMESPACE = "http://www.java.com/loaneligibility";
	
	@Autowired
	private LoanEligibilityService service;
	
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEligibility(request);
	}
}
