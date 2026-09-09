package com.merinoana.calculadoracuotas

fun main() {
    println("=== CALCULADORA DE CUOTAS ===")

    print("Ingrese el nombre del producto: ")
    val nombreProducto = readln()

    print("Ingrese el precio del producto: ")
    val precio = readln().toDouble()

    print("Ingrese la cantidad: ")
    val cantidad = readln().toInt()

    // Validacion sin tildes para evitar errores
    var cuotas = 0
    while (cuotas != 6 && cuotas != 12 && cuotas != 24) {
        print("Ingrese el numero de cuotas (Solo se permite 6, 12 o 24): ")
        cuotas = readln().toInt()

        if (cuotas != 6 && cuotas != 12 && cuotas != 24) {
            println("-> Error: Valor invalido. Debe elegir 6, 12 o 24 cuotas.\n")
        }
    }

    // Calculos matematicos
    val montoInicial = precio * cantidad

    val porcentajeInteres = when (cuotas) {
        6 -> 0.20
        12 -> 0.40
        24 -> 0.60
        else -> 0.0
    }

    val montoInteres = montoInicial * porcentajeInteres
    val montoTotalAPagar = montoInicial + montoInteres
    val pagoMensual = montoTotalAPagar / cuotas

    // Mostrar Resultados con 2 decimales
    println("\n==================================================")
    println("               RESUMEN DE LA COMPRA")
    println("==================================================")
    println("Producto: $nombreProducto")
    println(String.format("Monto inicial: S/ %.2f", montoInicial))
    println("Interes aplicado: ${(porcentajeInteres * 100).toInt()}%")
    println(String.format("Monto a pagar con interes: S/ %.2f", montoTotalAPagar))
    println(String.format("Pago mensual: S/ %.2f", pagoMensual))

    // Calendario de pagos estructurado
    println("\n--- CALENDARIO DE PAGOS ($cuotas MESES) ---")
    println(String.format("%-4s | %-12s | %-10s | %-10s | %-10s", "N", "FECHA", "MONTO", "P.MENSUAL", "RESTA PAGO"))
    println("-".repeat(60))

    var montoActual = montoTotalAPagar

    // Variables manuales para la fecha (como en la pizarra: inicia 26/09/2026)
    var mesCalendario = 9
    var anioCalendario = 2026

    for (mes in 1..cuotas) {
        // Formatear la fecha manualmente (ej. 26/09/2026)
        val fechaTexto = String.format("26/%02d/%d", mesCalendario, anioCalendario)

        // Calcular la resta
        var restaPago = montoActual - pagoMensual

        // Evitar decimales negativos muy pequeños por redondeo
        if (restaPago < 0.01) {
            restaPago = 0.0
        }

        // Imprimir fila alineada
        println(String.format("%-4d | %-12s | %-10.2f | %-10.2f | %-10.2f",
            mes,
            fechaTexto,
            montoActual,
            pagoMensual,
            restaPago
        ))

        // Actualizar valores para el siguiente ciclo
        montoActual = restaPago
        mesCalendario++

        // Si llegamos a diciembre, pasamos a enero del siguiente año
        if (mesCalendario > 12) {
            mesCalendario = 1
            anioCalendario++
        }
    }
    println("==================================================")
}