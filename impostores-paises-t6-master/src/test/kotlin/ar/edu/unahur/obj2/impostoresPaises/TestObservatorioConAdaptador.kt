package ar.edu.unahur.obj2.impostoresPaises


import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe


class TestObservatorioConAdaptador : DescribeSpec({


    describe("//1 Poder consultar si son limítrofes.") {
        // varias combinaciones

        it("mismo continente") {

            observatorio.sonLimitrofes("argentina","uruguay").shouldBeTrue()

            observatorio.sonLimitrofes("argentina","peru").shouldBeFalse()

            observatorio.sonLimitrofes("brazil","chile").shouldBeFalse()

            observatorio.sonLimitrofes("Bolivia (Plurinational State of)","paraguay").shouldBeTrue()
        }

        it ("entre paises de otros continentes") {

            observatorio.sonLimitrofes("Bolivia (Plurinational State of)","spain").shouldBeFalse()

            observatorio.sonLimitrofes("argentina","new zealand").shouldBeFalse()
        }
    }

    describe("//2 Saber si se necesita traducción para que puedan dialogar") {
        // Esto ocurre si no comparten ninguno de sus idiomas oficiales.

        it("arranquemos") {

            observatorio.necesitaTraduccion("argentina","uruguay").shouldBeFalse()

            observatorio.necesitaTraduccion("argentina","portugal").shouldBeTrue()

            observatorio.necesitaTraduccion("brazil","portugal").shouldBeFalse()

            observatorio.necesitaTraduccion("chile","china").shouldBeTrue()

        }
    }

    describe("//3 Conocer si son potenciales aliados") {
        //Esto es así cuando no necesitan traducción y además comparten algún bloque regional.

        it("Conocer si son potenciales aliados") {

            observatorio.sonPotencialesAliados("argentina","brazil").shouldBeFalse()

            observatorio.sonPotencialesAliados("argentina","uruguay").shouldBeTrue()

            observatorio.sonPotencialesAliados("argentina","spain").shouldBeFalse()

            observatorio.sonPotencialesAliados("south africa","nigeria").shouldBeTrue()
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