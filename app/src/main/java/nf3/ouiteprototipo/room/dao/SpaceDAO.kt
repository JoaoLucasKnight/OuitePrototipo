package nf3.ouiteprototipo.room.dao

import androidx.room.Dao
import androidx.room.Delete

import androidx.room.Insert
import androidx.room.Query
import nf3.ouiteprototipo.model.Artifact
import nf3.ouiteprototipo.model.Box
import nf3.ouiteprototipo.model.Space

@Dao
interface SpaceDAO {
    @Query("SELECT * FROM Space")
    fun getAll(): List<Space>

    @Query("SELECT * FROM Space WHERE caminho LIKE :caminho")
    fun getAllCaminho(caminho: String): List<Space>

    @Query("SELECT * FROM Space WHERE paiNameId = :id")
    fun getPai(id: String): List<Space>

    @Query("SELECT * FROM Space WHERE nomeId = :id")
    fun getId(id: String): Space?
    @Query("SELECT caminho FROM Space  WHERE nomeId = :id")
    fun getCaminho(id: String): String?
    @Insert
    fun salvar(space:Space)
    @Delete
    fun delete(space: Space)
}

@Dao
interface BoxDAO {
    @Insert
    fun salvar(box: Box)
    @Delete
    fun delete(box: Box)
    @Query("SELECT * FROM Box WHERE paiNameId = :id")
    fun getPai(id: String): List<Box>
}

@Dao
interface ArtifactDAO {
    @Insert
    fun salvar(artifact: Artifact)
    @Delete
    fun delete(artifact: Artifact)
    @Query("SELECT * FROM Artifact WHERE paiNameId = :id")
    fun getPai(id: String): List<Artifact>
}