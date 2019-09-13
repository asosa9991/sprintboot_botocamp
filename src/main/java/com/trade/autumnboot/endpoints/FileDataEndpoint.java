package com.trade.autumnboot.endpoints;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	public FileListResponse dataFiles(@RequestParam(required = false) Map<String, String> searchAttributes) {

		fileListResponse.setFileList(fileUtils.list());
		fileListResponse.setFileCount(fileListResponse.getFileList().size());

		return fileListResponse;
	}

	@DeleteMapping("/{filename}")
	public void deleteFile(@PathVariable("filename") String fileName) {
		String fileStatus = fileUtils.delete(fileName);
		if (fileStatus.equals("FILE NOT FOUND")) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
