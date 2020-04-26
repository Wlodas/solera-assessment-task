package com.solera

data class SaleOffer(val entries: List<Entry>) {
	val totalToPay: Int = entries.sumBy(Entry::value)
	
	data class Entry(val product: Product, val amount: Int, val value: Int)
}