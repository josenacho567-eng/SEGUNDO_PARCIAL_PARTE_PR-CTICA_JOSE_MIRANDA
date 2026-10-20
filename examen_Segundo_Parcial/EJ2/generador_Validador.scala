def crearValidador(minimo: Int)(maximo: Int)(numero: Int): Boolean = {
    numero >= minimo && numero <= maximo


}
def evaluar( numero: Int, validador: Int => Boolean ): String = { 
    if validador(numero) then "VALIDO"
    else "INVALIDO"
}

object generador_Validador {
    def main(args: Array[String]): Unit = {
        val validarPorcentaje: Int => Boolean = crearValidador(0)(100)
        val validarEdadLaboral: Int => Boolean = crearValidador(18)(65)
        val validarNota: Int => Boolean = crearValidador(0)(100)

        println(evaluar(-10, validarNota))

    }
}