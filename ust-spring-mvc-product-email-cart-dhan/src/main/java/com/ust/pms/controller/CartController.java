package com.ust.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ust.pms.model.Cart;
import com.ust.pms.model.Product;
import com.ust.pms.service.CartService;
import com.ust.pms.service.ProductService;
 

@Controller
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	ProductService productService;

	@Autowired
	private JavaMailSender mailSender;

	SimpleMailMessage msg = new SimpleMailMessage();

	@RequestMapping("/saveCart/{productId}")
	public String saveCart(@PathVariable("productId") int productId, Model model) {

		model.addAttribute("username", UserUtil.getUserName());
	

		ModelAndView mav = new ModelAndView();
		mav.setViewName("productList");

		List<Cart> cartList1 = cartService.getCartDetails();


		if (cartList1.size() < 10) {
			Product product = productService.getProduct(productId);
			Cart cart = new Cart(productId, null, productId, productId);
			cart.setProductId(product.getProductId());
			cart.setProductName(product.getProductName());
			cart.setPrice(product.getPrice());
			cart.setQuantityOnHand(product.getQuantityOnHand());

			cartService.saveCart(cart);

			msg.setFrom("dhananjoykr000@gmail.com");
			msg.setTo("dhannukr12@gmail.com");
			msg.setSubject("One Product hasbeen added to your Cart ");
			msg.setText("Product : " + cart.getProductName() + "Price :" + cart.getPrice()
					+ "  has been added to your Cart");
			mailSender.send(msg);

		}else {
			model.addAttribute("moreproducts","exceed more than 10 products in cart page");
		}
		
		return  "cartsuccess";
		//return "redirect:/productList";
	}

	@RequestMapping("/cartList")
	public ModelAndView checkProductList(Model model, Product products) {

		model.addAttribute("username", UserUtil.getUserName());
		model.addAttribute("command", products);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("cart");

	
		List<Cart> cartList = cartService.getCartDetails();
		mav.addObject("cartList", cartList);

		return mav;

	}

	@RequestMapping("/deleteCart/{productId}")
	public String deleteCart(@PathVariable("productId") int productId, Model model) {

		Cart cart = cartService.getCart(productId);

		Product product = new Product();
		product.setProductId(cart.getProductId());
		product.setProductName(cart.getProductName());
		product.setQuantityOnHand(cart.getQuantityOnHand());
		product.setPrice(cart.getPrice());
		productService.saveProduct(product);

		cartService.deleteCart(cart);

		return "redirect:/cartList";
	}

	
	
}