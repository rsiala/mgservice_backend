package com.mg.service.backend.service;

import com.mg.service.backend.model.Memory;

import java.util.List;

public interface MemoryService {

	List<Memory> loadMemoriesFromFile(String fileName);
}
