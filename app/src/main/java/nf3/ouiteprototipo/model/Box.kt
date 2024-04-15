package nf3.ouiteprototipo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Box(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var nome: String,
    var descricao: String,
    var caminh: String
)
