package com.product;

import javax.ws.rs.core.Response;

import com.product.dao.ProductDAO;
import com.product.dto.Product;


public class ProductWSImpl implements ProductWS {
	
	private ProductDAO productDAO;

	@Override
	public Response add(Product productDto) {
		
		com.product.entity.Product productEntity = new com.product.entity.Product();
		
		productEntity.setId(productDto.getId());
		productEntity.setName(productDto.getName());
		productEntity.setDescription(productDto.getDescription());
		productEntity.setPrice(productDto.getPrice());
		
		productDAO.create(productEntity);
		
		return Response.ok().build();
	}

	@Override
	public Response update(Product productDto) {
		
		productDAO.update(productDto.getId(), productDto.getPrice());
		
		return Response.ok().build();
	}

	@Override
	public Response delete(int id) {
		
		productDAO.delete(id);
		
		return Response.ok().build();
	}

	@Override
	public Product find(int id) {
		
		com.product.entity.Product productEntity = productDAO.find(id);
		
		Product productDto = new Product();
		
		productDto.setId(productEntity.getId());
		productDto.setName(productEntity.getName());
		productDto.setDescription(productEntity.getDescription());
		productDto.setPrice(productEntity.getPrice());
		

		
		return productDto;
		
		
	}

}
