package com.mg.service.backend.parser;

import com.mg.service.backend.model.Memory;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CSVReader {

	public static List<Memory> parseMemoriesCSV(String csvFile) throws FileNotFoundException {
		List<Memory> memories = new CsvToBeanBuilder(new FileReader(csvFile))
				.withType(Memory.class).build().parse();
		return memories;
	}
}
