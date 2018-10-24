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

import br.com.opet.tds.roomproject_modelo1.R;
import br.com.opet.tds.roomproject_modelo1.adapter.GeneroAdapter;
import br.com.opet.tds.roomproject_modelo1.model.Filme;
import br.com.opet.tds.roomproject_modelo1.model.Genero;
import br.com.opet.tds.roomproject_modelo1.repository.FilmeRepository;
import br.com.opet.tds.roomproject_modelo1.repository.Repository;

public class NovoFilmeActivity extends Activity {

    private EditText editTitulo, editAno;
    private Spinner spinnerGenero;
    private RatingBar ratingFilme;
    private Repository repository;
    private Filme filme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_filme);

        editTitulo = findViewById(R.id.editTitulo);
        editAno = findViewById(R.id.editAno);
        spinnerGenero = findViewById(R.id.spinnerGenero);
        ratingFilme = findViewById(R.id.ratingNotaFilme);
        repository = new Repository(getApplicationContext());
        filme = new Filme();
        loadGeneros();
    }

    private void loadGeneros() {
        final GeneroAdapter adapter = new GeneroAdapter(this,android.R.layout.simple_spinner_item,repository.getGeneroRepository().getAllGeneros());
        spinnerGenero.setAdapter(adapter);
        spinnerGenero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Genero genero = (Genero) adapterView.getItemAtPosition(i);
                filme.setGeneroId(genero.getID());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void salvarFilme(View view){
        //Toast.makeText(this, ""+filme.getGeneroId(), Toast.LENGTH_SHORT).show();
        //Filme filme = new Filme();
        filme.setTitulo(editTitulo.getText().toString());
        filme.setAno_producao(Integer.parseInt(editAno.getText().toString()));
        filme.setAvaliacao((int)ratingFilme.getRating());
        repository.getFilmeRepository().insert(filme);
        callMainActivity();
    }

    private void callMainActivity() {
        Intent mainActivity = new Intent(NovoFilmeActivity.this,MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
