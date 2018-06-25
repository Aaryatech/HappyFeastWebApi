package com.ats.feastwebapi.controller;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.feastwebapi.model.Admin;
import com.ats.feastwebapi.model.Bill;
import com.ats.feastwebapi.model.BillDetails;
import com.ats.feastwebapi.model.ErrorMessage;
import com.ats.feastwebapi.model.Item;
import com.ats.feastwebapi.model.LoginProcess; 
import com.ats.feastwebapi.model.OrderDetailsList;
import com.ats.feastwebapi.model.OrderHeaderList;
import com.ats.feastwebapi.model.TableList;
import com.ats.feastwebapi.model.TableSetting;
import com.ats.feastwebapi.repository.AdminRepository;
import com.ats.feastwebapi.repository.BillDetailsRepository;
import com.ats.feastwebapi.repository.BillRepository;
import com.ats.feastwebapi.repository.ItemRepository;
import com.ats.feastwebapi.repository.OrderDetailRepository;
import com.ats.feastwebapi.repository.OrderDetailsListRepository;
import com.ats.feastwebapi.repository.OrderHeaderListRepository;
import com.ats.feastwebapi.repository.OrderRepository;
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
				 }
				 
				 save.setBillDate(date);
				 save.setDelStatus(1);
				 save.setUserId(userId);
				 save.setEnterBy(userId);
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
					errorMessage.setMessage("inserted successfully");  
					  
					String[] splt = tableSetting.getBillNo().split("-");
					System.out.println(splt);
					int billNo=Integer.parseInt(splt[1])+1;
				    String finalBillNo = new String();
				    
				    for(int i=0;i<=5-billNo;i++)
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
				errorMessage.setError(true);
				errorMessage.setMessage("faid to insert"); 
			}
			 
		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("faid to insert"); 

		}
		return errorMessage;

	}

}
