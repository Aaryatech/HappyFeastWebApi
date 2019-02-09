package com.ats.feastwebapi.controller;
 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.feastwebapi.model.Admin;
import com.ats.feastwebapi.model.Bill;
import com.ats.feastwebapi.model.BillDetails;
import com.ats.feastwebapi.model.ErrorMessage;
import com.ats.feastwebapi.model.GetBill;
import com.ats.feastwebapi.model.Item;
import com.ats.feastwebapi.model.ItemWithOffer;
import com.ats.feastwebapi.model.ItemWithOfferDaywise;
import com.ats.feastwebapi.model.LoginProcess; 
import com.ats.feastwebapi.model.OrderDetailsList;
import com.ats.feastwebapi.model.OrderHeaderList;
import com.ats.feastwebapi.model.ParcelOrder;
import com.ats.feastwebapi.model.ParcelOrderDetails;
import com.ats.feastwebapi.model.TableList;
import com.ats.feastwebapi.model.TableSetting;
import com.ats.feastwebapi.repository.AdminRepository;
import com.ats.feastwebapi.repository.BillDetailsRepository;
import com.ats.feastwebapi.repository.BillRepository;
import com.ats.feastwebapi.repository.GetBillRepository;
import com.ats.feastwebapi.repository.ItemRepository;
import com.ats.feastwebapi.repository.ItemWithOfferDaywiseRepository;
import com.ats.feastwebapi.repository.ItemWithOfferRepository;
import com.ats.feastwebapi.repository.OrderDetailRepository;
import com.ats.feastwebapi.repository.OrderDetailsListRepository;
import com.ats.feastwebapi.repository.OrderHeaderListRepository;
import com.ats.feastwebapi.repository.OrderRepository;
import com.ats.feastwebapi.repository.ParcelOrderDetailsRepository;
import com.ats.feastwebapi.repository.ParcelOrderRepository;
import com.ats.feastwebapi.repository.TableListRepository;
import com.ats.feastwebapi.repository.TableSettingRepository;

@RestController
public class TransactionRestController {
	
	@Autowired
	TableListRepository tableListRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	OrderHeaderListRepository orderHeaderListRepository;
	
	@Autowired
	OrderDetailsListRepository orderDetailsListRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	BillDetailsRepository billDetailsRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	TableSettingRepository tableSettingRepository;
	
	@Autowired
	ParcelOrderRepository parcelOrderRepository;
	
	@Autowired
	ParcelOrderDetailsRepository parcelOrderDetailsRepository;
	
	@Autowired
	ItemWithOfferRepository itemWithOfferRepository;
	
	@Autowired
	ItemWithOfferDaywiseRepository itemWithOfferDaywiseRepository;
	
	@Autowired
	GetBillRepository getBillRepository;
	
	
	@RequestMapping(value = { "/getFreeTableList" }, method = RequestMethod.GET)
	public @ResponseBody List<TableList> getFreeTableList() {

		List<TableList> tableLists = new ArrayList<TableList>();
		try {

			tableLists = tableListRepository.getFreeTableList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return tableLists;

	}
	
	@RequestMapping(value = { "/getFreeTableListByCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<TableList> getFreeTableListByVenueId(@RequestParam("catId") int catId) {

		List<TableList> tableLists = new ArrayList<TableList>();
		try {

			tableLists = tableListRepository.getFreeTableListByVenueId(catId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return tableLists;

	}
	
	@RequestMapping(value = { "/getBsyTableList" }, method = RequestMethod.GET)
	public @ResponseBody List<TableList> getBsyTableList() {

		List<TableList> tableLists = new ArrayList<TableList>();
		try {

			tableLists = tableListRepository.getBsyTableList();
			
			for(int i=0; i<tableLists.size();i++)
			{
				float totalAmt = tableListRepository.getTotalAmtOfTable(tableLists.get(i).getTableNo());
				int LastKOT = tableListRepository.getLastOrder(tableLists.get(i).getTableNo());
				tableLists.get(i).setTotalAmt(totalAmt);
				tableLists.get(i).setOrderId(LastKOT);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return tableLists;

	}
	
	@RequestMapping(value = { "/getBsyTableListByCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<TableList> getBsyTableListByVenueId(@RequestParam("catId") int catId) {

		List<TableList> tableLists = new ArrayList<TableList>();
		try {

			tableLists = tableListRepository.getBsyTableListByVenueId(catId);
			
			for(int i=0; i<tableLists.size();i++)
			{
				float totalAmt = tableListRepository.getTotalAmtOfTable(tableLists.get(i).getTableNo());
				int LastKOT = tableListRepository.getLastOrder(tableLists.get(i).getTableNo());
				tableLists.get(i).setTotalAmt(totalAmt);
				tableLists.get(i).setOrderId(LastKOT);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return tableLists;

	}
	
	@RequestMapping(value = { "/adminLogin" }, method = RequestMethod.POST)
	public @ResponseBody LoginProcess adminLogin(@RequestParam("userName") String userName, @RequestParam("pass") String pass) {

		LoginProcess loginProcess = new LoginProcess();
		try {

			Admin admin = adminRepository.findByUsernameAndPasswordAndDelStatus(userName,pass,1);
			
			if(admin==null)
			{
				loginProcess.setError(true);
				loginProcess.setMessage("failed To login ");
			}
			else
			{
				loginProcess.setError(false);
				loginProcess.setMessage("login Successfully ");
				loginProcess.setAdmin(admin);
			}
			
			 
		} catch (Exception e) {

			e.printStackTrace();
			loginProcess.setError(true);
			loginProcess.setMessage("failed To login ");

		}
		return loginProcess;

	}
	
	@RequestMapping(value = { "/orderListByTableNo" }, method = RequestMethod.POST)
	public @ResponseBody List<OrderHeaderList> orderListByTableNo(@RequestParam("tableNo") int tableNo) {

		List<OrderHeaderList> orders = new ArrayList<OrderHeaderList>();
		try {

			orders = orderHeaderListRepository.orderListByTableNo(tableNo);
			
			for(int i=0; i<orders.size();i++)
			{
				 List<OrderDetailsList> orderDetails = orderDetailsListRepository.findByOrderId(orders.get(i).getOrderId());
				 orders.get(i).setOrderDetailsList(orderDetails);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orders; 
	}
	
	@RequestMapping(value = { "/canceOrderItem" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage canceOrderItem(@RequestParam("orderDetailId") List<Integer> orderDetailId, 
			@RequestParam("status") int status,@RequestParam("remark") String remark) {

		ErrorMessage errorMessage = new ErrorMessage();
		try {

			int update = orderDetailRepository.canceOrderItem(orderDetailId,status,remark);
			
			if(update>0)
			{
				errorMessage.setError(false);
				errorMessage.setMessage(" Successfully Updated"); 
			}
			else
			{
				errorMessage.setError(true);
				errorMessage.setMessage(" UnSuccessfully Updated"); 
			}
			
			 
		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" UnSuccessfully Updated"); 

		}
		return errorMessage;

	}
	
	
	@RequestMapping(value = { "/generateBill" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage generateBill(@RequestParam("userId") int userId,@RequestParam("discount") float discount,
			@RequestParam("tableNo") int tableNo, @RequestParam("venueId") int venueId) {

		ErrorMessage errorMessage = new ErrorMessage();
		try {
			
			 
			
			List<OrderDetailsList> orderDetails = orderDetailsListRepository.getOrderList(tableNo);
			
			if(orderDetails.size()>0)
			{
				TableSetting tableSetting = tableSettingRepository.findByVenueId(venueId);
				
				if(tableSetting==null)
				{
					tableSetting = new TableSetting();
					if(String.valueOf(venueId).length()==1)
						tableSetting.setBillNo("0"+venueId+"-00001");
					else
						tableSetting.setBillNo(venueId+"-00001");
					tableSetting.setVenueId(venueId);
					tableSetting = tableSettingRepository.save(tableSetting);
				}
				 
				List<Item> itemList = itemRepository.findAllByDelStatus(1); 
				Bill bill = new Bill(); 
				List<BillDetails> billDetailsList = new ArrayList<BillDetails>();
				
				Bill save = billRepository.save(bill);
				
				Date date = new Date();
				//SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				
				 System.out.println("itemList " +itemList);
				 System.out.println("orderDetails " +orderDetails);
				 
				 float grandTotal=0;
				 float cgst=0;
				 float sgst=0;
				 float taxableAmt=0;
				 float finalTaxAmt=0;
				 
				 /*for(int i = 0; i<orderDetails.size(); i++)
				 {
					 for(int j = 0; j<itemList.size() ; j++)
					 {
						 if(orderDetails.get(i).getItemId() == itemList.get(j).getItemId())
						 {
							 BillDetails billDetails = new BillDetails();
							 billDetails.setBillId(save.getBillId());
							 billDetails.setOrderId(orderDetails.get(i).getOrderId());
							 billDetails.setItemId(orderDetails.get(i).getItemId());
							 billDetails.setItemName(itemList.get(j).getItemName());
							 billDetails.setQuantity(orderDetails.get(i).getQuantity());
							 billDetails.setRate(orderDetails.get(i).getRate());
							 billDetails.setTotal(orderDetails.get(i).getTotal());  
							 //float tax = itemList.get(j).getCgst() + itemList.get(j).getSgst();
							 billDetails.setTaxableAmt(billDetails.getTotal()-((discount/100)*billDetails.getTotal()));  
							 float cgstAmt = (itemList.get(j).getCgst()/100)*billDetails.getTaxableAmt();
							 float sgstAmt = (itemList.get(j).getSgst()/100)*billDetails.getTaxableAmt();
							 
							 billDetails.setTotalTax(cgstAmt+sgstAmt);
							 billDetails.setSgst(cgstAmt);
							 billDetails.setCgst(sgstAmt); 
							 billDetails.setDelStatus(1);
							 
							 grandTotal = grandTotal+billDetails.getTotal();
							 cgst = cgst+billDetails.getCgst();
							 sgst = sgst+billDetails.getSgst();
							 taxableAmt = taxableAmt+billDetails.getTaxableAmt();
							 finalTaxAmt = finalTaxAmt + billDetails.getTotalTax();
							 
							 billDetailsList.add(billDetails);
							 break;
						 }
					 }
				 }*/
				 
				 
				 for(int i = 0; i<orderDetails.size(); i++)
				 {
					 for(int j = 0; j<itemList.size() ; j++)
					 {
						 if(orderDetails.get(i).getItemId() == itemList.get(j).getItemId())
						 {
							 BillDetails billDetails = new BillDetails();
							 billDetails.setBillId(save.getBillId());
							 billDetails.setOrderId(orderDetails.get(i).getOrderId());
							 billDetails.setItemId(orderDetails.get(i).getItemId());
							 billDetails.setItemName(itemList.get(j).getItemName());
							 billDetails.setQuantity(orderDetails.get(i).getQuantity());
							 billDetails.setRate(orderDetails.get(i).getRate());
							 
							 
							 float baseRate = ((billDetails.getRate()*100)/((itemList.get(j).getCgst()+itemList.get(j).getSgst())+100));
							 float value = baseRate*billDetails.getQuantity();
							 billDetails.setTaxableAmt(value-((discount/100)*value));
							 float cgstAmt = (itemList.get(j).getCgst()/100)*billDetails.getTaxableAmt();
							 float sgstAmt = (itemList.get(j).getSgst()/100)*billDetails.getTaxableAmt();
							 
							 billDetails.setTotalTax(cgstAmt+sgstAmt);
							 billDetails.setSgst(cgstAmt);
							 billDetails.setCgst(sgstAmt);
							 billDetails.setTotal(billDetails.getTaxableAmt()+cgstAmt+sgstAmt);  
							 //float tax = itemList.get(j).getCgst() + itemList.get(j).getSgst();
							    
							 billDetails.setDelStatus(1);
							 
							 grandTotal = grandTotal+orderDetails.get(i).getTotal();
							 cgst = cgst+billDetails.getCgst();
							 sgst = sgst+billDetails.getSgst();
							 taxableAmt = taxableAmt+billDetails.getTaxableAmt();
							 finalTaxAmt = finalTaxAmt + billDetails.getTotalTax();
							 
							 billDetailsList.add(billDetails);
							 break;
						 }
					 }
				 }
				 
				 save.setBillDate(date);
				 save.setDelStatus(1);
				 save.setUserId(userId);
				 save.setEnterBy(1);
				 save.setDiscount(discount);
				 save.setGrandTotal(grandTotal);
				 save.setPayableAmt(taxableAmt+finalTaxAmt);
				 save.setCgst(cgst);
				 save.setSgst(sgst);
				 save.setTaxableAmount(taxableAmt);
				 save.setTableNo(tableNo);
				 save.setBillDetails(billDetailsList);
				 save.setBillNo(tableSetting.getBillNo());
				 save.setVenueId(venueId);
				 
				 System.out.println(save);
				 
				 Bill finalsave = billRepository.save(save); 
				 List<BillDetails> saveDetail = billDetailsRepository.saveAll(billDetailsList);
				 
				 if(finalsave!=null && saveDetail!=null)
				 {
					errorMessage.setError(false);
					errorMessage.setMessage(save.getBillNo());  
					  
					String[] splt = tableSetting.getBillNo().split("-");
					System.out.println(splt);
					int billNo=Integer.parseInt(splt[1])+1;
				    String finalBillNo = new String();
				    
				    for(int i=0;i<5-String.valueOf(billNo).length();i++)
				    	finalBillNo=finalBillNo+"0";
				    
				    finalBillNo=finalBillNo+billNo;
					
					tableSetting.setBillNo(splt[0]+"-"+finalBillNo);
					tableSetting = tableSettingRepository.save(tableSetting);
					 
					int update = orderRepository.updateOrderStatus(tableNo);
					System.out.println(update);
				 }
			}
			else
			{
				int update = orderRepository.updateOrderStatus(tableNo);
				System.out.println(update);
				errorMessage.setError(false);
				errorMessage.setMessage("No Item To generate Bill"); 
			}
			 
		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("faid to insert"); 

		}
		return errorMessage;

	}
	
	
	@RequestMapping(value = { "/generateBillForParcelOrder" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage generateBillForParcelOrder(@RequestParam("userId") int userId,@RequestParam("discount") float discount,
			@RequestParam("parcelOrderId") int parcelOrderId, @RequestParam("venueId") int venueId) {

		ErrorMessage errorMessage = new ErrorMessage();
		try {
			
			 
		 
			List<ParcelOrderDetails> parcelOrderDetails = parcelOrderDetailsRepository.findByParcelOrderId(parcelOrderId);
			  
			if(parcelOrderDetails.size()>0)
			{
				TableSetting tableSetting = tableSettingRepository.findByVenueId(venueId);
				
				if(tableSetting==null)
				{
					tableSetting = new TableSetting();
					if(String.valueOf(venueId).length()==1)
						tableSetting.setBillNo("0"+venueId+"-00001");
					else
						tableSetting.setBillNo(venueId+"-00001");
					tableSetting.setVenueId(venueId);
					tableSetting = tableSettingRepository.save(tableSetting);
				}
				 
				List<Item> itemList = itemRepository.findAllByDelStatus(1); 
				Bill bill = new Bill(); 
				List<BillDetails> billDetailsList = new ArrayList<BillDetails>();
				
				Bill save = billRepository.save(bill);
				
				Date date = new Date();
				 
				 
				 float grandTotal=0;
				 float cgst=0;
				 float sgst=0;
				 float taxableAmt=0;
				 float finalTaxAmt=0;
				 
				 /*for(int i = 0; i<parcelOrderDetails.size(); i++)
				 {
					 for(int j = 0; j<itemList.size() ; j++)
					 {
						 if(parcelOrderDetails.get(i).getItemId() == itemList.get(j).getItemId())
						 {
							 BillDetails billDetails = new BillDetails();
							 billDetails.setBillId(save.getBillId());
							 billDetails.setOrderId(parcelOrderDetails.get(i).getParcelOrderId());
							 billDetails.setItemId(parcelOrderDetails.get(i).getItemId());
							 billDetails.setItemName(itemList.get(j).getItemName());
							 billDetails.setQuantity(parcelOrderDetails.get(i).getQuantity());
							 billDetails.setRate(parcelOrderDetails.get(i).getRate());
							 billDetails.setTotal(billDetails.getQuantity()*billDetails.getRate());  
							 //float tax = itemList.get(j).getCgst() + itemList.get(j).getSgst();
							 billDetails.setTaxableAmt(billDetails.getTotal()-((discount/100)*billDetails.getTotal()));  
							 float cgstAmt = (itemList.get(j).getCgst()/100)*billDetails.getTaxableAmt();
							 float sgstAmt = (itemList.get(j).getSgst()/100)*billDetails.getTaxableAmt();
							 
							 billDetails.setTotalTax(cgstAmt+sgstAmt);
							 billDetails.setSgst(cgstAmt);
							 billDetails.setCgst(sgstAmt); 
							 billDetails.setDelStatus(1);
							 
							 grandTotal = grandTotal+billDetails.getTotal();
							 cgst = cgst+billDetails.getCgst();
							 sgst = sgst+billDetails.getSgst();
							 taxableAmt = taxableAmt+billDetails.getTaxableAmt();
							 finalTaxAmt = finalTaxAmt + billDetails.getTotalTax();
							 
							 billDetailsList.add(billDetails);
							 break;
						 }
					 }
				 }*/
				 
				 for(int i = 0; i<parcelOrderDetails.size(); i++)
				 {
					 for(int j = 0; j<itemList.size() ; j++)
					 {
						 if(parcelOrderDetails.get(i).getItemId() == itemList.get(j).getItemId())
						 {
							 BillDetails billDetails = new BillDetails();
							 billDetails.setBillId(save.getBillId());
							 billDetails.setOrderId(parcelOrderDetails.get(i).getParcelOrderId());
							 billDetails.setItemId(parcelOrderDetails.get(i).getItemId());
							 billDetails.setItemName(itemList.get(j).getItemName());
							 billDetails.setQuantity(parcelOrderDetails.get(i).getQuantity());
							 billDetails.setRate(parcelOrderDetails.get(i).getRate());
							 
							 float baseRate = ((billDetails.getRate()*100)/((itemList.get(j).getCgst()+itemList.get(j).getSgst())+100));
							 float value = baseRate*billDetails.getQuantity();
							 billDetails.setTaxableAmt(value-((discount/100)*value));
							 float cgstAmt = (itemList.get(j).getCgst()/100)*billDetails.getTaxableAmt();
							 float sgstAmt = (itemList.get(j).getSgst()/100)*billDetails.getTaxableAmt();
							 
							 billDetails.setTotalTax(cgstAmt+sgstAmt);
							 billDetails.setSgst(cgstAmt);
							 billDetails.setCgst(sgstAmt);
							 billDetails.setTotal(billDetails.getTaxableAmt()+cgstAmt+sgstAmt);  
							 //float tax = itemList.get(j).getCgst() + itemList.get(j).getSgst(); 
							 
							 billDetails.setDelStatus(1);
							 
							 grandTotal = grandTotal+(parcelOrderDetails.get(i).getRate()*parcelOrderDetails.get(i).getQuantity());
							 cgst = cgst+billDetails.getCgst();
							 sgst = sgst+billDetails.getSgst();
							 taxableAmt = taxableAmt+billDetails.getTaxableAmt();
							 finalTaxAmt = finalTaxAmt + billDetails.getTotalTax();
							 
							 billDetailsList.add(billDetails);
							 break;
						 }
					 }
				 }
				 
				 save.setBillDate(date);
				 save.setDelStatus(1);
				 save.setUserId(userId);
				 save.setEnterBy(2);
				 save.setDiscount(discount);
				 save.setGrandTotal(grandTotal);
				 save.setPayableAmt(taxableAmt+finalTaxAmt);
				 save.setCgst(cgst);
				 save.setSgst(sgst);
				 save.setTaxableAmount(taxableAmt);
				 save.setTableNo(0);
				 save.setBillDetails(billDetailsList);
				 save.setBillNo(tableSetting.getBillNo());
				 save.setVenueId(venueId);
				 
				 System.out.println(save);
				 
				 Bill finalsave = billRepository.save(save); 
				 List<BillDetails> saveDetail = billDetailsRepository.saveAll(billDetailsList);
				 
				 if(finalsave!=null && saveDetail!=null)
				 {
					errorMessage.setError(false);
					errorMessage.setMessage(save.getBillNo());   
					String[] splt = tableSetting.getBillNo().split("-");
					System.out.println(splt);
					int billNo=Integer.parseInt(splt[1])+1;
				    String finalBillNo = new String();
				    
				    for(int i=0;i<5-String.valueOf(billNo).length();i++)
				    	finalBillNo=finalBillNo+"0";
				    
				    finalBillNo=finalBillNo+billNo;
					
					tableSetting.setBillNo(splt[0]+"-"+finalBillNo);
					tableSetting = tableSettingRepository.save(tableSetting);
					 
					int update = parcelOrderRepository.updateOrderStatus(parcelOrderId);
					System.out.println(update);
				 }
			}
			else
			{
				int update = parcelOrderRepository.updateOrderStatus(parcelOrderId);
				System.out.println(update);
				errorMessage.setError(false);
				errorMessage.setMessage("No Item To generate Bill");  
			}
			 
		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("faid to insert"); 

		}
		return errorMessage;

	}
	
	@RequestMapping(value = { "/getItemListWithOfferScheme" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemWithOffer> getItemListWithOfferScheme(@RequestParam("status") String status) {

		List<ItemWithOfferDaywise> dayWiseList = new ArrayList<>();
		List<ItemWithOffer> dateWiseList = new ArrayList<>();
		//List<ItemWithOffer> finalList = new ArrayList<>();
		
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
       /* SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
        System.out.println(simpleDateformat.format(now));
 
        simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
        System.out.println(simpleDateformat.format(now));*/
 
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now); 
        int day=calendar.get(Calendar.DAY_OF_WEEK);
        String date = sf.format(now);
        
        System.out.println(day);
        System.out.println(date);
        
		try {

			int id = itemWithOfferRepository.getRegularId();
			System.out.println(id);
			
			 if(id==1)
			 {
				 dayWiseList=itemWithOfferDaywiseRepository.getDataWithRegularRateDayWise(status,day);
				 dateWiseList=itemWithOfferRepository.getDataWithRegularRateDateWise(status,date);
			 }
			 else if(id==2)
			 {
				 dayWiseList=itemWithOfferDaywiseRepository.getDataWithSpecialRateDayWise(status,day);
				 dateWiseList=itemWithOfferRepository.getDataWithSpecialRateDateWise(status,date);
			 }
			 else if(id==3)
			 {
				 dayWiseList=itemWithOfferDaywiseRepository.getDataWithGameRateDayWise(status,day);
				 dateWiseList=itemWithOfferRepository.getDataWithGameRateDateWise(status,date);
			 }
			 
			 System.out.println("dayWiseList" + dayWiseList);
			 System.out.println("dateWiseList" + dateWiseList);
			 
			 /*for(int i = 0 ; i<dateWiseList.size();i++)
			 {
				 for(int j = 0 ; j<dayWiseList.size();j++)
				 {
					 if(dateWiseList.get(i).getItemId()==dayWiseList.get(j).getItemId() && dayWiseList.get(j).getOfferId()!=0 
							 && dayWiseList.get(j).getOfferId()>dateWiseList.get(i).getOfferId())
					 {
						 dateWiseList.get(i).setOfferId(dayWiseList.get(j).getOfferId());
						 dateWiseList.get(i).setOfferName(dayWiseList.get(j).getOfferName());
						 dateWiseList.get(i).setOfferDesc(dayWiseList.get(j).getOfferDesc());
						 dateWiseList.get(i).setOfferType(dayWiseList.get(j).getOfferType());
						 dateWiseList.get(i).setOfferBuyQty(dayWiseList.get(j).getOfferBuyQty());
						 dateWiseList.get(i).setOfferFreeQty(dayWiseList.get(j).getOfferFreeQty());
						 dateWiseList.get(i).setOfferPer(dayWiseList.get(j).getOfferPer());
						 dateWiseList.get(i).setOfferDatewiseDaywise(dayWiseList.get(j).getOfferDatewiseDaywise()); 
						 break;
					 }
				 }
			 }*/
			 
			 for(int i = 0 ; i<dateWiseList.size();i++)
			 {
				 for(int j = 0 ; j<dayWiseList.size();j++)
				 {
					 if(dateWiseList.get(i).getItemId()==dayWiseList.get(j).getItemId() && dateWiseList.get(i).getOfferId()==0 
							 && dayWiseList.get(j).getOfferId()>dateWiseList.get(i).getOfferId())
					 {
						 dateWiseList.get(i).setOfferId(dayWiseList.get(j).getOfferId());
						 dateWiseList.get(i).setOfferName(dayWiseList.get(j).getOfferName());
						 dateWiseList.get(i).setOfferDesc(dayWiseList.get(j).getOfferDesc());
						 dateWiseList.get(i).setOfferType(dayWiseList.get(j).getOfferType());
						 dateWiseList.get(i).setOfferBuyQty(dayWiseList.get(j).getOfferBuyQty());
						 dateWiseList.get(i).setOfferFreeQty(dayWiseList.get(j).getOfferFreeQty());
						 dateWiseList.get(i).setOfferPer(dayWiseList.get(j).getOfferPer());
						 dateWiseList.get(i).setOfferDatewiseDaywise(dayWiseList.get(j).getOfferDatewiseDaywise()); 
						 break;
					 }
				 }
			 }
			 
		} catch (Exception e) {

			e.printStackTrace();
			 

		}
		return dateWiseList;

	}
	
	@RequestMapping(value = { "/editBill" }, method = RequestMethod.POST)
	public @ResponseBody Bill editBill(@RequestBody Bill bill) {

		 Bill finalsave = new Bill();
		 System.out.println("BILL : "+bill);
		try {
			List<Item> itemList = itemRepository.findAllByDelStatus(1); 
			
			 float grandTotal=0;
			 float cgst=0;
			 float sgst=0;
			 float taxableAmt=0;
			 float finalTaxAmt=0;
			 
			 for(int i = 0; i<bill.getBillDetails().size(); i++)
			 {
				 for(int j = 0; j<itemList.size() ; j++)
				 {
					 if(bill.getBillDetails().get(i).getItemId() == itemList.get(j).getItemId() && bill.getBillDetails().get(i).getDelStatus()==1)
					 {
						   
						  
						 float baseRate = ((bill.getBillDetails().get(i).getRate()*100)/((itemList.get(j).getCgst()+itemList.get(j).getSgst())+100));
						 float value = baseRate*bill.getBillDetails().get(i).getQuantity();
						 bill.getBillDetails().get(i).setTaxableAmt(value-((bill.getDiscount()/100)*value));
						 float cgstAmt = (itemList.get(j).getCgst()/100)*bill.getBillDetails().get(i).getTaxableAmt();
						 float sgstAmt = (itemList.get(j).getSgst()/100)*bill.getBillDetails().get(i).getTaxableAmt();
						 
						 bill.getBillDetails().get(i).setTotalTax(cgstAmt+sgstAmt);
						 bill.getBillDetails().get(i).setSgst(cgstAmt);
						 bill.getBillDetails().get(i).setCgst(sgstAmt);
						 bill.getBillDetails().get(i).setTotal(bill.getBillDetails().get(i).getTaxableAmt()+cgstAmt+sgstAmt);  
						   
						 grandTotal = grandTotal+(bill.getBillDetails().get(i).getRate()*bill.getBillDetails().get(i).getQuantity());
						 cgst = cgst+bill.getBillDetails().get(i).getCgst();
						 sgst = sgst+bill.getBillDetails().get(i).getSgst();
						 taxableAmt = taxableAmt+bill.getBillDetails().get(i).getTaxableAmt();
						 finalTaxAmt = finalTaxAmt + bill.getBillDetails().get(i).getTotalTax(); 
						 break;
					 }
				 }
			 }
			 
			  
			 bill.setGrandTotal(grandTotal);
			 bill.setPayableAmt(taxableAmt+finalTaxAmt);
			 bill.setCgst(cgst);
			 bill.setSgst(sgst);
			 bill.setTaxableAmount(taxableAmt);  
			 System.out.println(bill);
			 
			 finalsave = billRepository.save(bill); 
			 List<BillDetails> saveDetail = billDetailsRepository.saveAll(bill.getBillDetails()); 
			 
			 
			 System.out.println("FINAL SAVE : -------------------------------"+finalsave);
			 System.out.println("FINAL SAVE DETAIL : -------------------------------"+saveDetail);
			 List<BillDetails> getDetail = billDetailsRepository.findByBillIdAndDelStatus(bill.getBillId(),1);
			 finalsave.setBillDetails(getDetail);
				 
		} catch (Exception e) {

			e.printStackTrace(); 

		}
		return finalsave;

	}
	
	 @RequestMapping(value = { "/getBillHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBill> getBillHeaderAndDetail(@RequestParam("date") String date,@RequestParam("type")int type,@RequestParam("bill_closed")int bill_closed) {

		 List<GetBill> getBillHeaderAndDetail = new ArrayList<GetBill>();
		try {
			   
				  getBillHeaderAndDetail = getBillRepository.getBillByDate(date,type,bill_closed); 
				  
				  for(int i = 0 ; i<getBillHeaderAndDetail.size() ; i++)
				  {
					  List<BillDetails> getDetail = billDetailsRepository.getDetail(getBillHeaderAndDetail.get(i).getBillId());
					  getBillHeaderAndDetail.get(i).setBillDetails(getDetail);
					  if(type == 2)
					  {
						  String name = getBillRepository.getParcelName(getDetail.get(0).getOrderId());
						  String mobileNo = getBillRepository.getMobileNo(getDetail.get(0).getOrderId());
						  getBillHeaderAndDetail.get(i).setName(name);
						  getBillHeaderAndDetail.get(i).setMobileNo(mobileNo);
					  }
				  }
				   
				 
				  
				 
		} catch (Exception e) {

			e.printStackTrace(); 

		}
		return getBillHeaderAndDetail;

	} 

}
