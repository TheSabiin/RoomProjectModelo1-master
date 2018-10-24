package br.com.opet.tds.roomproject_modelo1.repository;

import android.content.Context;

/**
 * Created by Diego on 22/10/2018.
 */

public class Repository {
    private FilmeRepository filmeRepository;
    private GeneroRepository generoRepository;

    public Repository(Context context){
        filmeRepository = new FilmeRepository(context);
        generoRepository = new GeneroRepository(context);
    }

    public FilmeRepository getFilmeRepository() {
        return filmeRepository;
    }

    public GeneroRepository getGeneroRepository() {
        return generoRepository;
    }
}
