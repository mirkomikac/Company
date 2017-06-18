package com.webservice;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.company.wsdl.AccountStatementRequest;
import com.company.wsdl.AccountStatementSectionResponse;
import com.company.wsdl.StatementRequest;

public class AccountStatementWebServiceClient extends WebServiceGatewaySupport{

	public AccountStatementSectionResponse getAccountStatementResponse(AccountStatementRequest request, String serviceUrl){
		AccountStatementSectionResponse response = (AccountStatementSectionResponse) this.getWebServiceTemplate()
			.marshalSendAndReceive(serviceUrl, request, new SoapActionCallback("http://com/xsdSchemas/accountStatementSection"));
		return response;
	}
	
	public boolean sendAccountStatementSectionItem(StatementRequest request){
		Object response = this.getWebServiceTemplate()
			.marshalSendAndReceive("http://localhost:8080/ws/statementService", request);
		if(response == null){
			return false;
		}
		return true;
	}
	
}
