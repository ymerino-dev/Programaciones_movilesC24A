package com.merinoana.lab02_sinia

data class Producto(
    val nombre: String,
    val precio: Double,
    var cantidad: Int
)

fun calcularSubtotal(productos: List<Producto>): Double {
    var subtotal = 0.0
    for (p in productos) {
        subtotal += p.precio * p.cantidad
    }
    return subtotal
}

fun calcularIGV(subtotal: Double): Double {
    return subtotal * 0.18
}

fun calcularTotal(subtotal: Double, igv: Double): Double {
    return subtotal + igv
}

fun calcularDescuento(total: Double): Double {
    return when {
        total > 5000 -> total * 0.10
        total > 3000 -> total * 0.05
        else -> 0.0
    }
}

fun mostrarDetalle(productos: List<Producto>) {
    println("\n--------- DETALLE DEL CARRITO ---------")
    var i = 1
    for (p in productos) {
        val importe = p.precio * p.cantidad
        println(String.format("%d. %-20s x%d   S/ %7.2f", i, p.nombre, p.cantidad, importe))
        i++
    }
    println("-----------------------------------------")
}

fun main() {
    println("=========================================")
    println("   CARRITO DE COMPRAS - TIENDA TECSUP    ")
    println("=========================================")

    print("Ingrese el nombre del cliente: ")
    val nombreCliente = readln()
    println("Cliente: $nombreCliente\n")

    val carrito = mutableListOf<Producto>()

    var agregarMas = true
    while (agregarMas) {
        print("Ingrese producto: ")
        val nombreProd = readln()
        print("Ingrese precio: ")
        val precioProd = readln().toDouble()
        print("Ingrese cantidad: ")
        val cantidadProd = readln().toInt()

        carrito.add(Producto(nombreProd, precioProd, cantidadProd))
        println("Producto agregado: $nombreProd\n")

        print("¿Desea agregar otro producto? (s/n): ")
        if (readln().lowercase() != "s") agregarMas = false
        println()
    }

    mostrarDetalle(carrito)

    val subtotal = calcularSubtotal(carrito)
    val igv = calcularIGV(subtotal)
    val totalPagar = calcularTotal(subtotal, igv)
    val descuento = calcularDescuento(totalPagar)

    println(String.format("Cantidad de productos : %d", carrito.size))
    println(String.format("Subtotal              : S/ %7.2f", subtotal))
    println(String.format("IGV (18%%)             : S/ %7.2f", igv))
    println(String.format("TOTAL A PAGAR         : S/ %7.2f", totalPagar))
    println("-----------------------------------------")

    val masCaro = carrito.maxByOrNull { it.precio }
    if (masCaro != null) {
        println(String.format("\nProducto mas caro: %s (S/ %.2f)", masCaro.nombre, masCaro.precio))
    }

    if (descuento > 0) {
        val porcentajeDesc = if (totalPagar > 5000) "10%" else "5%"
        val umbral = if (totalPagar > 5000) 5000 else 3000
        println("Descuento aplicado: $porcentajeDesc por compra mayor a S/ $umbral")
        println(String.format("TOTAL CON DESCUENTO   : S/ %.2f", totalPagar - descuento))
    } else {
        println("Descuento aplicado: Ninguno")
    }

    println("\nGracias por su compra, $nombreCliente!")
}