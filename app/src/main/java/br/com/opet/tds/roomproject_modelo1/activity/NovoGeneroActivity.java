package br.com.opet.tds.roomproject_modelo1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.opet.tds.roomproject_modelo1.R;
import br.com.opet.tds.roomproject_modelo1.model.Filme;
import br.com.opet.tds.roomproject_modelo1.model.Genero;
import br.com.opet.tds.roomproject_modelo1.repository.Repository;

public class NovoGeneroActivity extends Activity {

    private EditText editTitulo;
    private Repository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_genero);

        editTitulo = findViewById(R.id.editGenero);
        repository = new Repository(getApplicationContext());
    }

    public void salvarGenero(View view){
        Genero genero = new Genero();
        genero.setNome(editTitulo.getText().toString());

        repository.getGeneroRepository().insert(genero);
        callMainActivity();
    }

    private void callMainActivity() {
        Intent mainActivity = new Intent(NovoGeneroActivity.this,MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
