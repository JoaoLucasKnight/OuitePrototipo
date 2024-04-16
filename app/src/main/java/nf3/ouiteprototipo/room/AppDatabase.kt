package nf3.ouiteprototipo.room

import androidx.room.Database
import androidx.room.RoomDatabase
import nf3.ouiteprototipo.model.Artifact
import nf3.ouiteprototipo.model.Box
import nf3.ouiteprototipo.model.Space
import nf3.ouiteprototipo.room.dao.SpaceDAO

@Database(entities = [Space::class, Box::class, Artifact::class], version = 0 )
abstract class AppDatabase: RoomDatabase() {
    abstract fun spaceDao(): SpaceDAO
}