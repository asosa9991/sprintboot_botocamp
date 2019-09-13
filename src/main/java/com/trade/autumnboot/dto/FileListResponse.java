package com.trade.autumnboot.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trade.autumnboot.domain.quotes.Summary;

import io.swagger.annotations.ApiModel;

@Component
@ApiModel
public class FileListResponse {
	
	private List<String> fileList;
	private List<String> downloadList;
	private Summary summary;
	
	public List<String> getFileList() {
		return fileList;
	}
	public void setFileList(List<String> fileList) {
		this.fileList = fileList;
	}
	public Summary getSummary() {
		return summary;
	}
	
	public void setSummary(Summary summary) {
		this.summary = summary;
	}
	public List<String> getDownloadList() {
		return downloadList;
	}
	public void setDownloadList(List<String> downloadList) {
		this.downloadList = downloadList;
	}
	
	

}
