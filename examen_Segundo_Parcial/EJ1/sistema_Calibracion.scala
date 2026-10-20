def crearTransformacion(factor: Double,desplazamiento: Double): Double => Double ={
    (x: Double) => factor * x + desplazamiento
}

object sistema_Calibracion {



    def main(args: Array[String]): Unit = {
        val corregirError: Double => Double = crearTransformacion(1,-1.5)
        val calibrarSensor: Double => Double = crearTransformacion(1.4,0)
        val convertirFahrenheit: Double => Double = crearTransformacion(1.8,32)

        val procesarTemperatura: Double => Double = corregirError.andThen(calibrarSensor).andThen(convertirFahrenheit)
        println(procesarTemperatura(5))
    }
}