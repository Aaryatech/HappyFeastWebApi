package com.ats.feastwebapi.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ats.feastwebapi.model.ErrorMessage;

@RestController
public class ImageUploadController {

//	private static String CATEGORY_URL = "/opt/apache-tomcat-8.5.6/webapps/happyfeast/uploads/category/";
//	private static String ITEM_URL = "/opt/apache-tomcat-8.5.6/webapps/happyfeast/uploads/item/";

	private static String CATEGORY_URL = "/apache-tomcat-8.5.6/webapps/happyfeastuploads/category/";
	private static String ITEM_URL = "/apache-tomcat-8.5.6/webapps/happyfeastuploads/item/";

	@RequestMapping(value = { "/photoUpload" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage getFarmerContract(@RequestParam("file") MultipartFile uploadfile,
			@RequestParam("imageName") String imageName, @RequestParam("type") String type) {

		ErrorMessage info = new ErrorMessage();

		System.out.println("File Name " + uploadfile.getOriginalFilename());

		try {

			saveUploadedFiles(Arrays.asList(uploadfile), imageName, type);

			info.setError(false);
			info.setMessage("File uploaded successfully");

		} catch (IOException e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage("File upload failed");
		}

		return info;
	}

	// save file
	private void saveUploadedFiles(List<MultipartFile> files, String imageName, String type) throws IOException {

		try {
			for (MultipartFile file : files) {
				Path path = null;
				if (file.isEmpty()) {
					continue;
				}
				if (type.equalsIgnoreCase("category")) {
					path = Paths.get(CATEGORY_URL + imageName);
				} else if (type.equalsIgnoreCase("item")) {
					path = Paths.get(ITEM_URL + imageName);

				}

				byte[] bytes = file.getBytes();

				Files.write(path, bytes);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
