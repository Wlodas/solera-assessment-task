package com.solera

enum class Product(val price: Int) {
	APPLE(price = 25),
	ORANGE(price = 30),
	BANANA(price = 15),
	PAPAYA(price = 50);
	
	val displayName: String = name.toLowerCase().capitalize()
}