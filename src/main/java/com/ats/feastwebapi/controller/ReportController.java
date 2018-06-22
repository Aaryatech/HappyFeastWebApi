package com.ats.feastwebapi.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.feastwebapi.model.BillMonthwise;
import com.ats.feastwebapi.model.GetBillDatewiseReport;
import com.ats.feastwebapi.model.GetBillHeader;
import com.ats.feastwebapi.model.GetItemReport;
import com.ats.feastwebapi.model.GetOrderCancellation;
import com.ats.feastwebapi.model.GetTableWiseReport;
import com.ats.feastwebapi.model.ItemWiseReport;
import com.ats.feastwebapi.repository.BillDetailsRepository;
import com.ats.feastwebapi.repository.BillMonthwiseRepo;
import com.ats.feastwebapi.repository.BillRepository;
import com.ats.feastwebapi.repository.GetBillDatewiseReportRepo;
import com.ats.feastwebapi.repository.GetBillHeaderRepo;
import com.ats.feastwebapi.repository.GetItemReportRepo;
import com.ats.feastwebapi.repository.GetOrderCancellationRepo;
import com.ats.feastwebapi.repository.GetTableWiseReportRepo;
import com.ats.feastwebapi.repository.ItemWiseReportRepo;

@RestController
public class ReportController {

	@Autowired
	BillRepository billRepository;

	@Autowired
	GetBillDatewiseReportRepo getBillDatewiseReportRepo;

	@Autowired
	BillMonthwiseRepo billMonthwiseRepo;

	@Autowired
	GetTableWiseReportRepo getTableWiseReportRepo;

	@Autowired
	GetItemReportRepo getItemReportRepo;

	@Autowired
	GetBillHeaderRepo getBillHeaderRepo;

	@Autowired
	BillDetailsRepository billDetailsRepository;

	@Autowired
	GetOrderCancellationRepo getOrderCancellationRepo;

	@Autowired
	ItemWiseReportRepo itemWiseReportRepo;

	@RequestMapping(value = "/getAllBillWiseReport", method = RequestMethod.POST)
	public @ResponseBody List<GetBillHeader> getAllBillWiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetBillHeader> getBillList;
		try {
			getBillList = getBillHeaderRepo.findAllBillHeaders(fromDate, toDate);
		} catch (Exception e) {
			getBillList = new ArrayList<>();
			e.printStackTrace();

		}
		return getBillList;

	}

	@RequestMapping(value = "/getItemwiseReport", method = RequestMethod.POST)
	public @ResponseBody List<GetItemReport> getItemwiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetItemReport> getItemList;
		try {
			getItemList = getItemReportRepo.findAllItem(fromDate, toDate);
		} catch (Exception e) {
			getItemList = new ArrayList<>();
			e.printStackTrace();

		}
		return getItemList;

	}

	@RequestMapping(value = "/getDatewiseReport", method = RequestMethod.POST)
	public @ResponseBody List<GetBillDatewiseReport> getDatewiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetBillDatewiseReport> getItemList;
		try {
			getItemList = getBillDatewiseReportRepo.findDateWiseTotal(fromDate, toDate);
		} catch (Exception e) {
			getItemList = new ArrayList<>();
			e.printStackTrace();

		}
		return getItemList;

	}

	@RequestMapping(value = "/getTableWiseReport", method = RequestMethod.POST)
	public @ResponseBody List<GetTableWiseReport> getTableWiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetTableWiseReport> getItemList;
		try {
			getItemList = getTableWiseReportRepo.findTablesTotal(fromDate, toDate);
		} catch (Exception e) {
			getItemList = new ArrayList<>();
			e.printStackTrace();

		}
		return getItemList;

	}

	@RequestMapping(value = "/getOrderCancellationWiseReport", method = RequestMethod.POST)
	public @ResponseBody List<GetOrderCancellation> getOrderCancellationWiseReport(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetOrderCancellation> getItemList;
		try {
			getItemList = getOrderCancellationRepo.findCancleOrder(fromDate, toDate);
		} catch (Exception e) {
			getItemList = new ArrayList<>();
			e.printStackTrace();

		}
		return getItemList;

	}

	@RequestMapping(value = "/getBillMonthWiseReport", method = RequestMethod.POST)
	public @ResponseBody List<BillMonthwise> getBillMonthWiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<BillMonthwise> billMonthwise;
		try {
			billMonthwise = billMonthwiseRepo.findMonthwise(fromDate, toDate);
		} catch (Exception e) {
			billMonthwise = new ArrayList<>();
			e.printStackTrace();

		}
		return billMonthwise;

	}

	@RequestMapping(value = "/getAllItemwiseCanReport", method = RequestMethod.POST)
	public @ResponseBody List<ItemWiseReport> getAllItemwiseCanReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<ItemWiseReport> getItemList;
		try {
			getItemList = itemWiseReportRepo.findItemwiseReport(fromDate, toDate);
		} catch (Exception e) {
			getItemList = new ArrayList<>();
			e.printStackTrace();

		}
		return getItemList;

	}

}
