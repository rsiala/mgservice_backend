package com.mg.service.backend.service.impl;

import com.mg.service.backend.model.Memory;
import com.mg.service.backend.parser.CSVReader;
import com.mg.service.backend.service.MemoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

public class MemoryServiceImpl implements MemoryService {

	private final static Logger logger = LoggerFactory.getLogger(MemoryServiceImpl.class);

	@Override
	public List<Memory> loadMemoriesFromFile(String filePath) {
		try {
			return CSVReader.parseMemoriesCSV(filePath);
		} catch (FileNotFoundException e) {
			logger.error("File not found in path "+filePath, e);
		}
		return Collections.emptyList();
	}

}
