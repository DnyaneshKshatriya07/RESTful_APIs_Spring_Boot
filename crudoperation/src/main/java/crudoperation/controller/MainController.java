package crudoperation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import crudoperation.dao.ProductDao;
import crudoperation.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home(Model model) {
		List<Product> items = productDao.getProducts();
		model.addAttribute("product", items);
		return "index";
	}

	@RequestMapping("/add-product")
	public String addProduct(Model model) {
		model.addAttribute("title", "Add Product");
		return "add_product_form";
	}

	// handle the product
	@RequestMapping(value = "handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

	// handle for delete product
	@RequestMapping(value = "/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
		this.productDao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

	// handle for update product
	@RequestMapping(value = "/update/{productId}")
	public String updateProduct(@PathVariable("productId") int pid, Model model) {
		Product product=this.productDao.getProduct(pid);
		model.addAttribute("product",product);
		return "update_form";
	}
	
	// Handle update product form submission
	@RequestMapping(value = "/update-product", method = RequestMethod.POST)
	public RedirectView updateProduct(@ModelAttribute Product product, HttpServletRequest request) {
	    productDao.updateProduct(product);
	    RedirectView redirectView = new RedirectView();
	    redirectView.setUrl(request.getContextPath() + "/");
	    return redirectView;
	}

}
