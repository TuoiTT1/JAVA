package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class Warehouse implements Serializable {

	private static final long serialVersionUID = -3722250485822499822L;

	private Integer id;
	private String warehouseName;
	private String warehousePhone;
	private String warehouseAddress;

}
