package nf3.ouiteprototipo.room.dao

import androidx.room.Dao
import androidx.room.Query
import nf3.ouiteprototipo.model.Spaces

@Dao
interface SpaceDAO {
    @Query("SELECT * FROM Spaces")
    fun getAll(): List<Spaces>

}