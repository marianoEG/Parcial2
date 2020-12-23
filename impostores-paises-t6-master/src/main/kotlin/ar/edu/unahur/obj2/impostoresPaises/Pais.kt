package ar.edu.unahur.obj2.impostoresPaises

class Pais(
        val nombre: String,
        val codigoISO: String,
        var poblacion: Int,
        val continente: String,
        val bloquesRegionales: MutableSet<String>,
        val idiomasOficiales: MutableSet<String>){

    var paisesLimitrofes = mutableSetOf<Pais>()

    fun limitaCon(pais: Pais) : Boolean{
        return this.paisesLimitrofes.map { it.nombre }.contains(pais.nombre)
    }

    fun necesitaTraduccionCon(pais: Pais) : Boolean{
        return this.idiomasOficiales.intersect(pais.idiomasOficiales).isEmpty()
    }

    fun esPotencialAliadoCon(pais: Pais) : Boolean{
        return !this.necesitaTraduccionCon(pais) and this.comparteBloqueRegionalCon(pais)
    }

    private fun comparteBloqueRegionalCon(pais: Pais): Boolean {
        return this.bloquesRegionales.intersect(pais.bloquesRegionales).isNotEmpty()
    }
}