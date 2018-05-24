package com.mg.service.backend.parser;

import com.mg.service.backend.model.Memory;
import org.testng.annotations.Test;

import java.util.List;

public class CSVReaderTest {

	private static final String CSV_FILE = "/Users/damak/Documents/doc_rayen/mgservice/project/mgservice-project/mgservice_backend/src/test/resources/MEMOIRES2018T.txt";


	@Test
	public void testParseMemoriesCSV() throws Exception {
		List<Memory> memories = CSVReader.parseMemoriesCSV(CSV_FILE);
		System.out.println(memories);
	}
}