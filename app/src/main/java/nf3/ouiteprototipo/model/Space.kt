package nf3.ouiteprototipo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity
data class Space(
    @PrimaryKey
    val nomeId: String,
    val descricao: String,
    val paiNameId: String?,
    var caminho: String?
):Serializable

