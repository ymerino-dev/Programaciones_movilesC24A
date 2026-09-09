# Semana 3 - Calculadora de Cuotas (Con IA)

**Nombre del estudiante:** Ana Yanira Merino Ramos

## Descripción del Proyecto
Aplicación de consola desarrollada en Kotlin para simular el financiamiento de productos. El programa realiza lo siguiente:
* Solicita el ingreso de datos (nombre, precio, cantidad).
* Valida de forma estricta que las cuotas elegidas sean únicamente 6, 12 o 24.
* Calcula el monto total aplicando un interés escalonado (20% para 6 meses, 40% para 12 meses y 60% para 24 meses).
* Imprime un resumen detallado y un calendario de pagos mensual mediante bucles `for`.

## Prompt Utilizado (Inteligencia Artificial)
*Actúa como un programador experto en Kotlin y genérame el código para una calculadora de cuotas con las siguientes reglas:

- Ingresar el nombre del producto, el precio y la cantidad.
- Ingresar el número de cuotas (Solo permitir 6, 12 o 24 cuotas. Debe estar validado para no permitir otros valores).
- Intereses: 6 cuotas = 20%, 12 cuotas = 40%, 24 cuotas = 60%.
- MOSTRAR:
    * Monto inicial (precio * cantidad)
    * Monto a pagar con interés (monto inicial + interés según las cuotas)
    * Pago mensual
    * Un calendario de pagos iterativo (si elegí 6, mostrar del mes 1 al 6 con su pago respectivo).
- No usar librerías de Java como Scanner, usar código 100% nativo de Kotlin (readln)..*

## Captura de Ejecución
<img width="690" height="732" alt="resultado sem3" src="https://github.com/user-attachments/assets/672d6b3a-5784-49ed-84e0-617a2c75f487" />
