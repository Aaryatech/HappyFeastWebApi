package com.ats.feastwebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.feastwebapi.model.Admin;
import com.ats.feastwebapi.model.ErrorMessage;
import com.ats.feastwebapi.model.LoginProcess;
import com.ats.feastwebapi.model.Order;
import com.ats.feastwebapi.model.OrderDetails;
import com.ats.feastwebapi.model.TableList;
import com.ats.feastwebapi.repository.AdminRepository;
import com.ats.feastwebapi.repository.OrderDetailRepository;
import com.ats.feastwebapi.repository.OrderRepository;
import com.ats.feastwebapi.repository.TableListRepository;

@RestController
public class TransactionRestController {
	
	@Autowired
	TableListRepository tableListRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	
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
	public @ResponseBody List<Order> orderListByTableNo(@RequestParam("tableNo") int tableNo) {

		List<Order> orders = new ArrayList<Order>();
		try {

			orders = orderRepository.findByTableNoAndBillStatusAndDelStatus(tableNo,1,1);
			
			for(int i=0; i<orders.size();i++)
			{
				 List<OrderDetails> orderDetails = orderDetailRepository.findByOrderIdAndStatus(orders.get(i).getOrderId(),1);
				 orders.get(i).setOrderDetailList(orderDetails);
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

}
