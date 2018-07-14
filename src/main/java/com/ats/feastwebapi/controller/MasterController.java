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

import com.ats.feastwebapi.model.Admin;
import com.ats.feastwebapi.model.CancleMessage;
import com.ats.feastwebapi.model.Category;
import com.ats.feastwebapi.model.CategoryWithItemList;
import com.ats.feastwebapi.model.ErrorMessage;
import com.ats.feastwebapi.model.GetCatInfo;
import com.ats.feastwebapi.model.Item;
import com.ats.feastwebapi.model.Offers;
import com.ats.feastwebapi.model.Order;
import com.ats.feastwebapi.model.OrderDetails;
import com.ats.feastwebapi.model.ParcelOrder;
import com.ats.feastwebapi.model.ParcelOrderDetails;
import com.ats.feastwebapi.model.Question;
import com.ats.feastwebapi.model.Settings;
import com.ats.feastwebapi.model.TableBean;
import com.ats.feastwebapi.model.TableCat;
import com.ats.feastwebapi.model.User;
import com.ats.feastwebapi.repository.AdminRepository;
import com.ats.feastwebapi.repository.CancleMessageRepository;
import com.ats.feastwebapi.repository.CategoryRepository;
import com.ats.feastwebapi.repository.CategoryWithItemListRepository;
import com.ats.feastwebapi.repository.GetCatInfoRepo;
import com.ats.feastwebapi.repository.ItemRepository;
import com.ats.feastwebapi.repository.OffersRepository;
import com.ats.feastwebapi.repository.ParcelOrderDetailsRepository;
import com.ats.feastwebapi.repository.ParcelOrderRepository;
import com.ats.feastwebapi.repository.QuestionRepository;
import com.ats.feastwebapi.repository.SeetingsRepository;
import com.ats.feastwebapi.repository.TableBeanRepository;
import com.ats.feastwebapi.repository.TableCatRepository;
import com.ats.feastwebapi.repository.UserRepository;

@RestController
public class MasterController {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	GetCatInfoRepo getCatInfoRepo;

	@Autowired
	SeetingsRepository seetingsRepository;

	@Autowired
	OffersRepository offersRepository;

	@Autowired
	CancleMessageRepository cancleMessageRepository;

	@Autowired
	TableBeanRepository tableBeanRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TableCatRepository tableCatRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	CategoryWithItemListRepository categoryWithItemListRepository;

	@Autowired
	ParcelOrderRepository parcelOrderRepository;

	@Autowired
	ParcelOrderDetailsRepository parcelOrderDetailsRepository;

	// -----------------ADMIN --------------------

	@RequestMapping(value = { "/saveAdmin" }, method = RequestMethod.POST)
	public @ResponseBody Admin saveAdmin(@RequestBody Admin admin) {

		Admin adminRes = new Admin();

		try {

			adminRes = adminRepository.saveAndFlush(admin);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return adminRes;

	}

	@RequestMapping(value = { "/getAdminByAdminId" }, method = RequestMethod.POST)
	public @ResponseBody Admin getAdminByAdminId(@RequestParam("adminId") int adminId) {

		Admin admin = null;
		try {
			admin = adminRepository.findByAdminId(adminId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return admin;

	}

	@RequestMapping(value = { "/getAllAdminByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Admin> getAllAdminByIsUsed() {

		List<Admin> adminList = new ArrayList<Admin>();

		try {

			adminList = adminRepository.findAllByDelStatus(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return adminList;

	}

	@RequestMapping(value = { "/deleteAdmin" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteAdmin(@RequestParam("adminId") int adminId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = adminRepository.deleteAdmin(adminId);

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

	// ------------------Item -------------------

	@RequestMapping(value = { "/saveItem" }, method = RequestMethod.POST)
	public @ResponseBody Item saveItem(@RequestBody Item item) {

		Item res = new Item();

		try {

			res = itemRepository.saveAndFlush(item);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getItemByItemId" }, method = RequestMethod.POST)
	public @ResponseBody Item getItemByItemId(@RequestParam("itemId") int itemId) {

		Item item = null;
		try {
			item = itemRepository.findByItemId(itemId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return item;

	}

	@RequestMapping(value = { "/getAllItemByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Item> getAllItemByIsUsed() {

		List<Item> itemList = new ArrayList<Item>();

		try {

			itemList = itemRepository.findAllByDelStatusOrderByCatId(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

	@RequestMapping(value = { "/deleteItem" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteItem(@RequestParam("itemId") int itemId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = itemRepository.deleteItem(itemId);

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

	// ----------------Question -------------------

	@RequestMapping(value = { "/saveQuestion" }, method = RequestMethod.POST)
	public @ResponseBody Question saveQuestion(@RequestBody Question question) {

		Question res = new Question();

		try {

			res = questionRepository.saveAndFlush(question);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getQuestionByQueNo" }, method = RequestMethod.POST)
	public @ResponseBody Question getQuestionByQueNo(@RequestParam("questionNo") int questionNo) {

		Question question = null;
		try {
			question = questionRepository.findByQuestionNo(questionNo);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return question;

	}

	@RequestMapping(value = { "/getAllQuestionByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Question> getAllQuestionByIsUsed() {

		List<Question> queList = new ArrayList<Question>();

		try {

			queList = questionRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return queList;

	}

	@RequestMapping(value = { "/deleteQuestion" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteQuestion(@RequestParam("questionNo") int questionNo) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = questionRepository.deleteQuestion(questionNo);

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

	// ------------------Category -------------------

	@RequestMapping(value = { "/saveCategory" }, method = RequestMethod.POST)
	public @ResponseBody Category saveCategory(@RequestBody Category category) {

		Category res = new Category();

		try {

			res = categoryRepository.saveAndFlush(category);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getCatByCatId" }, method = RequestMethod.POST)
	public @ResponseBody Category getCatByCatId(@RequestParam("catId") int catId) {

		Category category = null;
		try {
			category = categoryRepository.findByCatId(catId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return category;

	}

	@RequestMapping(value = { "/getAllCatByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCatByIsUsed() {

		List<Category> catList = new ArrayList<Category>();

		try {

			catList = categoryRepository.findAllByDelStatus(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return catList;

	}

	@RequestMapping(value = { "/deleteCategory" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteCategory(@RequestParam("catId") int catId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = categoryRepository.deleteCategory(catId);

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

	// ------------------TABLE-------------------

	@RequestMapping(value = { "/saveTable" }, method = RequestMethod.POST)
	public @ResponseBody TableBean saveTable(@RequestBody TableBean tableBean) {

		TableBean res = new TableBean();

		try {

			res = tableBeanRepository.saveAndFlush(tableBean);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getTableByTableId" }, method = RequestMethod.POST)
	public @ResponseBody TableBean getTableByTableId(@RequestParam("tableId") int tableId) {

		TableBean tableBean = null;
		try {
			tableBean = tableBeanRepository.findByTableId(tableId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return tableBean;

	}

	@RequestMapping(value = { "/getAllTablesByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<TableBean> getAllTablesByIsUsed() {

		List<TableBean> tableList = new ArrayList<TableBean>();

		try {

			tableList = tableBeanRepository.findAllByIsDelete(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return tableList;

	}

	@RequestMapping(value = { "/deleteTable" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteTable(@RequestParam("tableId") int tableId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = tableBeanRepository.deleteTableBean(tableId);

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

	// ------------------TABLE-------------------

	@RequestMapping(value = { "/saveTableCat" }, method = RequestMethod.POST)
	public @ResponseBody TableCat saveTableCat(@RequestBody TableCat tableCat) {

		TableCat res = new TableCat();

		try {

			res = tableCatRepository.saveAndFlush(tableCat);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getTableCatByTableCatId" }, method = RequestMethod.POST)
	public @ResponseBody TableCat getTableCatByTableCatId(@RequestParam("tableCatId") int tableCatId) {

		TableCat tableCat = null;
		try {
			tableCat = tableCatRepository.findByTableCatId(tableCatId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return tableCat;

	}

	@RequestMapping(value = { "/getAllTablesCatByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<TableCat> getAllTablesCatByIsUsed() {

		List<TableCat> tableList = new ArrayList<TableCat>();

		try {

			tableList = tableCatRepository.findAllByIsActive(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return tableList;

	}

	@RequestMapping(value = { "/deleteTableCat" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteTableCat(@RequestParam("tableCatId") int tableCatId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = tableCatRepository.deleteTableCat(tableCatId);

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

	// -----------------User------------------------------

	@RequestMapping(value = { "/saveUser" }, method = RequestMethod.POST)
	public @ResponseBody User saveUser(@RequestBody User user) {

		User userRes = new User();
		try {

			userRes = userRepository.saveAndFlush(user);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userRes;

	}

	@RequestMapping(value = { "/getUserByUserId" }, method = RequestMethod.POST)
	public @ResponseBody User getUserByUserId(@RequestParam("userId") int userId) {

		User useRes = null;
		try {
			useRes = userRepository.findByUserId(userId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return useRes;

	}

	@RequestMapping(value = { "/getAllUsers" }, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {

		List<User> userList = new ArrayList<User>();

		try {

			userList = userRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userList;

	}

	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteUser(@RequestParam("userId") int userId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = userRepository.deleteUser(userId);

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

	@RequestMapping(value = { "/getAllCategoryWithItemList" }, method = RequestMethod.GET)
	public @ResponseBody List<CategoryWithItemList> getAllCategoryWithItemList() {

		List<CategoryWithItemList> categoryWithItemLists = new ArrayList<CategoryWithItemList>();
		try {

			categoryWithItemLists = categoryWithItemListRepository.findAllByDelStatus();

			for (int i = 0; i < categoryWithItemLists.size(); i++) {
				List<Item> itemList = itemRepository.findAllByCatIdAndDelStatus(categoryWithItemLists.get(i).getCatId(),
						1);
				categoryWithItemLists.get(i).setItemList(itemList);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return categoryWithItemLists;

	}

	@RequestMapping(value = { "/saveParcelOrder" }, method = RequestMethod.POST)
	public @ResponseBody ParcelOrder saveParcelOrder(@RequestBody ParcelOrder parcelOrder) {

		ParcelOrder save = new ParcelOrder();
		try {

			save = parcelOrderRepository.save(parcelOrder);

			for (int i = 0; i < parcelOrder.getParcelOrderDetailsList().size(); i++)
				parcelOrder.getParcelOrderDetailsList().get(i).setParcelOrderId(save.getParcelOrderId());

			List<ParcelOrderDetails> parcelOrderDetails = parcelOrderDetailsRepository
					.saveAll(parcelOrder.getParcelOrderDetailsList());
			save.setParcelOrderDetailsList(parcelOrderDetails);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return save;

	}

	@RequestMapping(value = { "/getParcelOrder" }, method = RequestMethod.POST)
	public @ResponseBody ParcelOrder getParcelOrder(@RequestParam("parcelOrderId") int parcelOrderId) {

		ParcelOrder parcelOrder = new ParcelOrder();
		try {
			parcelOrder = parcelOrderRepository.findByParcelOrderId(parcelOrderId);

			List<ParcelOrderDetails> parcelOrderDetails = parcelOrderDetailsRepository
					.findByParcelOrderId(parcelOrderId);
			parcelOrder.setParcelOrderDetailsList(parcelOrderDetails);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return parcelOrder;

	}

	@RequestMapping(value = { "/deleteParcelOrder" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteParcelOrder(@RequestParam("parcelOrderId") int parcelOrderId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = parcelOrderRepository.deleteparcelOrder(parcelOrderId);

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

	// ----------------Cancle Message---------------
	@RequestMapping(value = { "/getAllMessage" }, method = RequestMethod.GET)
	public @ResponseBody List<CancleMessage> getAllMessage() {

		List<CancleMessage> cancleMessage = new ArrayList<CancleMessage>();

		try {

			cancleMessage = cancleMessageRepository.findByDelStatus(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return cancleMessage;

	}

	@RequestMapping(value = { "/saveCancleMessage" }, method = RequestMethod.POST)
	public @ResponseBody CancleMessage saveCancleMessage(@RequestBody CancleMessage cancleMessage) {

		CancleMessage cancleMessageRes = new CancleMessage();

		try {

			cancleMessageRes = cancleMessageRepository.saveAndFlush(cancleMessage);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return cancleMessageRes;

	}

	@RequestMapping(value = { "/getMessageByMsgId" }, method = RequestMethod.POST)
	public @ResponseBody CancleMessage getMessageByMsgId(@RequestParam("msgId") int msgId) {

		CancleMessage cancleMessage = null;
		try {
			cancleMessage = cancleMessageRepository.findByMsgId(msgId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return cancleMessage;

	}

	@RequestMapping(value = { "/deleteCancleMessage" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteCancleMessage(@RequestParam("msgId") int msgId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = cancleMessageRepository.deleteCancleMessage(msgId);

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

	// ---------------Offers--------------------------

	@RequestMapping(value = { "/saveOffers" }, method = RequestMethod.POST)
	public @ResponseBody Offers saveOffers(@RequestBody Offers offers) {

		Offers offersRes = new Offers();

		try {

			offersRes = offersRepository.saveAndFlush(offers);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return offersRes;

	}

	@RequestMapping(value = { "/getAllOffers" }, method = RequestMethod.GET)
	public @ResponseBody List<Offers> getAllOffers() {

		List<Offers> offers = new ArrayList<Offers>();

		try {

			offers = offersRepository.findByDelStatus(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return offers;

	}

	@RequestMapping(value = { "/deleteOffers" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteOffers(@RequestParam("offerId") int offerId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = offersRepository.deleteOffers(offerId);

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

	@RequestMapping(value = { "/getOffersByOfferId" }, method = RequestMethod.POST)
	public @ResponseBody Offers getOffersByOfferId(@RequestParam("offerId") int offerId) {

		Offers offers = null;
		try {
			offers = offersRepository.findByOfferIdAndDelStatus(offerId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return offers;

	}

	// ---------------Settings---------------------------------

	@RequestMapping(value = { "/saveSettings" }, method = RequestMethod.POST)
	public @ResponseBody Settings saveSettings(@RequestBody Settings settings) {

		Settings settingsRes = new Settings();

		try {

			settingsRes = seetingsRepository.saveAndFlush(settings);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return settingsRes;

	}

	@RequestMapping(value = { "/getAllSettings" }, method = RequestMethod.GET)
	public @ResponseBody List<Settings> getAllSettings() {

		List<Settings> settings = new ArrayList<Settings>();

		try {

			settings = seetingsRepository.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return settings;

	}

	@RequestMapping(value = { "/getSettingById" }, method = RequestMethod.POST)
	public @ResponseBody Settings getSettingById(@RequestParam("id") int id) {

		Settings settings = new Settings();

		try {

			settings = seetingsRepository.findById(id);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return settings;

	}

	@RequestMapping(value = { "/getCategoryInfo" }, method = RequestMethod.GET)
	public @ResponseBody List<GetCatInfo> getCategoryInfo() {

		List<GetCatInfo> getCatInfoList = new ArrayList<GetCatInfo>();

		try {

			getCatInfoList = getCatInfoRepo.getCategoryInformantion();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getCatInfoList;

	}

}