package com.trade.autumnboot.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.trade.autumnboot.dto.MockData;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class FileUtilsTest {
	
	

	@Autowired
	FileUtils fileUtils;
	
	@Test
	public void test_StoreMockDataFile() {
		List<MockData> mockDataList= new ArrayList<>();
		MockData data = new MockData();
		data.setOnDate(LocalDate.now());
		mockDataList.add(data);
		String fileName = fileUtils.store("AAPL", "START-DATE", "END-DATE", "GENERATOR-TYPE", mockDataList, false);
		assertThat(fileName).isEqualTo("src/main/resources/data/"+"AAPL_START-DATE_END-DATE_GENERATOR-TYPE.json");
	}
	
	@Test
	public void test_retrieveDataFile() {
		List<String> files = fileUtils.list();
		assertThat(files).isNotNull();
		assertThat(files.size()).isGreaterThan(0);
		}
	public void test_DeleteFile() {
		
		List<MockData> mockDataList= new ArrayList<>();
		MockData data = new MockData();
		data.setOnDate(LocalDate.now());
		mockDataList.add(data);
		String fileName = fileUtils.store("AAPL", "START-DATE", "END-DATE", "GENERATOR-TYPE", mockDataList, false);
		assertThat(fileName).isEqualTo("src/main/resources/data/"+"AAPL_START-DATE_END-DATE_GENERATOR-TYPE.json");
		
		fileName = "AAPL_START-DATE_END-DATE_GENERATOR-TYPE.json";
		String status = fileUtils.delete(fileName);
		assertThat(status).isEqualTo("DELETED");
	}
	
	@Test
	public void test_DeleteFileNotFound() {
		
		String fileName = "NonExistingFile.json";
		String status = fileUtils.delete(fileName);
		assertThat(status).isEqualTo("FILE NOT FOUND");
	}

}
