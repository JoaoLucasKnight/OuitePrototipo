package nf3.ouiteprototipo.model

data class Space(
    val nome: String,
    val caminho: String
)

class ManipulaSpace {
    companion object{
        private val spaces = mutableListOf(
            Space(
                nome = "Quarto",
                caminho = ""
            )
        )

        fun getSpaces(): List<Space> {
            return spaces
        }

        fun addSpace(space: Space) {
            spaces.add(space)
        }
    }
}
