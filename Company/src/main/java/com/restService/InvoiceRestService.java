package com.restService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.xsdschemas.invoice.InvoiceRequest;
import com.company.xsdschemas.invoiceitem.InvoiceItem;
import com.service.InvoiceItemServiceImpl;
import com.service.InvoiceServiceImpl;

@RestController
@RequestMapping("/InvoiceRestService")
public class InvoiceRestService {
	
	@Autowired
	private InvoiceServiceImpl invoiceServiceImpl;
	
	@Autowired
	private InvoiceItemServiceImpl invoiceItemServiceImpl;

	@RequestMapping(path="/getInvoice", method=RequestMethod.POST)
	@ResponseBody
	public InvoiceRequest getInvoice(@RequestBody InvoiceRequest request){
		ArrayList<InvoiceItem> invoiceItems = new ArrayList<>();
		invoiceItems.addAll(request.getInvoiceItems());
		request.setInvoiceItems(null);
		
		request.setBillingDateDate(request.getBillingDate().toGregorianCalendar().getTime());
		request.setCurrencyDateDate(request.getCurrencyDate().toGregorianCalendar().getTime());
		
		InvoiceRequest invoiceRet = invoiceServiceImpl.save(request);
		
		for(int i = 0; i < invoiceItems.size(); i++){
			invoiceItems.get(i).setInvoice(invoiceRet);
			invoiceItemServiceImpl.save(invoiceItems.get(i));
		}
		
		System.out.println("Faktura uspesno primljena");
		return request;
	}
	
}
