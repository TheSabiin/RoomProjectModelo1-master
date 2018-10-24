package br.com.opet.tds.roomproject_modelo1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import br.com.opet.tds.roomproject_modelo1.R;
import br.com.opet.tds.roomproject_modelo1.adapter.GeneroAdapter;
import br.com.opet.tds.roomproject_modelo1.model.Filme;
import br.com.opet.tds.roomproject_modelo1.model.Genero;
import br.com.opet.tds.roomproject_modelo1.repository.FilmeRepository;
import br.com.opet.tds.roomproject_modelo1.repository.Repository;

public class AtualizarFilmeActivity extends Activity {
    private EditText editTitulo, editAno;
    private Spinner spinnerGenero;
    private RatingBar ratingFilme;
    private Repository repository;
    private Filme filme;
    private GeneroAdapter generoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_filme);

        long extra_id = getIntent().getLongExtra("ID",0);
        Toast.makeText(this, "ID = " + extra_id, Toast.LENGTH_SHORT).show();

        editTitulo = findViewById(R.id.editTitulo);
        editAno = findViewById(R.id.editAno);
        spinnerGenero = findViewById(R.id.spinnerGenero);
        ratingFilme = findViewById(R.id.ratingNotaFilme);
        repository = new Repository(getApplicationContext());
        loadFilme(extra_id);
        spinnerGenero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                filme.setGeneroId(((Genero)adapterView.getItemAtPosition(i)).getID());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void loadFilme(long extra_id) {
        filme = repository.getFilmeRepository().loadFilmeByID(extra_id);
        generoAdapter = new GeneroAdapter(this,android.R.layout.simple_spinner_item,repository.getGeneroRepository().getAllGeneros());
        spinnerGenero.setAdapter(generoAdapter);
        editAno.setText(String.valueOf(filme.getAno_producao()));
        editTitulo.setText(filme.getTitulo());
        List<Genero> generos = repository.getGeneroRepository().getAllGeneros();
        int counter = 0;
        for(Genero g : generos){
            if(filme.getGeneroId() == g.getID()){
                spinnerGenero.setSelection(counter);
                break;
            }
            counter++;
        }
        ratingFilme.setRating((float)filme.getAvaliacao());
    }

    public void atualizarFilme(View view){
        filme.setTitulo(editTitulo.getText().toString());
        filme.setAno_producao(Integer.parseInt(editAno.getText().toString()));
        filme.setAvaliacao((int)ratingFilme.getRating());
        repository.getFilmeRepository().update(filme);
        callMainActivity();
    }

    private void callMainActivity() {
        Intent mainActivity = new Intent(AtualizarFilmeActivity.this,MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
