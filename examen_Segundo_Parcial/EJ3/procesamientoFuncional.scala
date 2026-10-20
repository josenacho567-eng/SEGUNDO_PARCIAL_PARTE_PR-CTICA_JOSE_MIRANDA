

object procesamientoFuncional{

    def procesarRango(desde: Int,hasta: Int,transformar: Int => Int,
    combinar: (Int, Int) => Int,valorInicial: Int): Int = {
        if desde == hasta then combinar(valorInicial, transformar(desde)) 
        else {
        val Aux = transformar(desde)
        val res = procesarRango(desde +1,hasta,transformar,combinar, Aux)
        combinar(Aux,res)
        }
    }

    def buscar(desde: Int,hasta: Int,condicion: Int => Boolean): Int = {
        if desde == hasta then {
            if condicion(hasta) then hasta
            else -1
        }
            else {
                if condicion(desde) then desde
                else buscar(desde +1,hasta,condicion)
            }
    }

    def contarDIvisores(num: Int): Int = {
        contarDIvisoresAux(num)
    }
    def contarDIvisoresAux(num: Int, contnum: Int =1,acum: Int = 0): Int ={
    if contnum > num then acum
    else {
         if num%contnum == 0 then contarDIvisoresAux(num,contnum +1, acum + 1)
         else contarDIvisoresAux(num,contnum +1, acum)
        }
    }

    def esPrimo(num:Int): Boolean = {
        contarDIvisores(num) == 2
    }

    def maximo(a:Int,b:Int): Int = {
        if a> b then a else b
    }
    def main(args: Array[String]): Unit = {
        println(procesarRango(22,26,contarDIvisores,maximo,0))
        println(buscar(24,28,esPrimo))
    }
}