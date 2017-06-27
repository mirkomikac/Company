insert into bank(id, account_statement_request_service, address, email, fax, name, statement_service, telephone, web, bank_code) 
values (1, 'https://localhost:8080/ws/accountStatementRequestService', 'Bulevear fronta 20', 'vojvodjanska@gmail.com', '232-444', 'Vojvodjanska banka', 'https://localhost:8080/ws/statementService', '021/555-333', 'www.vobanka.com', '333');

insert into bank(id, account_statement_request_service, address, email, fax, name, statement_service, telephone, web, bank_code) 
values (2, 'https://localhost:8080/ws/accountStatementRequestService', 'Bulevear narodnog fronta 20', 'komerciajalna@mail.com', '232-444', 'Komercijalna banka', 'https://localhost:8080/ws/statementService', '021/555-131', 'www.komercijalna.com', '666');

insert into company(id, address, name, pib, url_invoice_service) values (1, 'blabla 100', 'pera', '12345678910', 'https://localhost:9090/InvoiceRestService/getInvoice');
insert into company(id, address, name, pib, url_invoice_service) values (2, 'lala 39', 'sima', '98745678910', 'https://localhost:9090/InvoiceRestService/getInvoice');

insert into account(id, account_number, active, bank_id, currency) values (1, '333-111-333', true, 1,'DIN');
insert into account(id, account_number, active, bank_id, currency) values (2, '333-333-333', true, 1, 'DIN');
insert into account(id, account_number, active, bank_id, currency) value (3, '666-111-333', true, 2, 'LIR');

insert into account_statement_request(id, account_number, date_date, section_ordinate) values (1, '333-111-333', '2017-4-5', 3);
insert into account_statement_request(id, account_number, date_date, section_ordinate) values (2, '333-111-333', '2017-4-6', 2);
insert into account_statement_request(id, account_number, date_date, section_ordinate) values (3, '333-111-333', '2017-2-1', 1);
insert into account_statement_request(id, account_number, date_date, section_ordinate) values (4, '333-333-333', '2017-2-1', 3);
insert into account_statement_request(id, account_number, date_date, section_ordinate) values (5, '333-333-333', '2017-1-1', 1);
insert into account_statement_request(id,  account_number, date_date, section_ordinate) values (6, '666-111-333', '2017-4-2', 1);

insert into account_statement_section_response(id, current_balance, number_of_changes_due, number_of_changes_profit, previous_balance, request_date_date, section_ordinate, total_due, total_profit, account_number) 
values (1, 5000, 3, 2, 3000, '2017-4-5', 3, 1000, 3000, '333-111-333');

insert into account_statement_section_response(id, current_balance, number_of_changes_due, number_of_changes_profit, previous_balance, request_date_date, section_ordinate, total_due, total_profit, account_number) 
values (2, 7000, 1, 1, 4000, '2017-4-6', 2, 2000, 5000, '333-111-333');

insert into account_statement_section_response(id, current_balance, number_of_changes_due, number_of_changes_profit, previous_balance, request_date_date, section_ordinate, total_due, total_profit, account_number) 
values (3, 5000, 3, 2, 3000, '2017-2-1', 1, 1000, 3000, '333-111-333');

insert into account_statement_section_response(id, current_balance, number_of_changes_due, number_of_changes_profit, previous_balance, request_date_date, section_ordinate, total_due, total_profit, account_number) 
values (4, 10000, 5, 2, 3000, '2017-2-1', 3, 1000, 8000, '333-333-333');

insert into account_statement_section_response(id, current_balance, number_of_changes_due, number_of_changes_profit, previous_balance, request_date_date, section_ordinate, total_due, total_profit, account_number) 
values (5, 15000, 3, 2, 8000, '2017-1-1', 1, 5000, 12000, '333-333-333');

insert into account_statement_section_response(id, current_balance, number_of_changes_due, number_of_changes_profit, previous_balance, request_date_date, section_ordinate, total_due, total_profit, account_number) 
values (6, 5000, 3, 2, 3000, '2017-4-2', 1, 1000, 3000, '666-111-333');


insert into account_statement_section_item(id, account_statement_section_response_id, amount, charge_dial_number, charge_model, clearance_dial_number, clearance_model, 
currency, currency_date_date, direction, originator, originator_account_number, payment_purpose, reciever, reciever_account_number, statement_date_date) 
values (1, 1, 1000, '1111111', '97', '111111', '97', 'DIN', '2017-5-5', 'UPLATA', 'Mirko Mikac', '555-111-555', 'Kupovina namestaja', 'Jovan Jovic', '333-111-333', '2017-5-2');

insert into statement_request
(id, amount, charge_dial_number, charge_model, clearance_dial_number, clearance_model, currency, currency_date_date, emergency, message_id, originator, originator_account_number, payment_purpose, place_of_acceptance, reciever, reciever_account_number, statement_date_date) values 
(1, 4000, 31231123131, 97, 133123123, 97, 'DIN', '2017-6-19', true, 'messageId', 'Mirko Mikac', '333-111-333', 'PARE', 'Novi Sad', 'Jovan Jovic', '333-333-333', '2017-6-19');

insert into statement_request
(id, amount, charge_dial_number, charge_model, clearance_dial_number, clearance_model, currency, currency_date_date, emergency, message_id, originator, originator_account_number, payment_purpose, place_of_acceptance, reciever, reciever_account_number, statement_date_date) values 
(2, 12220, 31231123131, 97, 133123123, 97, 'DIN', '2017-6-15', true, 'messageId', 'Mirko Mikac', '333-111-333', 'PARE', 'Novi Sad', 'Stevan Stevic', '333-111-222', '2017-6-15');

insert into invoice_request(id, account_number, amount_for_payment, billing_date_date, billing_number, currency, currency_date_date,
merchandise_value, message_id, purchaser_adress, purchaser_pib, purchaser_name, supplier_address, supplier_name, supplier_pib, total_discount, total_taxes, total_service_and_merchandise_value, services_value) values
(1, '333-111-333', 1000, '2017-6-6', 100, 'DIN', '2017-7-7', 1000, 'messageId', 'Stanka Vranesa 3', '8132131', 'Jovan', 'Branka Kostica', 'Kosta', '132311', 20, 20, 200000, 12111);

insert into invoice_request(id, account_number, amount_for_payment, billing_date_date, billing_number, currency, currency_date_date,
merchandise_value, message_id, purchaser_adress, purchaser_pib, purchaser_name, supplier_address, supplier_name, supplier_pib, total_discount, total_taxes, total_service_and_merchandise_value, services_value) values
(2, '333-222-333', 111312, '2017-6-6', 100, 'DIN', '2017-7-7', 1000, 'messageId', 'Ranka Jovica 10', '8132131', 'Ivan', 'Stola Kostica', 'Kosta', '132311', 20, 20, 12222, 312312);

insert into invoice_request(id, account_number, amount_for_payment, billing_date_date, billing_number, currency, currency_date_date,
merchandise_value, message_id, purchaser_adress, purchaser_pib, purchaser_name, supplier_address, supplier_name, supplier_pib, total_discount, total_taxes, total_service_and_merchandise_value, services_value) values
(3, '333-111-333', 1000, '2017-6-6', 100, 'DIN', '2017-7-7', 1000, 'messageId', 'Tosa Bunar 3', '8132131', 'Bojan', 'Krane Zupic', 'Kosta', '132311', 20, 20, 12312, 301100);

insert into invoice_item(id, amount, discount_percentage, discount_taken, disounct_amount, invoice_id, merchandise_or_service_name, ordinate, total_taxes, unit, unit_price, value) values 
(1, 1000, 10, 10, 100, 1, 'Torba', 1, 20, 'KG', 50, 500);
insert into invoice_item(id, amount, discount_percentage, discount_taken, disounct_amount, invoice_id, merchandise_or_service_name, ordinate, total_taxes, unit, unit_price, value) values 
(2, 1000, 10, 10, 100, 1, 'Sto', 1, 20, 'KG', 50, 500);


