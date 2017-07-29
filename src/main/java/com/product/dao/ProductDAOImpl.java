package com.product.dao;

import com.product.dao.mappers.ProductRowMapper;
import com.product.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProductDAOImpl implements ProductDAO {
	
	private JdbcTemplate jdbcTemplate;  

	public void create(Product product) {
		
		jdbcTemplate.update("insert into product value("+product.getId()+",'"+product.getName()+"','"+product.getDescription()+"',"+product.getPrice()+")");
		
	}

	public void update(int id, int price) {
		
		jdbcTemplate.update("update product set price = "+price+" where id ="+id);
		
	}

	public void delete(int id) {
		jdbcTemplate.update("delete from product where id ="+id);
		
	}

	public Product find(int id) {
		
		Product product = jdbcTemplate.queryForObject("select * from product where id="+id, new ProductRowMapper());
		
		return product;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
