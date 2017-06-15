package com.webservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class BankClientConfiguration {

	@Bean
	public Jaxb2Marshaller getMarshaller(){
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.company.wsdl");
		return marshaller;
	}
	
	@Bean(name = "accountStatementWebService")
	public AccountStatementWebServiceClient getAccountStatementWebService(Jaxb2Marshaller marshaller){
		AccountStatementWebServiceClient accountStatementWebService = new AccountStatementWebServiceClient();
		accountStatementWebService.setMarshaller(marshaller);
		accountStatementWebService.setUnmarshaller(marshaller);
		return accountStatementWebService;
	}
	
}
