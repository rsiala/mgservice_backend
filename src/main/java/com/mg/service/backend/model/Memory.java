package com.mg.service.backend.model;

import com.mg.service.backend.writer.CSVWriter;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class Memory {

	@CsvBindByPosition(position = 0)
	private Integer id;

	@CsvBindByPosition(position = 1)
	private Integer patientId;

	@CsvBindByPosition(position = 2)
	@CsvDate("yyyyMMdd")
	private Date inputDate;

	@CsvBindByPosition(position = 3)
	private Double amount;

	@CsvBindByPosition(position = 4)
	private Double account;

	@CsvBindByPosition(position = 5)
	private String paymentType;

	public Memory() {
	}

	public Memory(Integer id, Integer patientId, Date inputDate, Double amount, Double account, String paymentType) {
		this.id = id;
		this.patientId = patientId;
		this.inputDate = inputDate;
		this.amount = amount;
		this.account = account;
		this.paymentType = paymentType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getAccount() {
		return account;
	}

	public void setAccount(Double account) {
		this.account = account;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "Memory{" +
				"id=" + id +
				", patientId=" + patientId +
				", inputDate=" + inputDate +
				", amount=" + amount +
				", account=" + account +
				", paymentType='" + paymentType + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Memory)) return false;
		Memory memory = (Memory) o;
		return Objects.equals(id, memory.id) &&
				Objects.equals(patientId, memory.patientId) &&
				Objects.equals(inputDate, memory.inputDate) &&
				Objects.equals(amount, memory.amount) &&
				Objects.equals(account, memory.account) &&
				Objects.equals(paymentType, memory.paymentType);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, patientId, inputDate, amount, account, paymentType);
	}

	public String getClientInfo() {
		return "CL" + String.format("%06d", patientId) + ";C;U;;;;;;;";
	}

	public String getLVENInfo(String codeJournal, String codeVente) {
		LocalDate localDate = this.inputDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return codeJournal
				.concat(";")
				.concat("" + localDate.getYear())
				.concat(";")
				.concat("" + localDate.getYear())
				.concat(";")
				.concat("" + String.format("%02d", localDate.getMonthValue()))
				.concat(";")
				.concat(this.id.toString())
				.concat(";")
				.concat("1")
				.concat(";")
				.concat("S")
				.concat(";")
				.concat("1")
				.concat(";")
				.concat(codeVente)
				.concat(";")
				.concat(";")
				.concat(";")
				.concat(CSVWriter.formatDouble(this.amount == null ? 0.00D : this.amount))
				.concat(";")
				.concat(";")
				.concat(CSVWriter.formatDouble(this.amount == null ? 0.00D : this.amount))
				.concat(";")
				.concat(";")
				.concat(CSVWriter.formatDouble(this.account == null ? 0.00D : this.account))
				.concat(";")
				.concat(";")
				.concat(CSVWriter.formatDouble(this.account == null ? 0.00D : this.account))
				.concat(";")
				.concat(";")
				.concat(";")
				.concat("0")
				.concat(";")
				.concat(";")
				.concat("C")
				.concat(";")
				.concat("C")
				.concat(";")
				.concat("Mémoire Honoraire n°")
				.concat(this.id.toString())
				.concat(";");
	}

	public String getHVENInfo(String codeJournal) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		LocalDate localDate = this.inputDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return codeJournal
				.concat(";")
				.concat("" + localDate.getYear())
				.concat(";")
				.concat("" + localDate.getYear())
				.concat(";")
				.concat("" + String.format("%02d", localDate.getMonthValue()))
				.concat(";")
				.concat(this.id.toString())
				.concat(";")
				.concat(df.format(inputDate))
				.concat(";")
				.concat("C")
				.concat(";")
				.concat("CL" + String.format("%06d", patientId))
				.concat(";")
				.concat(df.format(inputDate))
				.concat(";;0;0;0;;;;;")
				.concat(CSVWriter.formatDouble(this.amount == null ? 0.00D : this.amount))
				.concat(";")
				.concat("Mémoire Honoraire n° ")
				.concat(this.id.toString())
				.concat(";")
				.concat("Mémoire Honoraire n° ")
				.concat(this.id.toString())
				.concat(";;S;F");
	}
}
