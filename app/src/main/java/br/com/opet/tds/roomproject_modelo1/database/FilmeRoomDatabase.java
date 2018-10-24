package br.com.opet.tds.roomproject_modelo1.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.com.opet.tds.roomproject_modelo1.DAO.FilmeDAO;
import br.com.opet.tds.roomproject_modelo1.DAO.GeneroDAO;
import br.com.opet.tds.roomproject_modelo1.model.Filme;
import br.com.opet.tds.roomproject_modelo1.model.Genero;

/**
 * Created by Diego on 24/09/2018.
 */
@Database(entities = {Filme.class,Genero.class},version = 1)
public abstract class FilmeRoomDatabase extends RoomDatabase {
    private static volatile FilmeRoomDatabase INSTANCE;
    public abstract FilmeDAO filmeDAO();
    public abstract GeneroDAO generoDAO();

    public static FilmeRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (FilmeRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),FilmeRoomDatabase.class,"filme_database").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
