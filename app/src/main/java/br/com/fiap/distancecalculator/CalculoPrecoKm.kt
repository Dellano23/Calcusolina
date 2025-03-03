package br.com.fiap.distancecalculator

fun calculoPrecoKm(distancia: Double, kmPorLitro: Double, precoLitro: Double): Double {

    val gasolinaNecessaria = distancia / kmPorLitro  // Litros necessários para a viagem
    val gastoTotal = gasolinaNecessaria * precoLitro      // Custo total da viagem
    val gastoKm = gastoTotal / distancia
    return gastoKm

}