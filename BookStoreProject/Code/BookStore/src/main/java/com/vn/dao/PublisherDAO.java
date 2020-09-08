package com.vn.dao;

import java.util.List;

import com.vn.entitiy.Publisher;

public interface PublisherDAO {

	public Integer delete(int id);

	public Publisher create(Publisher publisher);

	public Publisher update(Publisher publisher);

	public List<Publisher> getAll();

	public Publisher findById(int id);

}
