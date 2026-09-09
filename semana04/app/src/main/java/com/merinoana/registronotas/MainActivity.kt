package com.merinoana.registronotas

import androidx.compose.material3.Button
import androidx.compose.ui.text.style.TextAlign
import kotlin.math.roundToInt
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.merinoana.registronotas.ui.theme.RegistroNotasTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.foundation.shape.RoundedCornerShape
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegistroNotasTheme {
                // Aquí usamos Scaffold, que es el lienzo en blanco básico de Material Design
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // ¡AQUÍ ESTÁ LA MAGIA! Llamamos a tu función, pasándole el padding
                    // para que no se superponga con la barra de estado del celular.
                    RegistroNotasApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RegistroNotasApp(modifier: Modifier = Modifier) {
    // Variables corregidas (remember con 'm' y notaPOO)
    var notaFundamentos by remember { mutableFloatStateOf(0f) }
    var notaPOO by remember { mutableFloatStateOf(0f) }
    var notaMoviles by remember { mutableFloatStateOf(0f) }
    var notaBD by remember { mutableFloatStateOf(0f) }

    var redondearPromedio by remember { mutableStateOf(false) }
    var confirmarNotas by remember { mutableStateOf(false) }

    // Memoria para guardar los resultados del cálculo
    var mostrarResultado by remember { mutableStateOf(false) }
    var promedioPonderado by remember { mutableFloatStateOf(0f) }
    var promedioFinal by remember { mutableFloatStateOf(0f) }

    // Contenedor principal
    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {

        // Encabezado principal de la sección
        Text(text = "Notas del ciclo", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = "Desliza para asignar cada nota (0 a 20)", color = Color.Gray, fontSize = 14.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // --- INICIO: Curso 1 - Fundamentos de Programación ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Fundamentos de Programación (20%)", fontWeight = FontWeight.SemiBold)

            // Badge que muestra el número exacto. Usamos .toInt() para ocultar los decimales[cite: 1]
            Text(text = "${notaFundamentos.toInt()}", fontWeight = FontWeight.Bold, color = Color(0xFF6750A4))
        }

        // El control nuevo: Slider[cite: 1]
        Slider(
            value = notaFundamentos,
            onValueChange = { nuevaNota -> notaFundamentos = nuevaNota },
            valueRange = 0f..20f, // Define el límite mínimo (0) y máximo (20)[cite: 1]
            steps = 19 // Forza al control a detenerse solo en números enteros[cite: 1]
        )
        // --- FIN: Curso 1 ---

        Spacer(modifier = Modifier.height(16.dp))

        // --- INICIO: Curso 2 - POO ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Programación Orientada a Objetos (25%)", fontWeight = FontWeight.SemiBold)
            Text(text = "${notaPOO.toInt()}", fontWeight = FontWeight.Bold, color = Color(0xFF6750A4))
        }
        Slider(
            value = notaPOO,
            onValueChange = { nuevaNota -> notaPOO = nuevaNota },
            valueRange = 0f..20f,
            steps = 19
        )
        // --- FIN: Curso 2 ---

        Spacer(modifier = Modifier.height(16.dp))

        // --- INICIO: Curso 3 - Móviles ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Programación en Móviles (30%)", fontWeight = FontWeight.SemiBold)
            Text(text = "${notaMoviles.toInt()}", fontWeight = FontWeight.Bold, color = Color(0xFF6750A4))
        }
        Slider(
            value = notaMoviles,
            onValueChange = { nuevaNota -> notaMoviles = nuevaNota },
            valueRange = 0f..20f,
            steps = 19
        )
        // --- FIN: Curso 3 ---

        Spacer(modifier = Modifier.height(16.dp))

        // --- INICIO: Curso 4 - Base de Datos ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Base de Datos (25%)", fontWeight = FontWeight.SemiBold)
            Text(text = "${notaBD.toInt()}", fontWeight = FontWeight.Bold, color = Color(0xFF6750A4))
        }
        Slider(
            value = notaBD,
            onValueChange = { nuevaNota -> notaBD = nuevaNota },
            valueRange = 0f..20f,
            steps = 19
        )
        // --- FIN: Curso 4 ---
        Spacer(modifier = Modifier.height(24.dp))

        Spacer(modifier = Modifier.height(24.dp))

        // Fila del Switch para redondear
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Redondear promedio final")
            androidx.compose.material3.Switch(
                checked = redondearPromedio,
                onCheckedChange = { nuevoEstado -> redondearPromedio = nuevoEstado }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Fila del Checkbox de confirmación
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            androidx.compose.material3.Checkbox(
                checked = confirmarNotas,
                onCheckedChange = { nuevoEstado -> confirmarNotas = nuevoEstado }
            )
            Text(text = "Confirmo que las notas son correctas")
        }

        // Botón principal
        Button(
            onClick = {
                // 1. Calculamos el promedio exacto con los pesos del documento[cite: 1]
                val ponderado = (notaFundamentos * 0.20f) +
                        (notaPOO * 0.25f) +
                        (notaMoviles * 0.30f) +
                        (notaBD * 0.25f)

                promedioPonderado = ponderado

                // 2. Evaluamos el Switch para decidir el promedio final[cite: 1]
                if (redondearPromedio) {
                    promedioFinal = ponderado.roundToInt().toFloat() // Redondea al entero más cercano[cite: 1]
                } else {
                    promedioFinal = ponderado // Lo deja tal cual
                }

                // 3. Encendemos la bandera para mostrar la tarjeta
                mostrarResultado = true
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = confirmarNotas // ¡Aquí aplicamos el parámetro enabled![cite: 1]
        ) {
            Text(text = "CALCULAR PROMEDIO")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mensaje gris inicial[cite: 1]
        if (!mostrarResultado) {
            Text(
                text = "Asigna las notas y confirma para calcular",
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        // --- INICIO: Tarjeta de Resultados ---
        if (mostrarResultado) {

            // 1. Lógica del 'when' para los estados y colores[cite: 1]
            val (observacion, colorChip) = when {
                promedioFinal >= 17f -> Pair("EXCELENTE", Color(0xFF2E7D32)) // Verde oscuro
                promedioFinal >= 13f -> Pair("APROBADO", Color(0xFF4CAF50)) // Verde normal
                promedioFinal >= 10f -> Pair("EN RECUPERACIÓN", Color(0xFFFF9800)) // Ámbar
                else -> Pair("DESAPROBADO", Color(0xFFF44336)) // Rojo
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    // Promedio ponderado (con 2 decimales)[cite: 1]
                    Text(
                        text = "Promedio ponderado: ${String.format("%.2f", promedioPonderado)}",
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Promedio Final
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "Promedio final: ",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF6750A4)
                        )
                        // Si es entero, se quitan los decimales en la vista para mayor limpieza
                        Text(
                            text = if (redondearPromedio) "${promedioFinal.toInt()}" else String.format("%.2f", promedioFinal),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF6750A4)
                        )

                        if (redondearPromedio) {
                            Text(
                                text = " (redondeado)",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(start = 4.dp, bottom = 2.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Chip de estado (El rectángulo de color con el texto)
                    Surface(
                        color = colorChip.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = observacion,
                            color = colorChip,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Mensaje final y tu firma[cite: 1]
            Text(
                text = "✓ Promedio calculado correctamente",
                color = Color(0xFF2E7D32),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Desarrollado por: Ana Merino", // Tu nombre aquí
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 12.sp
            )
        }
        // --- FIN: Tarjeta de Resultados ---
    }
}