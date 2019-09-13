package com.trade.autumnboot.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.trade.autumnboot.dto.MockData;

@Component
public class FileUtils {

	private static final String BASE_PATH = "src/main/resources/data/";
	private static final String DOWNLOAD_ENDPOINT = "http://localhost:8080/download/data/";

	@Autowired
	ObjectMapper objectMapper;

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
			File folder = new File(BASE_PATH);
			File[] listOfFiles = folder.listFiles();
			fileList = Arrays.stream(listOfFiles).map(file -> {
				return file.getName();
			}).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileList;
	}

	public String delete(String fileName) {
		String status = "FILE NOT FOUND";

		try {
			Files.delete((Paths.get((BASE_PATH + fileName))));
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

	public List<String> downloadFiles(List<String> filteredFileList) {
		List<String> downloadList = filteredFileList.stream().map(filename -> {
			return DOWNLOAD_ENDPOINT + filename;
		}).collect(Collectors.toList());
		return downloadList;
	}

	public List<String> filterFiles(String ticker, String generatorType, List<String> allFilesList) {
		List<String> filteredFileList = allFilesList.stream().filter(fileName -> {
			String[] tokenArray = fileName.split("[_\\.]");
			List<String> tokenList = Arrays.asList(tokenArray);
			return (ticker == null
					|| tokenList.contains(ticker) && (generatorType == null || tokenList.stream().anyMatch(tokenStr -> {
						return tokenStr.equalsIgnoreCase(generatorType);
					})));
		}).collect(Collectors.toList());
		return filteredFileList;
	}
}
