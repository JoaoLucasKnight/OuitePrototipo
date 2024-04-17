package nf3.ouiteprototipo.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Space(
    @PrimaryKey
    val nomeId: String,
    val descricao: String,
    val caminho: String,
    val paiNameId: String?
)
