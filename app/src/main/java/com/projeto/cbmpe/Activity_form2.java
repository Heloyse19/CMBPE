package com.projeto.cbmpe;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_form2 extends AppCompatActivity {
    private Button buttonEnviar;
    private Spinner spinnerLocalMergulho;
    private CheckBox checkBoxANormal;

    private CheckBox checkBoxPoluido;

    private CheckBox checkBoxInospido;
    private CheckBox checkBoxVTurva;

    private CheckBox checkBoxVParcial;

    private CheckBox checkBoxVOutro;

    private CheckBox checkBoxVTotal;

    private CheckBox checkBoxFCascalho;

    private CheckBox checkBoxFAreia;

    private  CheckBox checkBoxFPedra;

    private  CheckBox checkBoxFOutros;

    private RadioGroup radioGroupCorrenteza;
    private EditText editCoordenadasLot;
    private EditText editCoordenadasLong;

    private EditText editNMergulhadores;

    private Button buttonVoltar;

    private void voltarParaTelaPrincipal() {
        finish();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);

        spinnerLocalMergulho = findViewById(R.id.spinnerLocalMergulho);
        buttonEnviar = findViewById(R.id.buttonEnviar);
        radioGroupCorrenteza = findViewById(R.id.radioGroupCorrenteza);
        editCoordenadasLot = findViewById(R.id.editCoordenadasLot);
        editCoordenadasLong = findViewById(R.id.editCoordenadasLong);
        editNMergulhadores = findViewById(R.id.editNMergulhadores);
        buttonVoltar = findViewById(R.id.buttonVoltar);


        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lerDadosDoFormulario();
            }
        });

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarParaTelaPrincipal();
            }
        });

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lerDadosDoFormulario();
            }
        });
    }

    private void lerDadosDoFormulario() {
        String localMergulhoSelect = spinnerLocalMergulho.getSelectedItem().toString();

        if (localMergulhoSelect.equals("Selecione uma Opção")) {
            // Se o usuário não escolheu nada, mostre um erro ou aviso.
            Log.e("FORMULARIO2_ERRO", "Por favor, selecione um tipo de localidade.");
        } else {
            // Lógica para enviar o formulário
            Log.i("FORMULARIO2_SUCESSO", "Localidade [" + localMergulhoSelect + "] capturada.");
        }

    }
}
