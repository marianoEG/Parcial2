package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*

class ProgramaPaisesTest : DescribeSpec({

    describe("Test programaPaises") {

        val mockCosola = mockk<Consola>()
        ProgramaPaises.entradaSalida = mockCosola

        val mockObservatorio = mockk<observatorio>()
        ProgramaPaises.appObservatorio = mockObservatorio

        val argentina = Pais(
                "argentina",
                "ARG",
                44384529,
                "Americas",
                mutableSetOf("mercosur"),
                mutableSetOf("español")
        )

        val uruguay = Pais(
                "uruguay",
                "URY",
                4384529,
                "Americas",
                mutableSetOf("mercosur"),
                mutableSetOf("español")
        )

        val colombia = Pais(
                "colombia",
                "COL",
                44384529,
                "Americas",
                mutableSetOf("mercosur"),
                mutableSetOf("español")
        )

        val canada = Pais(
                "canada",
                "CAN",
                48384529,
                "Americas",
                mutableSetOf("Alianza de EEUU"),
                mutableSetOf("ingles")
        )


        it("test opcion1 - Limitrofes") {

            every { mockCosola.escribirLinea(any()) } just Runs
            every { mockCosola.leerLinea() } returnsMany listOf( "1", "argentina", "uruguay" )

            every { mockObservatorio.buscaPais("argentina") } returns argentina
            every { mockObservatorio.buscaPais("uruguay") } returns uruguay
            every { mockObservatorio.sonLimitrofes("argentina", "uruguay") } returns true

            ProgramaPaises.iniciar()

            verify { mockCosola.escribirLinea("Son limitrofes") }

        }

        it("test opcion1 - No son limitrofes") {

            every { mockCosola.escribirLinea(any()) } just Runs
            every { mockCosola.leerLinea() } returnsMany listOf( "1", "argentina", "colombia" )

            every { mockObservatorio.buscaPais("argentina") } returns argentina
            every { mockObservatorio.buscaPais("colombia") } returns uruguay
            every { mockObservatorio.sonLimitrofes("argentina", "colombia") } returns false

            ProgramaPaises.iniciar()

            verify { mockCosola.escribirLinea("NO son limitrofes") }

        }

        it("test opcion2 - Necesitan traduccion") {

            every { mockCosola.escribirLinea(any()) } just Runs
            every { mockCosola.leerLinea() } returnsMany listOf( "2", "argentina", "canada" )

            every { mockObservatorio.buscaPais("argentina") } returns argentina
            every { mockObservatorio.buscaPais("canada") } returns canada
            every { mockObservatorio.necesitaTraduccion("argentina", "canada") } returns true

            ProgramaPaises.iniciar()

            verify { mockCosola.escribirLinea("Necesitan traduccion") }

        }

        it("test opcion2 - NO necesitan traduccion") {

            every { mockCosola.escribirLinea(any()) } just Runs
            every { mockCosola.leerLinea() } returnsMany listOf( "2", "argentina", "uruguay" )

            every { mockObservatorio.buscaPais("argentina") } returns argentina
            every { mockObservatorio.buscaPais("uruguay") } returns uruguay
            every { mockObservatorio.necesitaTraduccion("argentina", "uruguay") } returns false

            ProgramaPaises.iniciar()

            verify { mockCosola.escribirLinea("NO necesitan traduccion") }

        }

        it("test opcion3 - Son potenciales aliados") {

            every { mockCosola.escribirLinea(any()) } just Runs
            every { mockCosola.leerLinea() } returnsMany listOf( "3", "argentina", "uruguay" )

            every { mockObservatorio.buscaPais("argentina") } returns argentina
            every { mockObservatorio.buscaPais("uruguay") } returns uruguay
            every { mockObservatorio.sonPotencialesAliados("argentina", "uruguay") } returns true

            ProgramaPaises.iniciar()

            verify { mockCosola.escribirLinea("Son potenciales aliados") }

        }

        it("test opcion3 - NO son potenciales aliados") {

            every { mockCosola.escribirLinea(any()) } just Runs
            every { mockCosola.leerLinea() } returnsMany listOf( "3", "argentina", "canada" )

            every { mockObservatorio.buscaPais("argentina") } returns argentina
            every { mockObservatorio.buscaPais("canada") } returns canada
            every { mockObservatorio.sonPotencialesAliados("argentina", "canada") } returns false

            ProgramaPaises.iniciar()

            verify { mockCosola.escribirLinea("NO son potenciales aliados") }

        }

        it("test opcion4 - Los cinco paises mas poblados") {

            every { mockCosola.escribirLinea(any()) } just Runs
            every { mockCosola.leerLinea() } returnsMany listOf( "4" )

            every { mockObservatorio.cincoPaisesConMayorPoblacion() } returns listOf("China", "India", "United States of America", "Indonesia", "Brazil")

            ProgramaPaises.iniciar()

            verify { mockCosola.escribirLinea("[China, India, United States of America, Indonesia, Brazil]") }

        }

        it("test opcion5 - El continente mas poblado") {

            every { mockCosola.escribirLinea(any()) } just Runs
            every { mockCosola.leerLinea() } returnsMany listOf( "5" )

            every { mockObservatorio.continenteMasPoblado() } returns "Asia"

            ProgramaPaises.iniciar()

            verify { mockCosola.escribirLinea("Asia") }

        }
    }

})