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
    private Button fahrenheitCelsiusButton;
    private TextView saidaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entradaEditText = findViewById(R.id.edittext_fahrenheit);
        saidaTextView = findViewById(R.id.textview_saida);
        fahrenheitCelsiusButton = findViewById(R.id.button_converter);

        fahrenheitCelsiusButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == fahrenheitCelsiusButton){
            convCelsius();
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
}
