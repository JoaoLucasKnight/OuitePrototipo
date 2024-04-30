package nf3.ouiteprototipo.model


import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity
data class Space(
    @PrimaryKey
    val nomeId: String,
    val descricao: String?,
    val paiNameId: String?,
    var caminho: String?
): teste

