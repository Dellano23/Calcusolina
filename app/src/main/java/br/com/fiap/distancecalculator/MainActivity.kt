package br.com.fiap.distancecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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

    var distanciaKm by remember {
        mutableStateOf("")
    }
    var kmLitro by remember {
        mutableStateOf("")
    }
    var precoGasolina by remember {
        mutableStateOf("")
    }

    var precoKM by remember {
        mutableStateOf(0.0)
    }

    var verificaPreco = when {
        precoKM == 0.0 -> colorResource(R.color.purple_200)
        precoKM < 2.00 -> colorResource(R.color.teal_700)
        else -> colorResource(R.color.cor_fundo)
    }


    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
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
                    .background(color = colorResource(id = R.color.cor_texto))
            ) {
                Image(
                    painter = painterResource(R.drawable.gasolina),
                    contentDescription = "Imagem de mapa com gasolina",
                    modifier = Modifier
                        .padding(top = 25.dp)
                        .size(100.dp)
//                        .background(color = Color.Blue)

                )
                Text(
                    text = "Calcusolina",
                    color = colorResource(R.color.white),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

            }
            // ----- formulario ----- //
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-25).dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {

                    Column(

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp, horizontal = 32.dp)
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Sua viagem",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.cor_texto),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()

                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        // -------- Distancia -------- //
                        Text(
                            text = "Distância",
                            color = colorResource(R.color.cor_texto),
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                        
                        OutlinedTextField(
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            value = distanciaKm,
                            onValueChange = { distanciaKm = it},
                            modifier = Modifier.border(
                                2.dp,
                                color = colorResource(R.color.cor_texto),
                                shape = RoundedCornerShape(4.dp)
                            ),
                            placeholder = { Text(
                                text = "Distância em KM",
                                color = Color.LightGray
                            ) }

                        )
                        // -------- Km por litro -------- //
                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Km por litro",
                            color = colorResource(R.color.cor_texto),
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )

                        OutlinedTextField(
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            value = kmLitro,
                            onValueChange = {kmLitro = it},
                            modifier = Modifier.border(
                                2.dp,
                                color = colorResource(R.color.cor_texto),
                                shape = RoundedCornerShape(4.dp)
                            ),
                            placeholder = { Text(
                                text = "Cada litro são quantos Km?",
                                color = Color.LightGray
                            ) }

                        )
                        // -------- Preço gasolina -------- //
                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Preço gasolina",
                            color = colorResource(R.color.cor_texto),
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )

                        OutlinedTextField(
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            value = precoGasolina,
                            onValueChange = {precoGasolina = it},
                            modifier = Modifier.border(
                                2.dp,
                                color = colorResource(R.color.cor_texto),
                                shape = RoundedCornerShape(4.dp)
                            ),
                            placeholder = { Text(
                                text = "Valor do litro (R$)",
                                color = Color.LightGray
                            ) }

                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { precoKM = calculoPrecoKm(
                                distancia = distanciaKm.toDouble(),
                                kmPorLitro = kmLitro.toDouble(),
                                precoLitro = precoGasolina.toDouble()
                            ) },
                            shape = RoundedCornerShape(16.dp),
//                            colors = ButtonDefaults.buttonColors(containerColor = if (verificaPreco) Color.Green else Color.Red),
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.cor_texto)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                        ) {
                            Text(
                                text = "CALCULAR",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }






                    }

                }

                // ----------- Card resultado ------------ //
                Spacer(modifier = Modifier.height(12.dp))

                Card(
                    modifier = Modifier
                        .width(300.dp)
                        .height(80.dp)
                        .padding(horizontal = 16.dp, vertical = 6.dp)
                        .align(Alignment.CenterHorizontally),
                    colors = CardDefaults.cardColors(containerColor = verificaPreco),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = String.format("%.2f", precoKM),
                            fontSize = 32.sp,
                            color = colorResource(R.color.white),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Preço por KM",
                            fontSize = 12.sp,
                            color = Color.White,
                            fontStyle = FontStyle.Italic
                        )

                    }



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
