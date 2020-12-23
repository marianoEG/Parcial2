package ar.edu.unahur.obj2.impostoresPaises

import kotlin.system.exitProcess


object ProgramaPaises {
    var entradaSalida = Consola
    var appObservatorio = observatorio

    fun iniciar() {
        entradaSalida.escribirLinea(" ██████╗ ██████╗ ███████╗███████╗██████╗ ██╗   ██╗ █████╗ ████████╗ ██████╗ ██████╗ ██╗ ██████╗ \n" +
                "██╔═══██╗██╔══██╗██╔════╝██╔════╝██╔══██╗██║   ██║██╔══██╗╚══██╔══╝██╔═══██╗██╔══██╗██║██╔═══██╗\n" +
                "██║   ██║██████╔╝███████╗█████╗  ██████╔╝██║   ██║███████║   ██║   ██║   ██║██████╔╝██║██║   ██║\n" +
                "██║   ██║██╔══██╗╚════██║██╔══╝  ██╔══██╗╚██╗ ██╔╝██╔══██║   ██║   ██║   ██║██╔══██╗██║██║   ██║\n" +
                "╚██████╔╝██████╔╝███████║███████╗██║  ██║ ╚████╔╝ ██║  ██║   ██║   ╚██████╔╝██║  ██║██║╚██████╔╝\n" +
                " ╚═════╝ ╚═════╝ ╚══════╝╚══════╝╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝ ╚═════╝ \n" +
                "                                                                                                ")
        entradaSalida.escribirLinea("Elige una opcion( 1 al 5)")
        entradaSalida.escribirLinea("1.- Saber si dos paises son limitrofes")
        entradaSalida.escribirLinea("2.- Saber si dos paises si necesitan traduccion")
        entradaSalida.escribirLinea("3.- Saber si dos paises son potenciales aliados")
        entradaSalida.escribirLinea("4.- Cuales son los 5 paises con mayor poblacion")
        entradaSalida.escribirLinea("5.- Cuales es continente mas poblado")

        entradaSalida.escribirLinea("Ingresa una opcion del 1 al 5:")
        val opcionElegida = entradaSalida.leerLinea()!!

        if (opcionElegida.isEmpty()){
            entradaSalida.escribirLinea("Tenes que elegir una opcion")
            exitProcess(1)
        }
        else if (opcionElegida.toInt() !in 1..5){
            entradaSalida.escribirLinea("Opcion incorrecta, tenes que elegir entre 1 y 5")
            exitProcess(1)
        }

        entradaSalida.escribirLinea("Elegiste opcion ${opcionElegida}.- ")

        if (opcionElegida.toInt() in 1..3){

            entradaSalida.escribirLinea("ingresar pais 1")
            val pais1 = entradaSalida.leerLinea().toString()
            val paisEncontrado1 = appObservatorio.buscaPais(pais1)

            if (paisEncontrado1.nombre == "") {
                entradaSalida.escribirLinea("No encontramos nada, fijate si lo escribiste bien")
                exitProcess(1)
            }

            entradaSalida.escribirLinea("ingresar pais 2")
            val pais2 = entradaSalida.leerLinea().toString()

            val paisEncontrado2 = appObservatorio.buscaPais(pais2)

            if (paisEncontrado2.nombre == "") {
                entradaSalida.escribirLinea("No encontramos nada, fijate si lo escribiste bien")
                exitProcess(1)
            }
            entradaSalida.escribirLinea("Procesando...")
            when(opcionElegida.toInt()){
                1 -> if (appObservatorio.sonLimitrofes(pais1,pais2)) {
                    entradaSalida.escribirLinea("Son limitrofes")
                }
                else {
                    entradaSalida.escribirLinea("NO son limitrofes") }

                2 -> if (appObservatorio.necesitaTraduccion(pais1,pais2)) {
                    entradaSalida.escribirLinea("Necesitan traduccion")
                }
                else {
                    entradaSalida.escribirLinea("NO necesitan traduccion") }

                3 -> if (appObservatorio.sonPotencialesAliados(pais1,pais2)) {
                    entradaSalida.escribirLinea("Son potenciales aliados")
                }
                else {
                    entradaSalida.escribirLinea("NO son potenciales aliados") }
            }
        }

        else if (opcionElegida.toInt() == 4){
            entradaSalida.escribirLinea("Los cinco paises mas poblados son: ")
            entradaSalida.escribirLinea("Procesando...")
            entradaSalida.escribirLinea(appObservatorio.cincoPaisesConMayorPoblacion().toString())
        }

        else if (opcionElegida.toInt() == 5){
            entradaSalida.escribirLinea("El continente mas poblado es: ")
            entradaSalida.escribirLinea("Procesando...")
            entradaSalida.escribirLinea(appObservatorio.continenteMasPoblado())
        }

    }
}