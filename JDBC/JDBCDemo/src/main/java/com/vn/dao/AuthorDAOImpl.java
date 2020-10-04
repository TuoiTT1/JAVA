package com.vn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vn.entity.Author;

public class AuthorDAOImpl implements AuthorDAO {

	private Connection connection;
	private PreparedStatement prStatement;
	private Statement statement;
	private ResultSet rs;

	public AuthorDAOImpl(Connection cnn) {
		this.connection = cnn;
	}

	@Override
	public int delete(int id) {
		try {
			// PrepareStatement
			String sql = "delete from author where ID = ?";
			prStatement = connection.prepareStatement(sql);
			prStatement.setInt(1, id);

			int count = prStatement.executeUpdate();
			return count;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				prStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	@Override
	public int create(Author author) {
		try {
			// PrepareStatement
			String sql = "insert into author set AuthorName = ?, AuthorAddress = ?";
			prStatement = connection.prepareStatement(sql);
			prStatement.setString(1, author.getAuthorName());
			prStatement.setString(2, author.getAuthorAddress());

			int count = prStatement.executeUpdate();
			return count;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				prStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	@Override
	public int update(Author author) {
		try {
			// PrepareStatement
			String sql = "update author set AuthorName = ?, AuthorAddress = ? where ID = ?";
			prStatement = connection.prepareStatement(sql);
			prStatement.setString(1, author.getAuthorName());
			prStatement.setString(2, author.getAuthorAddress());
			prStatement.setInt(3, author.getId());

			int count = prStatement.executeUpdate();
			return count;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				prStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	@Override
	public List<Author> getll() {
		List<Author> list = new ArrayList<Author>();
		try {
			Author author;
			statement = connection.createStatement();
			statement.execute("Select ID as id, AuthorName as name, AuthorAddress as address from author");

			rs = statement.getResultSet();

			while (rs.next()) {
				author = new Author();
				author.setId(rs.getInt("id"));
				author.setAuthorName(rs.getString("name"));
				author.setAuthorAddress(rs.getString("address"));

				list.add(author);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Author findById(int id) {
		try {
			Author author;
			statement = connection.createStatement();
			statement.execute("Select ID as id, AuthorName as name, AuthorAddress as address " + "from author"
					+ " where ID = " + id);

			rs = statement.getResultSet();

			while (rs.next()) {
				author = new Author();
				author.setId(rs.getInt("id"));
				author.setAuthorName(rs.getString("name"));
				author.setAuthorAddress(rs.getString("address"));

				return author;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
}
