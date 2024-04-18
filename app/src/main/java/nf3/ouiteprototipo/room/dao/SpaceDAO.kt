package nf3.ouiteprototipo.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import nf3.ouiteprototipo.model.Space

@Dao
interface SpaceDAO {
    @Query("SELECT * FROM Space")
    fun getAll(): List<Space>

    @Query("SELECT * FROM Space WHERE nomeId = :id")
    fun getId(id: String): Space?
    @Insert
    fun salvar(space:Space)
}