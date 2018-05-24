package com.mg.service.backend;

import com.mg.service.backend.model.Memory;
import com.mg.service.backend.service.MemoryService;
import com.mg.service.backend.service.impl.MemoryServiceImpl;
import com.mg.service.backend.writer.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class GenerateFilesMain {

	private final static Logger logger = LoggerFactory.getLogger(GenerateFilesMain.class);


	public static Properties loadProperties() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			String confFile = System.getProperty("conf.file");
			File file = new File(confFile);
			input = new FileInputStream(file);

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			logger.info(prop.getProperty("source.file"));
			logger.info(prop.getProperty("code.journal"));
			logger.info(prop.getProperty("code.vente"));

		} catch (IOException ex) {
			logger.error("Error when reasing conf file", ex);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error("Error when closing conf file", e);
				}
			}
		}
		return prop;
	}

	public static void main(String... args) {
		try {
			Properties properties = loadProperties();
			MemoryService memoryService = new MemoryServiceImpl();
			List<Memory> memories = memoryService.loadMemoriesFromFile(properties.getProperty("source.file"));
			String client = CSVWriter.generateClientInfoFile(memories);
			String lven = CSVWriter.generateLVENFile(memories, properties.getProperty("code.journal"), properties.getProperty("code.vente"));
			String hven = CSVWriter.generateHVENFile(memories, properties.getProperty("code.journal"));
		} catch (IOException e) {
			logger.error("Error when generating files",e);
		}
	}
}
