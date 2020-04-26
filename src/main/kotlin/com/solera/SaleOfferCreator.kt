package com.solera

object SaleOfferCreator {
	fun createFromShoppingCart(shoppingCart: ShoppingCart): SaleOffer = SaleOffer(
		entries = shoppingCart.map { (product, amount) ->
			SaleOffer.Entry(
				product = product,
				amount = amount,
				value = calculateProductsValue(product, amount)
			)
		}
	)
	
	private fun calculateProductsValue(product: Product, amount: Int) = when (product) {
		Product.PAPAYA -> product.price * (amount - amount / 3) // 'three for the price of two' rule
		else -> product.price * amount
	}
}