package com.ust.pms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ust.pms.model.Cart;
import com.ust.pms.repository.CartRepository;

@SpringBootTest
class CartServiceTest {
	
	@Autowired
	private CartRepository cartRepository;
	private Cart cart = new Cart();
	
	@Autowired
	private CartService cartService;
	

	@BeforeEach
	public void setUp() throws Exception {
				
		cart.setProductId(101);
		cart.setProductName("laptop");		
		cart.setPrice(1000);
		cart.setQuantityOnHand(2);
		//cart.setCartProductPriceTotal(cart.getCartProductPrice()*cart.getCartProductQuantity());

		}
	
	@Test
	public void testGetCarts() {
		List<Cart> cartItem = (List<Cart>) cartService.getCartDetails();
		int cartItemId = cartItem.get(0).getProductId();
		Cart rtvCart = (Cart) cartService.getCart(cartItemId);
		assertEquals(cartItemId, rtvCart.getProductId());
	}

	@Test
	public void testGetCart() {
		List<Cart> cartItem = (List<Cart>) cartService.getCartDetails();
		//List<Cart> productList = (List<Cart>) cartRepository.findAll();
		assertTrue(cartItem.size()>0);
	}

	@Test
	public void testUpdateProductCart() {
		Cart cart = new Cart();		
		
		cart.setProductId(10);
		cart.setProductName("mask");		
		cart.setPrice(5);
		cart.setQuantityOnHand(5);
		//cart.setCartProductPriceTotal(cart.getCartProductPrice()*cart.getCartProductQuantity());
		
		//cartService.saveProductToCart(cart);
		
		cart.setQuantityOnHand(10);
		//cart.setCartProductPriceTotal(cart.getCartProductPrice()*cart.getCartProductQuantity());
		
		cartService.updateCart(cart);
		
		int cartItemId = cart.getProductId();
		
		Cart cartItem = cartRepository.findById(cart.getProductId()).get();
		assertEquals(10, cartItem.getQuantityOnHand());
		
		//cartService.deleteProductFromCart(cartItemId);
		
	}
}