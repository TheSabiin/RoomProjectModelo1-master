package br.com.opet.tds.roomproject_modelo1.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import br.com.opet.tds.roomproject_modelo1.DAO.GeneroDAO;
import br.com.opet.tds.roomproject_modelo1.R;
import br.com.opet.tds.roomproject_modelo1.adapter.GeneroAdapter;
import br.com.opet.tds.roomproject_modelo1.model.Genero;
import br.com.opet.tds.roomproject_modelo1.repository.Repository;

public class AtualizarGeneroActivity extends Activity {

    private EditText editGenero;
    private Spinner spinnerGenero;
    private Repository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_genero);

        long extra_id = getIntent().getLongExtra("ID", 0);
        Toast.makeText(this, "ID = " + extra_id, Toast.LENGTH_SHORT).show();

        spinnerGenero = findViewById(R.id.spinnerGenero);
        loadFilme(extra_id);
        repository = new Repository(getApplicationContext());
        spinnerGenero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editGenero.setText(((Genero) adapterView.getItemAtPosition(i)).getNome());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void loadFilme(long extra_id) {
        Genero = repository.getGeneroRepository().loadGeneroByID(extra_id);
        GeneroAdapter generoAdapter = new GeneroAdapter(this, android.R.layout.simple_spinner_item, repository.getGeneroRepository().getAllGeneros());
        spinnerGenero.setAdapter(generoAdapter);
        EditText.setText(String.valueOf(generoAdapter.getContext()));
        List<Genero> generos = repository.getGeneroRepository().getAllGeneros();
        int counter = 0;
        for (Genero g : generos) {
            if (g.getID() == generos.add) {
                spinnerGenero.setSelection(counter);
                break;
            }
        }
        counter++;
    }

}
