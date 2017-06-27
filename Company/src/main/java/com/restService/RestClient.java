package com.restService;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.company.xsdschemas.invoice.InvoiceRequest;

public class RestClient {

	public static String BASE_URL = "https://localhost:9090/InvoiceRestService/getInvoice";

	public void sendInvoice(InvoiceRequest request){
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			String baseUrl = request.getPurchaser().getUrlInvoiceService();
			InvoiceRequest requestIsti = (InvoiceRequest) restTemplate
					.postForObject(baseUrl, request, InvoiceRequest.class);
			System.out.println(requestIsti.toString() + " OJSAAAAA");
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
