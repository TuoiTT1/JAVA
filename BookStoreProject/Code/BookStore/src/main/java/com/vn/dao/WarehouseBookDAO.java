package com.vn.dao;

import java.util.List;

import com.vn.entitiy.WarehouseBook;

public interface WarehouseBookDAO {

	public Integer delete(int id);

	public WarehouseBook create(WarehouseBook warehouseBook);

	public WarehouseBook update(WarehouseBook warehouseBook);

	public List<WarehouseBook> getAll();

	public WarehouseBook findById(int id);
}
