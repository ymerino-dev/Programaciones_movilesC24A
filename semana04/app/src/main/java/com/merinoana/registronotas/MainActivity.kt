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
        // En el siguiente paso agregaremos los controles aquí
    }
}