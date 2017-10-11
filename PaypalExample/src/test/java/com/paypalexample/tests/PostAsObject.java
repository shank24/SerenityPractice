package com.paypalexample.tests;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.spi.TransactionalWriter;

import org.junit.Test;

import com.jayway.restassured.http.ContentType;
import com.paypalexamples.base.BaseClass;
import com.paypalexamples.payment.pojo.Amount;
import com.paypalexamples.payment.pojo.Details;
import com.paypalexamples.payment.pojo.Item_List;
import com.paypalexamples.payment.pojo.Items;
import com.paypalexamples.payment.pojo.Payer;
import com.paypalexamples.payment.pojo.Payment_Options;
import com.paypalexamples.payment.pojo.PostObject;
import com.paypalexamples.payment.pojo.Redirect_urls;
import com.paypalexamples.payment.pojo.Shipping_Address;
import com.paypalexamples.payment.pojo.Transactions;

public class PostAsObject extends BaseClass {

	static String payment_id;

	@Test
	public void createPayment() {

		// Create Redirect_URLs
		Redirect_urls red = new Redirect_urls();
		red.setCancel_url("https://www.paypal.com/cancel");
		red.setReturn_url("https://www.paypal.com/return");

		// Create Details
		Details details = new Details();
		details.setSubtotal("30.00");
		details.setTax("0.07");
		details.setShipping("0.03");
		details.setHandling_fee("1.00");
		details.setShipping_discount("-1.00");
		details.setInsurance("0.01");

		// Create Amount
		Amount amount = new Amount();

		amount.setCurrency("USD");
		amount.setDetails(details);
		amount.setTotal("30.11");

		// Create Shipping Address
		Shipping_Address ship = new Shipping_Address();

		ship.setRecipient_name("Brian Robinson");
		ship.setLine1("4th Floor");
		ship.setLine2("Unit #34");
		ship.setCity("San Jose");
		ship.setCountry_code("US");
		ship.setPostal_code("95131");
		ship.setPhone("011862212345678");
		ship.setState("CA");

		// Create Items
		Items item1 = new Items();

		item1.setName("hat");
		item1.setDescription("Brown Hat.");
		item1.setQuantity("5");
		item1.setPrice("3");
		item1.setTax("0.01");
		item1.setSku("1");
		item1.setCurrency("USD");

		Items item2 = new Items();

		item2.setName("handbag");
		item2.setDescription("Black handbag");
		item2.setQuantity("1");
		item2.setPrice("15");
		item2.setTax("0.02");
		item2.setSku("product34");
		item2.setCurrency("USD");

		List<Items> items = new ArrayList<Items>();

		items.add(item1);
		items.add(item2);

		Item_List item_list = new Item_List();
		item_list.setShipping_address(ship);
		item_list.setItems(items);

		// Set Payment Options
		Payment_Options pay = new Payment_Options();

		pay.setAllowed_payment_method("INSTANT_FUNDING_SOURCE");

		// Set Transactions

		Transactions trans = new Transactions();
		trans.setAmount(amount);
		trans.setItem_list(item_list);
		trans.setPayment_options(pay);
		trans.setCustom("EBAY_EMS_90048630024435");
		trans.setDescription("The payment transaction description.");
		trans.setInvoice_number("48787589673");
		trans.setSoft_descriptor("ECHI5786786");

		List<Transactions> transactionsObj = new ArrayList<Transactions>();
		transactionsObj.add(trans);

		// Set Payer

		Payer payer = new Payer();
		payer.setPayment_Method("paypal");

		PostObject pobj = new PostObject();
		pobj.setIntent("sale");
		pobj.setPayer(payer);
		pobj.setTransactions(transactionsObj);
		pobj.setNote_to_payer("Contact us for any questions on your order.");
		pobj.setRedirect_urls(red);

		//payment_id =
				
				given().contentType(ContentType.JSON).auth().oauth2(accessToken).when().body(pobj).post("/payments/payment")
				.then().extract().path("id");
		
		//System.out.println("Payment Id : " + payment_id);
				
				
				given().contentType(ContentType.JSON).auth().oauth2(accessToken).when().body(pobj).post("/payments/payment")
				.then().log().all();
		
	}
	

}
