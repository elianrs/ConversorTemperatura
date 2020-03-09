package br.edu.ifsp.arq.dmos5_2020s1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText entradaEditText;
    private Button fahrenheitButton;
    private Button celsiusButton;
    private TextView saidaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entradaEditText = findViewById(R.id.edittext_temperatura);
        saidaTextView = findViewById(R.id.textview_saida);
        fahrenheitButton = findViewById(R.id.button_fahrenheit);
        celsiusButton = findViewById(R.id.button_celsius);

        fahrenheitButton.setOnClickListener(this);
        celsiusButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == celsiusButton){
            convCelsius();
        }
        if(v == fahrenheitButton){
            convFahrenheit();
        }
    }

    private double getEntrada() throws NumberFormatException{
        double entrada;
        try{
            entrada = Double.valueOf(entradaEditText.getText().toString());
        }catch (NumberFormatException ex){
            entrada = 0;
            throw ex;
        }
        return entrada;
    }

    private void convCelsius(){
        double valor;

        try{
            valor = getEntrada();
            valor = (valor - 32) /1.8;
        }catch (NumberFormatException ex){
            Toast.makeText(this, "Entrada inválida!", Toast.LENGTH_SHORT).show();
            valor = 0;
        }

        saidaTextView.setText(String.format("%.2f °C", valor));
    }

    private void convFahrenheit(){
        double valor;

        try{
            valor = getEntrada();
            valor = 1.8 * valor + 32;
        }catch (NumberFormatException ex){
            Toast.makeText(this, "Entrada inválida!", Toast.LENGTH_SHORT).show();
            valor = 0;
        }

        saidaTextView.setText(String.format("%.2f °F", valor));
    }
}