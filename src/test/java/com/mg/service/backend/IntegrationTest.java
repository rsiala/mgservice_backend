package com.mg.service.backend;

import com.mg.service.backend.model.Memory;
import com.mg.service.backend.service.MemoryService;
import com.mg.service.backend.service.impl.MemoryServiceImpl;
import com.mg.service.backend.writer.CSVWriter;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class IntegrationTest {

	private static final String CSV_FILE = "/Users/damak/Documents/doc_rayen/mgservice/project/mgservice-project/mgservice_backend/src/test/resources/MEMOIRES2018T.txt";

	private static String CLIENT;

	private static String LVEN;

	private static String HVEN;


	static {
		try {
			CLIENT = FileUtils.readFileToString(new File("/Users/damak/Documents/doc_rayen/mgservice/project/mgservice-project/mgservice_backend/src/test/resources/client.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static {
		try {
			HVEN = FileUtils.readFileToString(new File("/Users/damak/Documents/doc_rayen/mgservice/project/mgservice-project/mgservice_backend/src/test/resources/HVEN.txt"),"ISO-8859-1");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static {
		try {
			LVEN = FileUtils.readFileToString(new File("/Users/damak/Documents/doc_rayen/mgservice/project/mgservice-project/mgservice_backend/src/test/resources/LVEN.txt"),"ISO-8859-1");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void generateAllFiles() throws IOException {
		MemoryService memoryService = new MemoryServiceImpl();
		List<Memory> memories = memoryService.loadMemoriesFromFile(CSV_FILE);
		String client = CSVWriter.generateClientInfoFile(memories);
		String lven = CSVWriter.generateLVENFile(memories, "VTN", "70600000");
		String hven = CSVWriter.generateHVENFile(memories, "VTN");
		Assert.assertEquals(client, CLIENT);
		Assert.assertEquals(lven, LVEN);
		Assert.assertEquals(hven, HVEN);
	}

}
