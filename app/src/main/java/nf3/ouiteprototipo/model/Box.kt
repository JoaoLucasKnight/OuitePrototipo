package nf3.ouiteprototipo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Box(
    @PrimaryKey
    var nomeId: String,
    var descricao: String,
    var caminho: String,
    var paiNameId: String
): Serializable
