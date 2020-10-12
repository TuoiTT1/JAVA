package com.vn.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The persistent class for the employee database table.
 * 
 */
@Setter
@Getter
@Entity
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String position;

	// bi-directional one-to-one association to Account
	@OneToOne
	@JoinColumn(name = "Account_Email", referencedColumnName = "Email")
	private Account account;

	// bi-directional many-to-one association to Bill
	@OneToMany(mappedBy = "employee")
	private List<Bill> bills;

	// bi-directional many-to-one association to Sale
	@OneToMany(mappedBy = "employee")
	private List<Sale> sales;

	// bi-directional many-to-one association to Store
	@OneToMany(mappedBy = "employee")
	private List<Store> stores;

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setEmployee(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setEmployee(null);

		return bill;
	}

	public Sale addSale(Sale sale) {
		getSales().add(sale);
		sale.setEmployee(this);

		return sale;
	}

	public Sale removeSale(Sale sale) {
		getSales().remove(sale);
		sale.setEmployee(null);

		return sale;
	}

	public Store addStore(Store store) {
		getStores().add(store);
		store.setEmployee(this);

		return store;
	}

	public Store removeStore(Store store) {
		getStores().remove(store);
		store.setEmployee(null);

		return store;
	}

}