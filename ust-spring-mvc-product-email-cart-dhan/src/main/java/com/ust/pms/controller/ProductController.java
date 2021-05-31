package com.ust.pms.controller;


import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ust.pms.model.Cart;
import com.ust.pms.model.Product;
import com.ust.pms.service.CartService;
import com.ust.pms.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;	
	@Autowired
	CartService cartService;
	
	
	//List<Product> cartProducts = new ArrayList<Product>();
	@RequestMapping("/addProduct")
	public ModelAndView addProduct() {
		return new ModelAndView("addProduct", "command", new Product());
	}

	/*
	 * @RequestMapping("/saveProduct") public String saveProduct(Product product) {
	 * productService.saveProduct(product); return "success"; }
	 */
	
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@Validated @ModelAttribute("command")Product product, Model model,BindingResult result) {
		System.out.println("******************** errors::::::"+result.getErrorCount());

		if(result.hasErrors()) {
			model.addAttribute("command",new Product());
			return "success";
		}else {
		if(productService.isProductExist(product.getProductId()) || cartService.isCartExist(product.getProductId())) {
			model.addAttribute("command",new Product());
			model.addAttribute("alreadyExistProduct","Product Id already available , Please give another Product Id");
			return "success";
		}else {
		
		productService.saveProduct(product);
		return "redirect:viewAllProducts";
		}
		}
	}
	
	
	@RequestMapping(value = "/editProduct/{productId}", method = RequestMethod.GET)
	public String editProduct(@PathVariable("productId") int productId, Model model) {
		Product product = productService.getProduct(productId);
		model.addAttribute("product", product);

		return "updateProduct";
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") Product product, Model model) {

		productService.updateProduct(product);
		return "redirect:viewAllProducts";
	}

	@RequestMapping(value = "/deleteProduct/{productId}", method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable("productId") int productId, Model model) {
		Product product = productService.getProduct(productId);

		productService.deleteProduct(product);
		
		if (cartService.isCartExist(productId)) 
		cartService.deleteCart(cartService.getCart(productId));

		return "redirect:/viewAllProducts";
	}

	
	@RequestMapping("/searchProductByIdForm")
	public ModelAndView searchProductByIdForm() {
		return new ModelAndView("searchProductByIdForm", "command", new Product());
	}

	@RequestMapping("/searchProductById")
	public ModelAndView searchProductById(Product product) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchProductByIdForm");
		int pId = product.getProductId();
		if (productService.isProductExist(pId)) {
			Product productDetails = productService.getProduct(pId);
			modelAndView.addObject("command", productDetails);
		} else {
			modelAndView.addObject("command", new Product());
			modelAndView.addObject("msg", "Product with product id :" + pId + "does not exists");
		}
		return modelAndView;
	}

	// delete functionality in spring boot mvc
	@RequestMapping("/deleteProductById")
	public ModelAndView deleteProductById(Product product) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchProductByIdForm");
		modelAndView.addObject("command", new Product());
		int pId = product.getProductId();
		if (productService.isProductExist(pId)) {
			productService.deleteProductById(pId);
			modelAndView.addObject("msg", "Product with product id :" + pId + "deleted successfully");
		} else {
			modelAndView.addObject("msg", "Product with product id :" + pId + "does not exists");
		}
		return modelAndView;
	}

	// Fetch all the products
	@RequestMapping("/viewAllProducts")
	public ModelAndView viewAllProducts() {
		List<Product> products = productService.getProductDetails();
		return new ModelAndView("viewAllProducts", "products", products);
		
	}
	
	@RequestMapping("/cart/{productId}")
	public ModelAndView cartProduct(@PathVariable("productId")String productId) {
		// command
		//code to fetch all the details of this product
		// add this product to cart table
		//update product - minus 1 quantity of this productid
		ModelAndView view = new ModelAndView();
		view.addObject("productId",productId);
		return new ModelAndView("cart", "command", new Product());
	}
	
	
	@RequestMapping("/delete/{productId}")
	public ModelAndView deleteProduct(@PathVariable("productId")String productId) {
		
		Integer pId = new Integer(productId);
		productService.deleteProductById(pId);
		ModelAndView view = new ModelAndView();
		view.addObject("productId",productId);
		
		return new ModelAndView("redirect:/viewAllProducts");
	}
	
	/*
	 * // Fetch all Cart products by User
	 * 
	 * @RequestMapping(value = "/{productId}")
	 * 
	 * @ResponseBody public ModelAndView cart(@PathVariable("productId") int
	 * productId) { // Fetching Username
	 * System.out.println("hello dhan11111111111111 "); String username = null;
	 * Object principal =
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); if
	 * (principal instanceof UserDetails) { username = ((UserDetails)
	 * principal).getUsername(); } Product productDetails =
	 * productService.getProduct(productId);
	 * 
	 * 
	 * Cart cart = new Cart(productDetails.getProductId(),
	 * productDetails.getProductName(), productDetails.getQuantityOnHand(),
	 * productDetails.getPrice(), productDetails.getQuantityOnHand() *
	 * productDetails.getPrice(), username); cartService.saveCart(cart);
	 * 
	 * List<Product> products = productService.getProducts(); return new
	 * ModelAndView("viewAllProducts", "command", products); }
	 * 
	 * // Cart By User
	 * 
	 * @RequestMapping("/cart") public ModelAndView cart() { String username = null;
	 * Object principal =
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); if
	 * (principal instanceof UserDetails) { username = ((UserDetails)
	 * principal).getUsername(); } List<Cart> cart = cartService.getCarts(username);
	 * return new ModelAndView("cart", "command", cart); }
	 * 
	 * 
	 * // Deleting Cart products by User
	 * 
	 * @RequestMapping(value = "/deleteFromCart/{productId}") //@ResponseBody public
	 * ModelAndView deleteFromCart(@PathVariable("productId") int productId) {
	 * System.out.println("cartProductId ::" + productId);
	 * cartService.deleteFromCartProduct(productId); String username = null; Object
	 * principal =
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); if
	 * (principal instanceof UserDetails) { username = ((UserDetails)
	 * principal).getUsername(); } List<Cart> cart = cartService.getCarts(username);
	 * return new ModelAndView("cart", "cart", cart);
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "updateCart/{productId}") public String
	 * updateCart(@PathVariable("productId") int productId) { return "updateCart";
	 * 
	 * }
	 */
		
}
