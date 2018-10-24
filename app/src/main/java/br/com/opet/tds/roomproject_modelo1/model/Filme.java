package br.com.opet.tds.roomproject_modelo1.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Diego on 24/09/2018.
 */
@Entity(tableName = "filme_table",
        foreignKeys = @ForeignKey(entity = Genero.class,
                                parentColumns = "ID",
                                childColumns = "genero_id"))
public class Filme {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private long id;
    private String titulo;
    private int ano_producao;
    private int avaliacao;

    @ColumnInfo(name = "genero_id")
    private long generoId;

    public Filme() {
    }

    public Filme(long id, String titulo, int ano_producao, int avaliacao) {
        this.id = id;
        this.titulo = titulo;
        this.ano_producao = ano_producao;
        this.avaliacao = avaliacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno_producao() {
        return ano_producao;
    }

    public void setAno_producao(int ano_producao) {
        this.ano_producao = ano_producao;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public long getGeneroId() {
        return generoId;
    }

    public void setGeneroId(long generoId) {
        this.generoId = generoId;
    }
}
