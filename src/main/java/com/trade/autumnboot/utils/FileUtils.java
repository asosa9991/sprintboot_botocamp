package com.trade.autumnboot.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.trade.autumnboot.dto.MockData;

@Component
public class FileUtils {

	private static final String BASE_PATH = "src/main/resources/data/";
	private static final String FILES_TO_RETRIEVE = "classpath:data/*.json";
	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	private ApplicationContext applicationContext;

	public String store(String ticker, String startDate, String endDate, String generatorType,
			List<MockData> mockDataList, boolean appendTimeStamp) {
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

		try {
			String fileName = BASE_PATH + ticker + "_" + startDate + "_" + endDate + "_" + generatorType
					+ (appendTimeStamp ? "_" + System.currentTimeMillis() + ".json" : ".json");
			objectMapper.writeValue(new File(fileName), mockDataList);
			return fileName;

		} catch (IOException e) {
			e.printStackTrace();
			return null;

		}

	}

	public List<String> list() {
		List<String> fileList = new ArrayList<>();
		try {
			Resource[] resourceList = applicationContext.getResources(FILES_TO_RETRIEVE);
			fileList = Arrays.stream(resourceList).map(resource -> {
				return resource.getFilename();
			}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileList;
	}

	public String delete(String fileName) {

		String status = "FILE NOT FOUND";

		try {
			Files.delete((Paths.get(("src/main/resources/data/" + fileName))));
			System.out.println("Deletion successful.");
			status = "DELETED";
			return status;
		} catch (NoSuchFileException e) {
			System.out.println("No such file/directory exists");
			return status;
		} catch (IOException e) {
			System.out.println("Invalid permissions.");
			return status;
		}
	}
}
