package com.merinoana.lab02_conia;

import java.util.ArrayList;
import java.util.Scanner;

// ============================================================================
// 1. ENCAPSULAMIENTO Y HERENCIA: Clase Padre Abstracta
// ============================================================================
abstract class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    // POLIMORFISMO (Fase 1): Método abstracto
    public abstract double calcularSubtotalItem();
}

// ============================================================================
// 2. HERENCIA Y POLIMORFISMO: Clases Hijas
// ============================================================================
class ProductoElectronico extends Producto {
    public ProductoElectronico(String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    // POLIMORFISMO (Fase 2): Sobrescribimos el método con 5% de recargo
    @Override
    public double calcularSubtotalItem() {
        double subtotalBase = getPrecio() * getCantidad();
        return subtotalBase * 1.05;
    }
}

class ProductoAccesorio extends Producto {
    public ProductoAccesorio(String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    // POLIMORFISMO (Fase 2): Sobrescribimos el método sin recargo
    @Override
    public double calcularSubtotalItem() {
        return getPrecio() * getCantidad();
    }
}

// ============================================================================
// 3. CLASE PRINCIPAL: Ejecución
// ============================================================================
public class CarritoCompras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> carrito = new ArrayList<>();

        System.out.println("=========================================");
        System.out.println("   SISTEMA DE VENTAS TECSUP - POO JAVA   ");
        System.out.println("=========================================\n");

        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();

        boolean agregarMas = true;

        while (agregarMas) {
            System.out.println("\n--- Agregar Nuevo Producto ---");

            System.out.print("Tipo de producto (1: Electrónico, 2: Accesorio): ");
            int tipo = Integer.parseInt(scanner.nextLine());

            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.print("Precio unitario (S/): ");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            Producto nuevoProducto;
            if (tipo == 1) {
                nuevoProducto = new ProductoElectronico(nombre, precio, cantidad);
                System.out.println("-> (Aviso: Se aplicará 5% de recargo por garantía electrónica)");
            } else {
                nuevoProducto = new ProductoAccesorio(nombre, precio, cantidad);
            }

            carrito.add(nuevoProducto);
            System.out.println("¡Producto agregado con éxito!");

            System.out.print("\n¿Desea agregar otro producto? (S/N): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("n")) {
                agregarMas = false;
            }
        }

        double subtotalGeneral = 0.0;
        Producto productoMasCaro = null;

        for (Producto p : carrito) {
            subtotalGeneral += p.calcularSubtotalItem();

            if (productoMasCaro == null || p.getPrecio() > productoMasCaro.getPrecio()) {
                productoMasCaro = p;
            }
        }

        double igv = subtotalGeneral * 0.18;
        double totalAPagar = subtotalGeneral + igv;
        double descuento = 0.0;

        if (totalAPagar > 5000) {
            descuento = totalAPagar * 0.10;
        } else if (totalAPagar > 3000) {
            descuento = totalAPagar * 0.05;
        }

        double totalFinal = totalAPagar - descuento;

        System.out.println("\n=========================================");
        System.out.println("               TICKET DE VENTA             ");
        System.out.println("=========================================");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("-----------------------------------------");

        for (Producto p : carrito) {
            System.out.printf("%d x %-15s (PU: S/%.2f) = S/ %.2f\n",
                    p.getCantidad(), p.getNombre(), p.getPrecio(), p.calcularSubtotalItem());
        }

        System.out.println("-----------------------------------------");
        System.out.printf("SUBTOTAL GENERAL    : S/ %10.2f\n", subtotalGeneral);
        System.out.printf("IGV (18%%)           : S/ %10.2f\n", igv);
        System.out.printf("TOTAL A PAGAR       : S/ %10.2f\n", totalAPagar);
        System.out.printf("DESCUENTO APLICADO  : S/ %10.2f\n", descuento);
        System.out.println("-----------------------------------------");
        System.out.printf("TOTAL FINAL         : S/ %10.2f\n", totalFinal);
        System.out.println("=========================================");

        if (productoMasCaro != null) {
            System.out.printf("DATO EXTRA -> Producto más caro: %s a S/ %.2f\n",
                    productoMasCaro.getNombre(), productoMasCaro.getPrecio());
        }

        scanner.close();
    }
}