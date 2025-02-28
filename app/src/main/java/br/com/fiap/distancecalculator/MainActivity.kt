package br.com.fiap.distancecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.distancecalculator.ui.theme.DistanceCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DistanceCalculatorTheme {
                Surface( modifier = Modifier.fillMaxSize() ) {
                    AppScreen()
                }
            }
        }
    }
}

@Composable
fun AppScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        ) {
        
        Column(
            modifier = Modifier
                .fillMaxWidth()) {
            //coluna 1
            // ----- header ----- //
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(color = colorResource(id = R.color.cor_fundo))
            ) {
                Image(
                    painter = painterResource(R.drawable.gasolina),
                    contentDescription = "Imagem de mapa com gasolina",
                    modifier = Modifier.padding(top = 25.dp)
                        .size(120.dp)
                )
                Text(
                    text = "Calcusolina",
                    color = colorResource(R.color.white),
                    fontSize = 20.sp
                )

            }
            // ----- formulario ----- //
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)) {
                Card(
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth()
                        .offset(y = (-25).dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {

                }


            }


        }

    }

}


@Preview(showBackground = true)
@Composable
fun AppScreenPreview() {
    AppScreen()
}
