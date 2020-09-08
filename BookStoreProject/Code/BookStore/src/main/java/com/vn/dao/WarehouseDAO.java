package com.vn.dao;

import java.util.List;

import com.vn.entitiy.Warehouse;

public interface WarehouseDAO {

	public Integer delete(int id);

	public Warehouse create(Warehouse warehouse);

	public Warehouse update(Warehouse warehouse);

	public List<Warehouse> getAll();

	public Warehouse findById(int id);
}
