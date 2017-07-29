package com.product;

import javax.ws.rs.core.Response;

import com.product.dao.ProductDAO;
import com.product.dto.Product;


public class ProductWSImpl implements ProductWS {
	
	private ProductDAO productdao;

	@Override
	public Response add(Product productDto, ProductDAO productDAO) {
		
		com.product.entity.Product productEntity = new com.product.entity.Product();
		
		productEntity.setId(productDto.getId());
		productEntity.setName(productDto.getName());
		productEntity.setDescription(productDto.getDescription());
		productEntity.setPrice(productDto.getPrice());
		
		productdao.create(productEntity);
		
		return Response.ok().build();
	}

	@Override
	public Response update(Product productDto) {
		
		productdao.update(productDto.getId(), productDto.getPrice());
		
		return Response.ok().build();
	}

	@Override
	public Response delete(int id) {
		
		productdao.delete(id);
		
		return Response.ok().build();
	}

	@Override
	public Product find(int id) {
		
		com.product.entity.Product productEntity = productdao.find(id);
		
		Product productDto = new Product();
		
		productDto.setId(productEntity.getId());
		productDto.setName(productEntity.getName());
		productDto.setDescription(productEntity.getDescription());
		productDto.setPrice(productEntity.getPrice());
		

		
		return productDto;
		
		
	}

	public ProductDAO getProductdao() {
		return productdao;
	}

	public void setProductdao(ProductDAO productdao) {
		this.productdao = productdao;
	}

}
