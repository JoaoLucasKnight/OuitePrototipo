package nf3.ouiteprototipo.model

class Space(
    val nome: String? = null,
    val caminho: String? = null
){
    companion object{
        private val lugares = mutableListOf(
            Space(
                nome = "Quarto",
                caminho = ""
            ),
            Space(
                nome = "Banheiro",
                caminho = "Quarto>"
            )
        )
    }

}
