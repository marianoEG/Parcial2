package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
/*
class TestObservatorio : DescribeSpec({

    val argentina = Pais("argentina","ARG", 44464434,"America", mutableSetOf<String>("UNASUR","MERCOSUR"), mutableSetOf<String>("español"))
    val uruguay = Pais("uruguay","URY", 3564434,"America", mutableSetOf<String>("UNASUR","MERCOSUR"), mutableSetOf<String>("español"))
    val paraguay = Pais("paraguay","PRY", 7464434,"America", mutableSetOf<String>("UNASUR","MERCOSUR"), mutableSetOf<String>("español","guarani"))
    val chile = Pais("chile","CHI", 19164434,"America", mutableSetOf<String>("UNASUR","MERCOSUR"), mutableSetOf<String>("español"))
    val bolivia = Pais("bolivia","BOL", 11664434,"America", mutableSetOf<String>("UNASUR","MERCOSUR"), mutableSetOf<String>("español","quechua","aimara","guarani"))
    val venezuela = Pais("venezuela","VEN", 28434434,"America", mutableSetOf<String>("UNASUR"), mutableSetOf<String>("español"))
    val peru = Pais("peru","PER", 33464434,"America", mutableSetOf<String>("UNASUR"), mutableSetOf<String>("español"))
    val colombia = Pais("colombia","COL", 50464434,"America", mutableSetOf<String>("UNASUR"), mutableSetOf<String>("español"))
    val brasil = Pais("brasil","BRA", 212464434,"America", mutableSetOf<String>("UNASUR","MERCOSUR"), mutableSetOf<String>("portugues"))

    val espania = Pais("españa","ESP", 47464434,"Europa", mutableSetOf<String>("Union Europea"), mutableSetOf<String>("castellano"))
    val italia = Pais("italia","ITA", 60464434,"Europa", mutableSetOf<String>("Union Europea"), mutableSetOf<String>("italiano"))
    val portugal = Pais("portugal","POR", 10464434,"Europa", mutableSetOf<String>("Union Europea"), mutableSetOf<String>("portugues","mirandes"))
    val inglaterra = Pais("inglaterra","ENG", 56464434,"Europa", mutableSetOf<String>("Union Europea"), mutableSetOf<String>("ingles"))

    val japon = Pais("japon","JPN", 126644334,"Asia", mutableSetOf<String>("Paises asiaticos"), mutableSetOf<String>("japones"))
    val china = Pais("china","CHN", 1339644334,"Asia", mutableSetOf<String>("Paises asiaticos"), mutableSetOf<String>("chino","mandarin"))
    val india = Pais("india","IND", 1372644334,"Asia", mutableSetOf<String>("Paises asiaticos"), mutableSetOf<String>("hindi","ingles"))

    val sudafrica = Pais("sudafrica","RSA", 58644334,"Africa", mutableSetOf<String>("Paises africanos"), mutableSetOf<String>("zulu","ingles","afrikaans"))
    val nigeria = Pais("nigeria","NGR", 159644334,"Africa", mutableSetOf<String>("Paises africanos"), mutableSetOf<String>("ingles"))

    val australia = Pais("australia","AUS", 25644334,"oceania", mutableSetOf<String>("Paises oceanicos"), mutableSetOf<String>("ingles"))
    val nuevaZelanda = Pais("nueva zelanda","NZL", 5644334,"oceania", mutableSetOf<String>("Paises oceanicos"), mutableSetOf<String>("ingles","maori"))

    // establecemos los limitrofes
    argentina.agregarPaisLimitrofe(paraguay)
    argentina.agregarPaisLimitrofe(uruguay)
    argentina.agregarPaisLimitrofe(chile)
    argentina.agregarPaisLimitrofe(bolivia)
    argentina.agregarPaisLimitrofe(brasil)
    brasil.agregarPaisLimitrofe(uruguay)
    brasil.agregarPaisLimitrofe(paraguay)
    brasil.agregarPaisLimitrofe(bolivia)
    brasil.agregarPaisLimitrofe(peru)
    brasil.agregarPaisLimitrofe(colombia)
    brasil.agregarPaisLimitrofe(venezuela)
    venezuela.agregarPaisLimitrofe(colombia)
    colombia.agregarPaisLimitrofe(peru)
    peru.agregarPaisLimitrofe(bolivia)
    peru.agregarPaisLimitrofe(chile)
    chile.agregarPaisLimitrofe(bolivia)
    bolivia.agregarPaisLimitrofe(paraguay)


    describe("Inicializando observatorio") {

        observatorio.paises.add(argentina)
        observatorio.paises.add(uruguay)
        observatorio.paises.add(paraguay)
        observatorio.paises.add(chile)
        observatorio.paises.add(bolivia)
        observatorio.paises.add(venezuela)
        observatorio.paises.add(peru)
        observatorio.paises.add(colombia)
        observatorio.paises.add(brasil)
        observatorio.paises.add(espania)
        observatorio.paises.addAll(setOf(italia,portugal,inglaterra))
        observatorio.paises.addAll(setOf(japon,china,india,sudafrica,nigeria,australia,nuevaZelanda))
    }

    describe("//1 Poder consultar si son limítrofes.") {
        // varias combinaciones

        it("mismo continente") {

            observatorio.sonLimitrofes("argentina","uruguay").shouldBeTrue()

            observatorio.sonLimitrofes("argentina","peru").shouldBeFalse()

            observatorio.sonLimitrofes("brasil","chile").shouldBeFalse()

            observatorio.sonLimitrofes("bolivia","paraguay").shouldBeTrue()
        }

        it ("entre paises de otros continentes") {

            observatorio.sonLimitrofes("bolivia","españa").shouldBeFalse()

            observatorio.sonLimitrofes("argentina","nueva zelanda").shouldBeFalse()
        }
    }

    describe("//2 Saber si se necesita traducción para que puedan dialogar") {
        // Esto ocurre si no comparten ninguno de sus idiomas oficiales.

        it("arranquemos") {

            observatorio.necesitaTraduccion("argentina","uruguay").shouldBeFalse()

            observatorio.necesitaTraduccion("argentina","portugal").shouldBeTrue()

            observatorio.necesitaTraduccion("brasil","portugal").shouldBeFalse()

            observatorio.necesitaTraduccion("chile","china").shouldBeTrue()

        }
    }

    describe("//3 Conocer si son potenciales aliados") {
        //Esto es así cuando no necesitan traducción y además comparten algún bloque regional.

        it("Conocer si son potenciales aliados") {

            observatorio.sonPotencialesAliados("argentina", "brasil").shouldBeFalse()

            observatorio.sonPotencialesAliados("argentina", "uruguay").shouldBeTrue()

            observatorio.sonPotencialesAliados("argentina", "españa").shouldBeFalse()

            observatorio.sonPotencialesAliados("sudafrica", "nigeria").shouldBeTrue()
        }
    }

    describe("//4 Obtener los nombres de los 5 países con mayor población.") {

        it("5 países con mayor población") {

            observatorio.cincoPaisesConMayorPoblacion().shouldBe(listOf("india","china","brasil","nigeria","japon"))

            // de golpe crecieron los chilenos
            observatorio.paises.remove(chile)
            chile.poblacion = 300340423
            observatorio.paises.add(chile)

            observatorio.cincoPaisesConMayorPoblacion().shouldBe(listOf("india","china","chile","brasil","nigeria"))
        }
    }

    describe("//5 Indicar cuál es el continente más poblado") {

        it("continente más poblado") {

            observatorio.continenteMasPoblado().shouldBe("Asia")

            // otra traves crecieron los chilos
            observatorio.paises.remove(chile)
            chile.poblacion = 700340423
            observatorio.paises.add(chile)

            // tambien los uruguayos (donde entran tantos?)
            observatorio.paises.remove(uruguay)
            uruguay.poblacion = 50435366
            observatorio.paises.add(uruguay)

            // brasil crecio un moton tambien!!!
            observatorio.paises.remove(brasil)
            brasil.poblacion = 2045464565
            observatorio.paises.add(brasil)

            // y argentina no se quedo atras
            observatorio.paises.remove(argentina)
            argentina.poblacion = 1809489343
            observatorio.paises.add(argentina)

            observatorio.continenteMasPoblado().shouldBe("America")

        }

    }



}



)*/
