package nf3.ouiteprototipo.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import nf3.ouiteprototipo.model.Space

@Dao
interface SpaceDAO {
    @Query("SELECT * FROM Space")
    fun getAll(): List<Space>

    @Insert
    fun salvar(space:Space)
}