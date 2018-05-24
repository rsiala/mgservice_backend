package com.mg.service.backend.writer;

import com.mg.service.backend.model.Memory;
import com.mg.service.backend.model.MemoryBuilder;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Date;

public class CSVWriterTest {

	@Test
	public void testGenerateHVENFile() throws Exception {
	}

	@Test
	public void testGenerateLVENFile() throws Exception {
		Memory memory = new MemoryBuilder()
				.setPatientId(75000)
				.setInputDate(new Date())
				.setAmount(56.80D)
				.setId(33444)
				.createMemory();
		String generatedClientInfoFile = CSVWriter.generateLVENFile(Lists.newArrayList(memory), "VTN", "70600000");
		System.out.println(generatedClientInfoFile);
	}

	@Test
	public void testGenerateClientInfoFile() throws Exception {
		Memory memory = new MemoryBuilder()
				.setPatientId(75000)
				.createMemory();
		String generatedClientInfoFile = CSVWriter.generateClientInfoFile(Lists.newArrayList(memory));
		System.out.println(generatedClientInfoFile);
	}
}