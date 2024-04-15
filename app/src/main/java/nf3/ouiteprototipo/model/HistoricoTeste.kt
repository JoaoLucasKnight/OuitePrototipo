package nf3.ouiteprototipo.model

data class Historico(
    val titulo: String,
    val caminho: String,
    val data: String
)

class ManipulaHistorico {
    companion object{
        private val historicos = mutableListOf(
            Historico(
                titulo = "Cabo P2-P2",
                caminho = "Quarto>Escrivaninha>Gaveta2",
                data = "14/09"
            ),
            Historico(
                titulo = "Controle RGB",
                caminho = "Quarto>Escrivaninha>Gaveta1",
                data = "14/08"
            ),
            Historico(
                titulo = "HeadSeat",
                caminho = "Quarto>ArmarioAuxiliar>Porta3>Prateleira1",
                data = "14/07"
            ),Historico(
                titulo = "HeadSeat",
                caminho = "Quarto>ArmarioAuxiliar>Porta3>Prateleira1",
                data = "14/07"
            ),
            Historico(
                titulo = "HeadSeat",
                caminho = "Quarto>ArmarioAuxiliar>Porta3>Prateleira1",
                data = "14/07"
            )
        )

        fun getHistorico():List<Historico>{
            return historicos
        }

    }
}
