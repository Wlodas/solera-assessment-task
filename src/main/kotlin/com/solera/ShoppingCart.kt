package com.solera

import com.google.common.collect.EnumMultiset

class ShoppingCart : Iterable<ShoppingCart.Entry> {
	private val products = EnumMultiset.create(Product::class.java)
	
	@JvmOverloads
	fun addProduct(product: Product, amount: Int = 1) {
		products.add(product, amount)
	}
	
	operator fun plusAssign(product: Product) = addProduct(product)
	
	override fun iterator() = products.entrySet().asSequence()
		.map { Entry(it.element, it.count) }
		.iterator()
	
	override fun hashCode() = products.hashCode()
	
	override fun equals(other: Any?) = this === other || other is ShoppingCart && products == other.products
	
	override fun toString() = products.toString()
	
	data class Entry(val product: Product, val amount: Int)
}