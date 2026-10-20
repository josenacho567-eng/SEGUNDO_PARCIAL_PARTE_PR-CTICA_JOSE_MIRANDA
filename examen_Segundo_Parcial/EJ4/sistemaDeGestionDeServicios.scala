abstract class Servicio (
    val tipo: String,
    val duracion: Int,
    val fecha: String,
    val personal: Int,
    val costo: Double
) {
    def descripcion(): String
}

class Fotografia(
    tipo: String,
    duracion: Int,
    fecha: String,
    personal: Int,
    costo: Double,
    val cantidadDeCamaras: Int,
    val cantidadDeLuces: Int
) extends Servicio(tipo,duracion, fecha,personal,costo) with ElectricidadPorEquipo {
    def descripcion(): String = s"El servicion de $tipo tiene un costo de $costo esta fechado para el $fecha"
}

class Sonido(
    tipo: String,
    duracion: Int,
    fecha: String,
    personal: Int,
    costo: Double,
    val cantidaDeParlantes: Int,
    val cantidadDeMics: Int
) extends Servicio(tipo,duracion,fecha,personal,costo) with Electricidad {
    def descripcion(): String = s"El servicion de $tipo tiene un costo de $costo y esta fechado para el $fecha"

}

trait ElectricidadPorEquipo{
    def luz(): String  = s"El costo sube por la cantidad de equpo electronico"
}

object Sonido{
    def apply(tipo: String,
    duracion: Int,
    fecha: String,
    personal: Int,
    costo: Double,cantidaDeParlantes: Int,
    cantidadDeMics: Int): Sonido = {
        new Sonido(tipo,duracion,fecha,if personal >= 1 then personal else 1, costo,cantidaDeParlantes,cantidadDeMics)
    }
}

