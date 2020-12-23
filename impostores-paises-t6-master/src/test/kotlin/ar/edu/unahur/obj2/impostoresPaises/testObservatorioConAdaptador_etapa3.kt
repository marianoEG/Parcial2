package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk


class TestObservatorioConAdaptador_Etapa3 : DescribeSpec({

    //
    val apiMockk = mockk<RestCountriesAPI>()

    Adaptador.api = apiMockk  //mockk<RestCountriesAPI>()

    every { Adaptador.api.buscarPaisesPorNombre("Bolivia (Plurinational State of)") } returns listOf(
            Country("Bolivia (Plurinational State of)",
                    "bolivia",
                    "America",
                    430500345,
                    "BOL",
                    listOf("ARG","BRA","PAR"),
                    listOf<Language>(Language("Español"),Language("quechua")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
            )
    )

    every { Adaptador.api.buscarPaisesPorNombre("paraguay") } returns listOf(
            Country("paraguay",
                    "paraguay",
                    "America",
                    440500345,
                    "PAR",
                    listOf("ARG","BRA","BOL"),
                    listOf<Language>(Language("Español"),Language("guarani")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
            )
    )

    every { Adaptador.api.paisConCodigo("PAR") } returns Country("paraguay",
            "paraguay",
            "America",
            45500345,
            "PAR",
            listOf("BOL"),
            listOf<Language>(Language("Español"),Language("guarani")),
            listOf<RegionalBloc>(RegionalBloc("",""))
    )

    every { Adaptador.api.paisConCodigo("BOL") } returns Country("Bolivia (Plurinational State of)",
            "bolivia",
            "America",
            430500345,
            "BOL",
            listOf("ARG","BRA","PAR"),
            listOf<Language>(Language("Español"),Language("quechua")),
            listOf<RegionalBloc>(RegionalBloc("",""))
    )

    every { Adaptador.api.buscarPaisesPorNombre("spain") } returns listOf(
            Country("spain",
                    "madrid",
                    "europa",
                    540500345,
                    "SPA",
                    listOf("POR"),
                    listOf<Language>(Language("Español")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
            )
    )

    every { Adaptador.api.paisConCodigo("SPA") } returns Country("spain",
            "madrid",
            "europa",
            540500345,
            "SPA",
            listOf("POR"),
            listOf<Language>(Language("Español")),
            listOf<RegionalBloc>(RegionalBloc("",""))
    )

    every { Adaptador.api.buscarPaisesPorNombre("portugal") } returns listOf(
            Country("portugal",
                    "portugal",
                    "europa",
                    340500345,
                    "POR",
                    listOf("SPA"),
                    listOf<Language>(Language("Portuguez")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
                )
            )

    every { Adaptador.api.paisConCodigo("POR") } returns Country("portugal",
            "portugal",
            "europa",
            340500345,
            "POR",
            listOf("SPA"),
            listOf<Language>(Language("Portuguez")),
            listOf<RegionalBloc>(RegionalBloc("",""))
    )



    every { Adaptador.api.buscarPaisesPorNombre("argentina") } returns listOf(
            Country("argentina",
                    "Buenos Aires",
                    "America",
                    44500345,
                    "ARG",
                    listOf("URY"),
                    listOf<Language>(Language("Español")),
                    listOf<RegionalBloc>(RegionalBloc("MERCO","Mercosur"))
            )
    )

    every { Adaptador.api.paisConCodigo("ARG") } returns Country("argentina",
            "Buenos Aires",
            "America",
            44500345,
            "ARG",
            listOf("uruguay"),
            listOf<Language>(Language("Español")),
            listOf<RegionalBloc>(RegionalBloc("","")))

    every { Adaptador.api.buscarPaisesPorNombre("uruguay") } returns listOf(
            Country("uruguay",
                    "Montevideo",
                    "America",
                    2500345,
                    "URY",
                    listOf("ARG"),
                    listOf<Language>(Language("Español")),
                    listOf<RegionalBloc>(RegionalBloc("MERCO","Mercosur"))
            )
    )

    every { Adaptador.api.paisConCodigo("URY") } returns Country("uruguay",
            "Montevideo",
            "America",
            2500345,
            "URY",
            listOf("argentina"),
            listOf<Language>(Language("Español")),
            listOf<RegionalBloc>(RegionalBloc("MERCO","Mercosur"))
    )

    every { Adaptador.api.buscarPaisesPorNombre("peru") } returns listOf(
            Country("peru",
                    "peru",
                    "America",
                    40500345,
                    "PER",
                    listOf("COL"),
                    listOf<Language>(Language("Español")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
            )
    )

    every { Adaptador.api.paisConCodigo("COL") } returns Country("colombia",
            "colombia",
            "America",
            45500345,
            "COL",
            listOf("PER"),
            listOf<Language>(Language("Español")),
            listOf<RegionalBloc>(RegionalBloc("",""))
    )

    every { Adaptador.api.buscarPaisesPorNombre("brazil") } returns listOf(
            Country("brazil",
                    "san pablo",
                    "America",
                    140500345,
                    "BRA",
                    listOf("ARG","URY"),
                    listOf<Language>(Language("portuguez")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
            )
    )

    every { Adaptador.api.paisConCodigo("BRA") } returns Country("brazil",
            "san pablo",
            "America",
            140500345,
            "BRA",
            listOf("ARG","URY"),
            listOf<Language>(Language("portuguez")),
            listOf<RegionalBloc>(RegionalBloc("",""))
    )

    every { Adaptador.api.buscarPaisesPorNombre("chile") } returns listOf(
            Country("chile",
                    "chile",
                    "America",
                    30500345,
                    "CHI",
                    listOf("ARG"),
                    listOf<Language>(Language("español")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
            )
    )

    every { Adaptador.api.buscarPaisesPorNombre("China") } returns listOf(
            Country("China",
                    "China",
                    "Asia",
                    1030500345,
                    "CHN",
                    listOf(""),
                    listOf<Language>(Language("Chino")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
            )
    )

    every { Adaptador.api.buscarPaisesPorNombre("India") } returns listOf(
            Country("India",
                    "India",
                    "Asia",
                    1030500344,
                    "IND",
                    listOf(""),
                    listOf<Language>(Language("Chino")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
            )
    )
    every { Adaptador.api.buscarPaisesPorNombre("United States of America") } returns listOf(
            Country("EEUU",
                    "EEUU",
                    "America",
                    1030500343,
                    "USA",
                    listOf(""),
                    listOf<Language>(Language("ingles")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
            )
    )

    every { Adaptador.api.buscarPaisesPorNombre("Indonesia") } returns listOf(
            Country("IndoIndonesia",
                    "Indonecia",
                    "Asia",
                    1030500342,
                    "IND",
                    listOf(""),
                    listOf<Language>(Language("Indonesio")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
            )
    )

    //every { Adaptador.api.todosLosPaises() } returns listOf<Country>()
    every { Adaptador.api.todosLosPaises() } returns listOf<Country>(
            Country("China",
                    "China",
                    "Asia",
                    1030500345,
                    "CHN",
                    listOf("ARG"),
                    listOf<Language>(Language("Chino")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
            )
            ,
            Country("India",
                    "India",
                    "Asia",
                    1030500344,
                    "IND",
                    listOf("ARG"),
                    listOf<Language>(Language("Indu")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
            )
            ,
            Country("United States of America",
                    "EEUU",
                    "America",
                    1030500343,
                    "USA",
                    listOf("ARG"),
                    listOf<Language>(Language("ingles")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
            )
            ,
            Country("Indonesia",
                    "Indonesia",
                    "Asia",
                    1030500342,
                    "IND",
                    listOf("ARG"),
                    listOf<Language>(Language("Indonesio")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
            )
            ,
            Country("Brazil",
                    "san pablo",
                    "America",
                    140500345,
                    "BRA",
                    listOf("ARG"),
                    listOf<Language>(Language("portuguez")),
                    listOf<RegionalBloc>(RegionalBloc("",""))
            )

    )

    describe("//1 Poder consultar si son limítrofes.") {
        // varias combinaciones



        observatorio.sonLimitrofes("argentina","uruguay").shouldBeTrue()



        observatorio.sonLimitrofes("argentina","peru").shouldBeFalse()



        observatorio.sonLimitrofes("brazil","chile").shouldBeFalse()


        it ("entre paises de otros continentes") {

            observatorio.sonLimitrofes("Bolivia (Plurinational State of)","spain").shouldBeFalse()

        }
    }

    describe("//2 Saber si se necesita traducción para que puedan dialogar") {
        // Esto ocurre si no comparten ninguno de sus idiomas oficiales.

        it("arranquemos") {

            observatorio.necesitaTraduccion("argentina","uruguay").shouldBeFalse()

            observatorio.necesitaTraduccion("argentina","portugal").shouldBeTrue()

            //observatorio.necesitaTraduccion("brazil","portugal").shouldBeFalse()

            //observatorio.necesitaTraduccion("chile","china").shouldBeTrue()

        }
    }

    describe("//3 Conocer si son potenciales aliados") {
        //Esto es así cuando no necesitan traducción y además comparten algún bloque regional.

        it("Conocer si son potenciales aliados") {

            observatorio.sonPotencialesAliados("argentina","brazil").shouldBeFalse()

            observatorio.sonPotencialesAliados("argentina","uruguay").shouldBeTrue()

            observatorio.sonPotencialesAliados("argentina","spain").shouldBeFalse()

            //observatorio.sonPotencialesAliados("south africa","nigeria").shouldBeTrue()
        }
    }

    describe("//4 Obtener los nombres de los 5 países con mayor población.") {

        it("5 países con mayor población") {

            observatorio.cincoPaisesConMayorPoblacion().shouldBe(listOf("China", "India", "United States of America", "Indonesia", "Brazil"))

        }
    }

    describe("//5 Indicar cuál es el continente más poblado") {

        it("continente más poblado") {

            observatorio.continenteMasPoblado().shouldBe("Asia")

        }

    }

})