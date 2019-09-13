package com.trade.autumnboot.endpoints;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trade.autumnboot.dto.MockData;
import com.trade.autumnboot.dto.MockDataRequest;
import com.trade.autumnboot.generator.MockGenerator;
import com.trade.autumnboot.generator.MockGeneratorFactory;
import com.trade.autumnboot.utils.FileUtils;

@RestController
@RequestMapping("/mockdata")
public class MockDataEndpoint {

	@Autowired
	FileUtils fileUtils;
	@Autowired
	MockGeneratorFactory mockGeneratorFactory;
	
	public static HashMap<String, String> mockGeneratorMetaData = new HashMap<String, String>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
        put("Function1", "This is a linear mock data generator");
        put("Function2", "This is a harmonic mock data generator");
        put("Function3", "This is a complex mock data generator");

    }}; 
	
	private Logger logger = LoggerFactory.getLogger(MockDataEndpoint.class);


	@PostMapping
	public List<MockData> createMockData(@Valid @RequestBody MockDataRequest mockDataRequest) {
		MockGenerator mockGenerator = mockGeneratorFactory.creatMockGenerator(mockDataRequest.getGeneratorType());
		List<MockData> mockdata = mockGenerator.generate(mockDataRequest.getStartDate(), mockDataRequest.getNumOfDays(),
				mockDataRequest.getTicker());
		// TODO
		// Call the FileUtils and store
		String mockFileStoreName = fileUtils.store(mockDataRequest.getTicker(),
				mockDataRequest.getStartDate().toString(), mockDataRequest.getStartDate().plusDays(mockDataRequest.getNumOfDays()).toString(),
				mockDataRequest.getGeneratorType(), mockdata, true);
		logger.info("-- wrote mockdata to "+mockFileStoreName);
		return mockdata;
	}

	@GetMapping(path = "/generator/meta")
	public HashMap<String, String> getMockGeneratorMetaData(){
		return mockGeneratorMetaData;
	}

}
