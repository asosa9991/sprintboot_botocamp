package com.trade.autumnboot.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FileListResponse {
	
	private List<String> fileList;
	private int fileCount;
	
	public List<String> getFileList() {
		return fileList;
	}
	public void setFileList(List<String> fileList) {
		this.fileList = fileList;
	}
	public int getFileCount() {
		return fileCount;
	}
	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}
	
	

}
