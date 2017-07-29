package com.product.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.product.entity.Product;

public class ProductRowMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int rownum) throws SQLException {
		
		Product product = new Product();
		
		product.setId(rs.getInt(1));
		product.setName(rs.getString(2));
		product.setDescription(rs.getString(3));
		product.setPrice(rs.getInt(4));	
		
		return product;
	}


}
