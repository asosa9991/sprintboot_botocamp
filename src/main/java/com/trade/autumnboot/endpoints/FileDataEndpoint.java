package com.trade.autumnboot.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.trade.autumnboot.domain.quotes.Summary;
import com.trade.autumnboot.dto.FileListResponse;
import com.trade.autumnboot.utils.FileUtils;

@RestController
@RequestMapping("/datafiles")
public class FileDataEndpoint {

	@Autowired
	private FileUtils fileUtils;

	@Autowired
	private FileListResponse fileListResponse;

	@GetMapping
	public FileListResponse dataFiles(@RequestParam(name = "ticker", required = false) String ticker,
			@RequestParam(name = "generatorType", required = false) String generatorType) {

		List<String> allFilesList = fileUtils.list();
		Summary summary = new Summary();

		List<String> filteredFileList = fileUtils.filterFiles(ticker, generatorType, allFilesList);
		fileListResponse.setFileList(filteredFileList);

		List<String> downloadList = fileUtils.downloadFiles(filteredFileList);
		fileListResponse.setDownloadList(downloadList);

//		Summary fileSummary = summary.getSummary(filteredFileList.size(), allFilesList);
//		fileListResponse.setSummary(fileSummary);

		return fileListResponse;
	}

	@DeleteMapping("/{filename:.+}")
	public void deleteFile(@PathVariable("filename") String fileName) {
		String fileStatus = fileUtils.delete(fileName);
		if (fileStatus.equals("FILE NOT FOUND")) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
