package br.com.opet.tds.roomproject_modelo1.repository;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import br.com.opet.tds.roomproject_modelo1.DAO.GeneroDAO;
import br.com.opet.tds.roomproject_modelo1.database.FilmeRoomDatabase;
import br.com.opet.tds.roomproject_modelo1.model.Genero;

/**
 * Created by Diego on 22/10/2018.
 */

public class GeneroRepository {
    private GeneroDAO mGeneroDAO;
    private List<Genero> mGeneros;

    public GeneroRepository(Context context){
        FilmeRoomDatabase db = FilmeRoomDatabase.getDatabase(context);
        mGeneroDAO = db.generoDAO();
    }

    public List<Genero> getAllGeneros(){
        mGeneros = mGeneroDAO.loadGeneros();
        return mGeneros;
    }

    /*public Genero loadGeneroByID(long ID) {
        return mGeneroDAO.loadGeneroByID(ID);
    }*/

    public void insert(Genero genero){
        mGeneroDAO.insert(genero);
    }
    public void update(Genero genero) {mGeneroDAO.update(genero);}
}
