package com.merinoana.registronotas

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

    }
}