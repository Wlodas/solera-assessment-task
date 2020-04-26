package com.solera

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private class SaleOfferCreatorTest {
	@Test
	fun `should create a sale offer`() {
		// given
		val shoppingCart = ShoppingCart()
		shoppingCart += Product.APPLE
		shoppingCart.addProduct(Product.ORANGE)
		shoppingCart.addProduct(Product.BANANA, amount = 2)
		
		// when
		val saleOffer = SaleOfferCreator.createFromShoppingCart(shoppingCart)
		
		// then
		assertThat(saleOffer).isEqualTo(SaleOffer(
			entries = listOf(
				SaleOffer.Entry(product = Product.APPLE, amount = 1, value = Product.APPLE.price),
				SaleOffer.Entry(product = Product.ORANGE, amount = 1, value = Product.ORANGE.price),
				SaleOffer.Entry(product = Product.BANANA, amount = 2, value = Product.BANANA.price * 2)
			)
		))
	}
	
	@Test
	fun `should apply 'three for the price of two' rule for papaya fruits`() {
		// given
		val shoppingCart = ShoppingCart()
		shoppingCart.addProduct(product = Product.PAPAYA, amount = 7)
		
		// when
		val saleOffer = SaleOfferCreator.createFromShoppingCart(shoppingCart)
		
		// then
		assertThat(saleOffer).isEqualTo(SaleOffer(
			entries = listOf(
				SaleOffer.Entry(product = Product.PAPAYA, amount = 7, value = Product.PAPAYA.price * 5)
			)
		))
	}
}