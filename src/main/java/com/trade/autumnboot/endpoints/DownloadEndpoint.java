package com.trade.autumnboot.endpoints;

import java.io.File;
import java.io.FileNotFoundException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
public class DownloadEndpoint {
	
	private static final String FILE_PATH = "src/main/resources/data/";
	private static final String APPLICATION_JSON = "application/json";
	
	@RequestMapping(value = "/data/{fileName:.+}", method = RequestMethod.GET, produces = APPLICATION_JSON )
	public @ResponseBody Resource downloadFile(@PathVariable("fileName") String fileName, HttpServletResponse response) throws FileNotFoundException {
		File file = new File(FILE_PATH + fileName);
		response.setContentType("application/json");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		response.setHeader("Content-Length", String.valueOf(file.length()));
		return new FileSystemResource(file);	
	}
}
