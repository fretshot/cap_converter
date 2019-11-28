package com.infamous_software.calculadora_de_capacitores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText input1, input2;
    TextView res1, res2;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        res1 = findViewById(R.id.res1);
        button1 = findViewById(R.id.button1);

        input2 = findViewById(R.id.input2);
        res2 = findViewById(R.id.res2);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input1.getText().toString().trim().length() > 0){
                    if(input1.getText().toString().trim().length() > 2){
                        String entrada = input1.getText().toString();
                        String respuesta = codigoToValor(entrada);
                        res1.setText(respuesta);
                    }else{
                        Toast.makeText(getApplicationContext(), "Por favor ingrese un valor de 3 dígitos", Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Por favor ingrese un valor", Toast.LENGTH_LONG).show();
                }

            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input2.getText().toString().trim().length() > 0){
                    if(input2.getText().toString().trim().length() > 2){
                        String entrada = input2.getText().toString();
                        String respuesta = ValorToCodigo(entrada);
                        res2.setText(respuesta);
                    }else{
                        Toast.makeText(getApplicationContext(), "Por favor ingrese un valor de 3 dígitos", Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Por favor ingrese un valor", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.help) {
            Toast.makeText(getApplicationContext(), "MADE BY OSCAR", Toast.LENGTH_LONG).show();
            return  true;
        }


        return super.onOptionsItemSelected(item);
    }

    public String codigoToValor(String value){

        char[] array = value.toCharArray();

        String result;

        String n1 = String.valueOf(array[0]);
        String n2 = String.valueOf(array[1]);

        String n3 = String.valueOf(array[2]);

        StringBuilder ceros = new StringBuilder();

        for(int i = 0; i < Integer.parseInt(n3); i++ ){
            ceros.append("0");
        }

        result = n1+n2+ceros;

        return result + "pF";

    }

    public String ValorToCodigo(String value){

        // 1. Contar los 0s del string
        // 2. Eliminar los 0s del string
        // 3. Retornar el string sin los 0s concatenando la cantidad numerica de 0s detectados

        char[] array = value.toCharArray();

        int count = 0;

        for(int i = 0; i < array.length; i++){
            if(String.valueOf(array[i]).contains("0")){
                count = count +1;
            }
        }

        String sinCeros = value.replace("0","");

        return sinCeros + count + "pF";

    }
}
