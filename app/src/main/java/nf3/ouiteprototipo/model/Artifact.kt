package nf3.ouiteprototipo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Artifact(
    @PrimaryKey
    var nomeId: String,
    var descricao: String,
    var caminh: String,
    var paiNameId: String
)