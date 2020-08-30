package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class Warehouse implements Serializable {

	private static final long serialVersionUID = -3722250485822499822L;

	private Integer ID;
	private String WarehouseName;
	private String WarehousePhone;
	private String WarehouseAddress;

	public Warehouse() {
	}

	public Warehouse(Integer iD, String warehouseName, String warehousePhone, String warehouseAddress) {
		super();
		ID = iD;
		WarehouseName = warehouseName;
		WarehousePhone = warehousePhone;
		WarehouseAddress = warehouseAddress;
	}

}
