package com.ats.feastwebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.ats.feastwebapi.model.ErrorMessage;
import com.ats.feastwebapi.model.Order;
import com.ats.feastwebapi.model.OrderDetails;
import com.ats.feastwebapi.model.OrderList;
import com.ats.feastwebapi.repository.OrderDetailRepository;
import com.ats.feastwebapi.repository.OrderListRepository;
import com.ats.feastwebapi.repository.OrderRepository;

@RestController
public class OrderController {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Autowired
	OrderListRepository orderListRepository;
	
	// -----------------Order --------------------

	@RequestMapping(value = { "/saveOrder" }, method = RequestMethod.POST)
	public @ResponseBody Order saveOrder(@RequestBody Order order) {

		Order orderRes = new Order();
		try {

			List<OrderDetails> orderDetailList = new ArrayList<>();

			orderRes = orderRepository.saveAndFlush(order);

			for (int i = 0; i <= orderRes.getOrderDetailList().size(); i++) {

				orderRes.getOrderDetailList().get(i).setOrderId(orderRes.getOrderId());

				OrderDetails orderDetailRes = orderDetailRepository.saveAndFlush(orderRes.getOrderDetailList().get(i));
				orderDetailList.add(orderDetailRes);

			}
			orderRes.setOrderDetailList(orderDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orderRes;

	}

	@RequestMapping(value = { "/getNoOfKot" }, method = RequestMethod.POST)
	public @ResponseBody List<OrderList> getNoOfKot(@RequestParam("tableNo") int tableNo) {

		List<OrderList> order = null;
		try {
			order = orderListRepository.findByTableNoAndBillStatus(tableNo);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return order;

	}

	@RequestMapping(value = { "/getOrdeByOrderId" }, method = RequestMethod.POST)
	public @ResponseBody Order getOrdeByOrderId(@RequestParam("orderId") int orderId) {

		Order order = null;
		try {
			order = orderRepository.findByOrderId(orderId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return order;

	}

	@RequestMapping(value = { "/getAllOredersByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Order> getAllOredersByIsUsed() {

		List<Order> orderList = new ArrayList<Order>();

		try {

			orderList = orderRepository.findAllByDelStatus(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orderList;

	}

	@RequestMapping(value = { "/deleteOrder" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteOrder(@RequestParam("orderId") int orderId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = orderRepository.deleteOrder(orderId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}
	
	
	@RequestMapping(value = { "/getOrderDetailByOrderDetailId" }, method = RequestMethod.POST)
	public @ResponseBody OrderDetails getOrderDetailByOrderDetailId(@RequestParam("orderDetailsId") int orderDetailsId) {

		OrderDetails order = null;
		try {
			order = orderDetailRepository.findByOrderDetailsId(orderDetailsId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return order;

	}

	@RequestMapping(value = { "/getAllOrderDetailsByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<OrderDetails> getAllOrderDetailsByIsUsed() {

		List<OrderDetails> orderList = new ArrayList<OrderDetails>();

		try {

			orderList = orderDetailRepository.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orderList;

	}

	
	
	@RequestMapping(value = { "/deleteOrderDetail" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteOrderDetail(@RequestParam("orderDetailsId") int orderDetailsId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = orderDetailRepository.deleteOrderDetail(orderDetailsId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

}
