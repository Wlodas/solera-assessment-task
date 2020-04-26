package com.solera

import com.github.freva.asciitable.AsciiTable
import com.github.freva.asciitable.Column
import com.github.freva.asciitable.HorizontalAlign

fun main(args: Array<String>) {
	val shoppingCart = ShoppingCart()
	
	if (args.isNotEmpty()) {
		args.first().splitToSequence(',')
			.map { Product.valueOf(it.toUpperCase()) }
			.forEach { shoppingCart += it }
	}
	
	val saleOffer = SaleOfferCreator.createFromShoppingCart(shoppingCart)
	
	fun formatCurrencyValue(value: Int) = "$value ct."
	
	println(AsciiTable.getTable(
		AsciiTable.BASIC_ASCII_NO_DATA_SEPARATORS,
		saleOffer.entries,
		listOf(
			Column()
				.header("Product")
				.dataAlign(HorizontalAlign.LEFT)
				.with { it.product.displayName },
			Column()
				.header("Amount")
				.with { it.amount.toString() },
			Column()
				.header("Price")
				.footer("Total")
				.with { formatCurrencyValue(it.product.price) },
			Column()
				.header("Value")
				.footer(formatCurrencyValue(saleOffer.totalToPay))
				.footerAlign(HorizontalAlign.RIGHT)
				.with { formatCurrencyValue(it.value) }
		)
	))
}