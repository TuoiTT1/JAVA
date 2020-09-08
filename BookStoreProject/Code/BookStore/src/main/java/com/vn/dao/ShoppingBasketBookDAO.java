package com.vn.dao;

import java.util.List;

import com.vn.entitiy.ShoppingBasketBook;

public interface ShoppingBasketBookDAO {

	public Integer delete(int id);

	public ShoppingBasketBook create(ShoppingBasketBook shoppingBasketBook);

	public ShoppingBasketBook update(ShoppingBasketBook shoppingBasketBook);

	public List<ShoppingBasketBook> getAll();

	public ShoppingBasketBook findById(int id);

	public List<ShoppingBasketBook> findByUserName(String userName);

}
