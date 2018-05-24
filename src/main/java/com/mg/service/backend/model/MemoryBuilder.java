package com.mg.service.backend.model;

import java.util.Date;

public class MemoryBuilder {
	private Integer id;
	private Integer patientId;
	private Date inputDate;
	private Double amount;
	private Double account;
	private String paymentType;

	public MemoryBuilder setId(Integer id) {
		this.id = id;
		return this;
	}

	public MemoryBuilder setPatientId(Integer patientId) {
		this.patientId = patientId;
		return this;
	}

	public MemoryBuilder setInputDate(Date inputDate) {
		this.inputDate = inputDate;
		return this;
	}

	public MemoryBuilder setAmount(Double amount) {
		this.amount = amount;
		return this;
	}

	public MemoryBuilder setAccount(Double account) {
		this.account = account;
		return this;
	}

	public MemoryBuilder setPaymentType(String paymentType) {
		this.paymentType = paymentType;
		return this;
	}

	public Memory createMemory() {
		return new Memory(id, patientId, inputDate, amount, account, paymentType);
	}
}