package com.mg.service.backend.writer;

import com.google.common.collect.Lists;
import com.mg.service.backend.model.Memory;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

public class CSVWriter {

	public static String generateHVENFile(List<Memory> memories, String codeJournal) throws IOException {
		final String[] csvOutput = {""};
		memories.forEach(m -> {
			csvOutput[0] = csvOutput[0].concat(m.getHVENInfo(codeJournal)).concat("\r\n");
		});
		Path file = Paths.get("HVEN.txt");
		Files.write(file, Lists.newArrayList(csvOutput[0]), Charset.forName("ISO-8859-1"));
		return csvOutput[0];	}

	public static String generateLVENFile(List<Memory> memories, String codeJournal, String codeVente) throws IOException {
		final String[] csvOutput = {""};
		memories.forEach(m -> {
			csvOutput[0] = csvOutput[0].concat(m.getLVENInfo(codeJournal, codeVente)).concat("\r\n");
		});
		Path file = Paths.get("LVEN.txt");
		Files.write(file, Lists.newArrayList(csvOutput[0]), Charset.forName("ISO-8859-1"));
		return csvOutput[0];
	}

	public static String generateClientInfoFile(List<Memory> memories) throws IOException {
		final String[] csvOutput = {""};
		memories.forEach(m -> {
			csvOutput[0] = csvOutput[0].concat(m.getClientInfo()).concat("\r\n");
		});
		Path file = Paths.get("client.txt");
		Files.write(file, Lists.newArrayList(csvOutput[0]), Charset.forName("ASCII"));
		return csvOutput[0];
	}

	public static String formatDouble (Double d){
		DecimalFormat df = new DecimalFormat("0.00");
		DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance();
		sym.setDecimalSeparator(',');
		df.setDecimalFormatSymbols(sym);
		String format = df.format(d.doubleValue());
		return format;
	}
}
