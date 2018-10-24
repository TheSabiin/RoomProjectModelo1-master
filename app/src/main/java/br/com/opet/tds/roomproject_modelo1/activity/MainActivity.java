package br.com.opet.tds.roomproject_modelo1.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.opet.tds.roomproject_modelo1.DAO.FilmeDAO;
import br.com.opet.tds.roomproject_modelo1.R;
import br.com.opet.tds.roomproject_modelo1.adapter.FilmeAdapter;
import br.com.opet.tds.roomproject_modelo1.model.Filme;
import br.com.opet.tds.roomproject_modelo1.repository.FilmeRepository;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener{

    private ListView listaFilmes;
    private FilmeRepository repository;
    ArrayAdapter<FilmeDAO.FilmeJoin> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaFilmes = findViewById(R.id.listaFilmes);
        repository = new FilmeRepository(getApplicationContext());
        atualizarFilmes();
        listaFilmes.setOnItemClickListener(this);
    }

    public void novoFilme(View view){
        Intent novoFilme = new Intent(MainActivity.this,NovoFilmeActivity.class);
        startActivity(novoFilme);
    }

    private void atualizarFilmes(){
        List<FilmeDAO.FilmeJoin> filmes = repository.getAllFilmesJoin();
        adapter = new FilmeAdapter(getApplicationContext(), R.layout.filme_item, filmes);
        listaFilmes.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final FilmeDAO.FilmeJoin filmeJoin = (FilmeDAO.FilmeJoin) adapterView.getItemAtPosition(i);
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("O que fazer com " + filmeJoin.filme.getTitulo()).setItems(R.array.opcoes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if(which == 0) {
                    repository.delete(filmeJoin.filme.getId());
                    atualizarFilmes();
                }
                else if(which == 1){
                    callActivity(filmeJoin.filme.getId());
                }

            }
        }).create().show();
    }

    private void callActivity(Long id) {
        Intent atualizar = new Intent(MainActivity.this,AtualizarFilmeActivity.class);
        atualizar.putExtra("ID",id);
        startActivity(atualizar);
    }

    public void novoGenero(View view) {
        Intent novoGenero = new Intent(MainActivity.this,NovoGeneroActivity.class);
        startActivity(novoGenero);
    }
}
