package nf3.ouiteprototipo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import nf3.ouiteprototipo.model.Artifact
import nf3.ouiteprototipo.model.Box
import nf3.ouiteprototipo.model.Space
import nf3.ouiteprototipo.room.dao.ArtifactDAO

import nf3.ouiteprototipo.room.dao.BoxDAO
import nf3.ouiteprototipo.room.dao.SpaceDAO

@Database(entities = [Space::class, Box::class, Artifact::class], version = 1 )
abstract class AppDatabase: RoomDatabase() {
    abstract fun spaceDao(): SpaceDAO
    abstract fun boxDao(): BoxDAO
    abstract fun artifactDao(): ArtifactDAO

    companion object{
        fun instancia(context: Context): AppDatabase{
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "ouite.db"
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}