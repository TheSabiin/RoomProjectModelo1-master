package br.com.opet.tds.roomproject_modelo1.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Diego on 22/10/2018.
 */

@Entity(tableName = "genero_table")
public class Genero {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private long ID;
    private String nome;

    public Genero(){}

    public Genero(long ID, String nome) {
        this.ID = ID;
        this.nome = nome;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
