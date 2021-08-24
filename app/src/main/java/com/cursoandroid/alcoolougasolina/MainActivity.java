package com.cursoandroid.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText precoAlcool1;
    public EditText precoGasolina1;
    public TextView textResultadoGas;
    public TextView textResultadoAlc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool1 = findViewById(R.id.precoAlcool);
        precoGasolina1 = findViewById(R.id.precoGasolina);
        textResultadoGas = findViewById(R.id.resultadoGasolina);
        textResultadoAlc = findViewById(R.id.resultadoAlcool);

    }

    public void calcularPreco (View view) {

        //recuperar valores digitados
        String precoAlcool2 = precoAlcool1.getText().toString();
        String precoGasolina2 = precoGasolina1.getText().toString();

        //Validar os campos digitados
        Boolean camposValidados = validarCampos(precoAlcool2, precoGasolina2);
        if (camposValidados) {

            //Convertendo string para números
            Double valorAlcool = Double.parseDouble(precoAlcool2);
            Double valorGasolina = Double.parseDouble(precoGasolina2);

            /* Fazer Cálculo de menor preço
             * Se (valorAlcool / valorGasolina) >= 0.7 é melhor utilizar gasolina
             * senão é melhor utilizar álcool
             */
            Double resultado = valorAlcool / valorGasolina;

            if (resultado >= 0.7) {
                textResultadoGas.setVisibility(View.VISIBLE);
                textResultadoAlc.setVisibility(View.GONE);
                textResultadoGas.setText("Melhor utilizar gasolina");
            } else {
                textResultadoGas.setVisibility(View.GONE);
                textResultadoAlc.setVisibility(View.VISIBLE);
                textResultadoAlc.setText("Melhor utilizar álcool");
            }


        } else {

            textResultadoAlc.setText("Preencha os preços primeiro!");
        }

    }

        public Boolean validarCampos (String pAlcool, String pGasolina) {

            Boolean camposValidados = true;

            if (pAlcool == null || pAlcool.equals("")) {

                camposValidados = false;

            } else if (pGasolina == null || pGasolina.equals("")) {
                camposValidados = false;

            }


            return camposValidados;

        }
    }