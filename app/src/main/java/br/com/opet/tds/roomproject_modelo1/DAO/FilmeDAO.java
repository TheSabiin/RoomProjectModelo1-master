package br.com.opet.tds.roomproject_modelo1.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.opet.tds.roomproject_modelo1.model.Filme;
import br.com.opet.tds.roomproject_modelo1.model.Genero;

/**
 * Created by Diego on 24/09/2018.
 */

@Dao
public interface FilmeDAO {

    @Insert
    void insert(Filme filme);

    @Update
    void update(Filme filme);

    @Query("SELECT * FROM filme_table WHERE filme_table.ID == :id")
    Filme loadFilmeByID(Long id);

    @Query("DELETE FROM filme_table where filme_table.ID == :id")
    void delete(long id);

    @Query("SELECT * from filme_table ORDER BY avaliacao DESC")
    List<Filme> loadFilmes();

    @Query("SELECT filme_table.ID,filme_table.titulo,filme_table.ano_producao,filme_table.avaliacao, genero_table.ID as genero_ID ,genero_table.nome as genero_nome from filme_table" +
            " INNER JOIN genero_table ON filme_table.genero_id = genero_table.ID ORDER BY avaliacao DESC")
    List<FilmeJoin> loadFilmesJoin();

    @Query("SELECT titulo from filme_table")
    List<String> loadFilmesNames();

    static class FilmeJoin{
        @Embedded
        public Filme filme;
        @Embedded(prefix = "genero_")
        public Genero genero;
    }
}
