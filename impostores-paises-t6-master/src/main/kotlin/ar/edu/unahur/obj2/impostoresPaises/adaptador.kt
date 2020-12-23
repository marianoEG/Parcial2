package ar.edu.unahur.obj2.impostoresPaises

object Adaptador {

    var api = RestCountriesAPI()

    fun listaPaisesConvertidos() : List<Pais>{
        return api.todosLosPaises().map { this.convertirAPais(it) }
    }

    fun convertirAPais(country:Country):Pais {
        val pais = Pais(
                country.name,
                country.alpha3Code,
                country.population,
                country.region,
                this.adaptarBloqueRegional(country.regionalBlocs),
                this.adaptarIdiomas(country.languages)
        )
        pais.paisesLimitrofes.addAll(adaptarPaisesLimitrofes(country.borders))
        return pais
    }

    private fun adaptarBloqueRegional(regionalBlocs: List<RegionalBloc>): MutableSet<String> =
        regionalBlocs.map {(it.acronym)}.toMutableSet()

    private fun adaptarIdiomas(languages: List<Language>): MutableSet<String> =
        languages.map {(it.name)}.toMutableSet()

    private fun adaptarPaisesLimitrofes(borders: List<String>): MutableSet<Pais> =
        borders.map { (this.convertirAPaisSinLimitrofes(api.paisConCodigo(it))) }.toMutableSet()

    private fun convertirAPaisSinLimitrofes(country: Country): Pais {
        return Pais(
                country.name,
                country.alpha3Code,
                country.population,
                country.region,
                adaptarBloqueRegional(country.regionalBlocs),
                adaptarIdiomas(country.languages)
        )
    }

    fun buscarPais(pais: String): Country {  
        var countries = this.api.buscarPaisesPorNombre(pais)
        if (countries.isEmpty()) {
            countries = listOf(
                    Country(
                            name = "",
                            capital = "",
                            region = "",
                            population = 0,
                            alpha3Code = "",
                            borders = listOf<String>(),
                            languages = listOf<Language>(Language("")),
                            regionalBlocs = listOf<RegionalBloc>()
                            )
                    )
        }
        return countries.first()
    }

}

