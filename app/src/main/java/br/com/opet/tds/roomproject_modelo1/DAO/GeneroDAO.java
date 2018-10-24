package br.com.opet.tds.roomproject_modelo1.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.opet.tds.roomproject_modelo1.model.Filme;
import br.com.opet.tds.roomproject_modelo1.model.Genero;

/**
 * Created by Diego on 22/10/2018.
 */

@Dao
public interface GeneroDAO {
    @Insert
    void insert(Genero genero);

    @Update
    void update(Genero genero);

    @Query("SELECT * from genero_table ORDER BY nome DESC")
    List<Genero> loadGeneros();
}
