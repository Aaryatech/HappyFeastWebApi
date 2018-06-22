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
import com.ats.feastwebapi.model.DateItemReport;
import com.ats.feastwebapi.model.GetBillDatewiseReport;
import com.ats.feastwebapi.model.GetBillHeader;
import com.ats.feastwebapi.model.GetItemReport;
import com.ats.feastwebapi.model.GetOrderCancellation;
import com.ats.feastwebapi.model.GetTableWiseReport;
import com.ats.feastwebapi.model.HsnCodeItemwiseReport;
import com.ats.feastwebapi.model.ItemWiseReport;
import com.ats.feastwebapi.model.TaxLabwiseReport;
import com.ats.feastwebapi.repository.BillDetailsRepository;
import com.ats.feastwebapi.repository.BillMonthwiseRepo;
import com.ats.feastwebapi.repository.BillRepository;
import com.ats.feastwebapi.repository.DateItemRepsitory;
import com.ats.feastwebapi.repository.GetBillDatewiseReportRepo;
import com.ats.feastwebapi.repository.GetBillHeaderRepo;
import com.ats.feastwebapi.repository.GetItemReportRepo;
import com.ats.feastwebapi.repository.GetOrderCancellationRepo;
import com.ats.feastwebapi.repository.GetTableWiseReportRepo;
import com.ats.feastwebapi.repository.HsnCodeItemwiseRepository;
import com.ats.feastwebapi.repository.ItemWiseReportRepo;
import com.ats.feastwebapi.repository.TaxLabwiseRepository;

@RestController
public class ReportController {

	@Autowired
	BillRepository billRepository;

	@Autowired
	DateItemRepsitory dateItemRepsitory;

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

	@Autowired
	TaxLabwiseRepository taxLabwiseRepository;
	@Autowired
	HsnCodeItemwiseRepository hsnCodeItemwiseRepository;

	@RequestMapping(value = "/getBillWiseReport", method = RequestMethod.POST)
	public @ResponseBody List<GetBillHeader> getBillWiseReport(@RequestParam("fromDate") String fromDate,
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

	@RequestMapping(value = "/getItemCategorywiseReport", method = RequestMethod.POST)
	public @ResponseBody List<GetItemReport> getItemCategorywiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetItemReport> getItemList;
		try {
			getItemList = getItemReportRepo.findAllItemCategorywise(fromDate, toDate);
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

	@RequestMapping(value = "/getItemhsoncodewiseReport", method = RequestMethod.POST)
	public @ResponseBody List<HsnCodeItemwiseReport> getItemhsoncodewiseReport(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<HsnCodeItemwiseReport> getItemList;
		try {
			getItemList = hsnCodeItemwiseRepository.findHsonCodeReport(fromDate, toDate);
		} catch (Exception e) {
			getItemList = new ArrayList<>();
			e.printStackTrace();

		}
		return getItemList;

	}

	@RequestMapping(value = "/getTaxLabewiseReport", method = RequestMethod.POST)
	public @ResponseBody List<TaxLabwiseReport> getTaxLabewiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<TaxLabwiseReport> getList;
		try {
			getList = taxLabwiseRepository.findTaxLabwiseReport(fromDate, toDate);
		} catch (Exception e) {
			getList = new ArrayList<>();
			e.printStackTrace();

		}
		return getList;

	}

	@RequestMapping(value = "/getDateItemwiseReport", method = RequestMethod.POST)
	public @ResponseBody List<DateItemReport> getDateItemwiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("status") int status,
			@RequestParam("itemIdList") List<Integer> itemIdList) {

		List<DateItemReport> getList;
		try {

			if (status == 0) {
				getList = dateItemRepsitory.findAllItemDateWiseReport(fromDate, toDate);
			} else {
				getList = dateItemRepsitory.findItemwiseDateWiseReport(fromDate, toDate, itemIdList);
			}
		} catch (Exception e) {
			getList = new ArrayList<>();
			e.printStackTrace();

		}
		return getList;

	}

}
