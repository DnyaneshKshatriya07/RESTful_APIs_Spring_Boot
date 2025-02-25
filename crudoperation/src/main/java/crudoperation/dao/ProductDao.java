package crudoperation.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import crudoperation.model.Product;

@Component
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	//Create
	@Transactional
	public void createProduct(Product product){
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	
	//Get all Products
	public List<Product> getProducts(){
		List<Product> items =this.hibernateTemplate.loadAll(Product.class);
		return items;
	}
	
	
	//Delete the single product
	@Transactional
	public void deleteProduct(int pid){
		Product p=this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(p);
	}
	
	
	//Get Single Products
	public Product getProduct(int pid){
		return this.hibernateTemplate.get(Product.class, pid);
	}
	
	// Update the product
	@Transactional
	public void updateProduct(Product product) {
	    this.hibernateTemplate.update(product);
	}

}
