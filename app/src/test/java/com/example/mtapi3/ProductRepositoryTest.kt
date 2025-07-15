package com.example.mtapi3

import org.junit.Assert.*
import org.junit.Test

class ProductRepositoryTest {

    private val repo = object : ProductRepository() {
        override fun loadProducts(): List<Product> = listOf(
            Product(
                id = 1,
                name = "Auriculares Bluetooth",
                description = "Auriculares con cancelación de ruido",
                price = 19999.99,
                currency = "ARS",
                in_stock = true
            ),
            Product(
                id = 2,
                name = "Teclado Mecánico",
                description = "Switches rojos, retroiluminado",
                price = 25999.99,
                currency = "ARS",
                in_stock = false
            )
        )
    }

    @Test
    fun `la lista de productos debe contener productos con todos sus campos completos`() {
        val productos = repo.loadProducts()
        assertEquals(2, productos.size)

        val primero = productos[0]
        assertEquals("Auriculares Bluetooth", primero.name)
        assertEquals("Auriculares con cancelación de ruido", primero.description)
        assertTrue(primero.in_stock)
    }

    @Test
    fun `la lista vacía no debe mostrar ningún producto`() {
        val repoVacio = object : ProductRepository() {
            override fun loadProducts(): List<Product> = emptyList()
        }

        val productos = repoVacio.loadProducts()
        assertTrue(productos.isEmpty())
    }
}