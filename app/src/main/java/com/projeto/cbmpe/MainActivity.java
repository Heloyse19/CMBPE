package com.projeto.cbmpe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private EditText editTextGrupo;
    private EditText editTextCodigoOc;
    private RadioGroup radioGroupAssociacaoDesastre;
    private EditText editTextCodigoDesastre;
    private CheckBox checkBoxEvPessoas;
    private CheckBox checkBoxEvanimal;
    private CheckBox checkBoxEvCadaver;
    private CheckBox checkBoxEvObjeto;
    private CheckBox checkBoxEvMeioTransporte;
    private CheckBox checkBoxEvArvore;
    private EditText editOutrosDesastres;
    private EditText editNumeroVitimas;
    private Button buttonEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGrupo = findViewById(R.id.editGrupo);

        editTextCodigoOc = findViewById(R.id.editCodigoOcorrencia);

        radioGroupAssociacaoDesastre = findViewById(R.id.radioGroupAssociacaoDesastre);

        editTextCodigoDesastre = findViewById(R.id.editCodigoDesastre);

        buttonEnviar = findViewById(R.id.buttonEnviar);

        checkBoxEvPessoas = findViewById(R.id.checkBoxEvPessoas);

        checkBoxEvanimal = findViewById(R.id.checkBoxEvanimal);

        checkBoxEvCadaver = findViewById(R.id.checkBoxEvCadaver);

        checkBoxEvObjeto = findViewById(R.id.checkBoxEvObjeto);

        checkBoxEvMeioTransporte = findViewById(R.id.checkBoxEvMeioTransporte);

        checkBoxEvArvore = findViewById(R.id.checkBoxEvArvore);

        editOutrosDesastres = findViewById(R.id.editOutrosDesastres);

        editNumeroVitimas = findViewById(R.id.editNumeroVitimas);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lerDadosDoFormulario();
            }
        });
    }

    private void lerDadosDoFormulario() {
        String grupo = editTextGrupo.getText().toString().trim();
        String codigoOc = editTextCodigoOc.getText().toString().trim();
        String codigoDesastre = editTextCodigoDesastre.getText().toString().trim();
        String outrosD = editOutrosDesastres.getText().toString().trim();
        String nVitimas = editNumeroVitimas.getText().toString().trim();


        int idDoRadioButtonSelecionado = radioGroupAssociacaoDesastre.getCheckedRadioButtonId();
        boolean associadoD = false;

        if (idDoRadioButtonSelecionado == R.id.radioAssociacaoDesastreSim) {
            associadoD = true;
        }

        boolean evPessoas = checkBoxEvPessoas.isChecked();
        boolean evAnimal = checkBoxEvanimal.isChecked();
        boolean evCadaver = checkBoxEvCadaver.isChecked();
        boolean evObjeto = checkBoxEvObjeto.isChecked();
        boolean evMeioTransporte = checkBoxEvMeioTransporte.isChecked();
        boolean evArvore = checkBoxEvArvore.isChecked();

        StringBuilder eventosSelecionados = new StringBuilder();

        if (evPessoas) eventosSelecionados.append("Pessoas, ");
        if (evAnimal) eventosSelecionados.append("Animal, ");
        if (evCadaver) eventosSelecionados.append("Cadáver, ");
        if (evObjeto) eventosSelecionados.append("Objeto, ");
        if (evMeioTransporte) eventosSelecionados.append("Meio de Transporte, ");
        if (evArvore) eventosSelecionados.append("Árvore, ");

        String selecoesFinais = eventosSelecionados.toString().trim();
        if (selecoesFinais.endsWith(",")) {
            selecoesFinais = selecoesFinais.substring(0, selecoesFinais.length() - 1);
        }


        if (grupo.isEmpty() || codigoOc.isEmpty()) {
            if (grupo.isEmpty()) {
                editTextGrupo.setError("O campo Grupo é obrigatório!");
            }
            if (codigoOc.isEmpty()) {
                editTextCodigoOc.setError("O campo Código é obrigatório!");
            }
        } else {
            Log.i("FORMULARIO_SUCESSO", "Dados prontos para envio!");
        }
    }
}