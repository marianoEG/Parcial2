package ar.edu.unahur.obj2.impostoresPaises

object observatorio {
    val adaptador = Adaptador

    // Etapa 1
    fun buscaPais(pais : String) = adaptador.convertirAPais(adaptador.buscarPais(pais))

    //1 Poder consultar si son limítrofes.
    fun sonLimitrofes(pais1: String, pais2: String): Boolean {
        val p1 = this.buscaPais(pais1)
        val p2 = this.buscaPais(pais2)

        return p1.limitaCon(p2)
    }

    //2 Saber si se necesita traducción para que puedan dialogar. Esto ocurre si no comparten ninguno de sus idiomas oficiales.
    fun necesitaTraduccion(pais1: String, pais2: String): Boolean {
        val p1 = this.buscaPais(pais1)
        val p2 = this.buscaPais(pais2)

        return p1.necesitaTraduccionCon(p2)
    }

    //3 Conocer si son potenciales aliados. Esto es así cuando no necesitan traducción y además comparten algún bloque regional.
    fun sonPotencialesAliados(pais1: String, pais2: String) : Boolean {
        val p1 = this.buscaPais(pais1)
        val p2 = this.buscaPais(pais2)

        return p1.esPotencialAliadoCon(p2)
    }

    //4 Obtener los nombres de los 5 países con mayor población.
    fun cincoPaisesConMayorPoblacion(): List<String> {
        val paises = adaptador.listaPaisesConvertidos().sortedByDescending { it.poblacion }
        val listaNombrePaises = mutableListOf<String>()
        var indice = 0
        repeat(5) {
            listaNombrePaises.add(paises[indice].nombre)
            indice += 1
        }
        return listaNombrePaises
    }

    //5 Obtener el continente mas poblado.
    fun continenteMasPoblado() : String{
        val paises = adaptador.listaPaisesConvertidos()
        return paises.groupBy { it.continente }.maxByOrNull { it.value.sumByLong { it.poblacion.toLong() } }!!.key
    }
}

inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
    var sum = 0L
    for (element in this) {
        sum += selector(element)
    }
    return sum
}


