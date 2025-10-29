package com.example.venegas_calculadorahexadecimales;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText txtValor;
    TextView txtRespuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtValor = findViewById(R.id.txtValor);
        txtRespuesta = findViewById(R.id.txtRespuesta);
    }
    public void btnConvertirADecimal_onClick(View v){
        String valor = txtValor.getText().toString();
        if (valor.isEmpty()){
            Toast.makeText(this, "Ingrese un numero hexadecimal", Toast.LENGTH_SHORT).show();
            txtRespuesta.setText("");
            return;
        }
        try {
            int decimal = Integer.parseInt(valor, 16);
            txtRespuesta.setText(String.valueOf(decimal));
        } catch (NumberFormatException e){
            Toast.makeText(this, "Ingrese solo caracteres hexadecimales", Toast.LENGTH_SHORT).show();
            txtRespuesta.setText("");
        }
    }

    public void btnConvertirAHexa_onclick(View v){
        String valor = txtValor.getText().toString();
        if (valor.isEmpty()){
            Toast.makeText(this, "Ingrese un numero decimal", Toast.LENGTH_SHORT).show();
            txtRespuesta.setText("");
            return;
        }
        try {
            int decimal = Integer.parseInt(valor);
            String hexadecimal = Integer.toHexString(decimal);
            txtRespuesta.setText(hexadecimal.toUpperCase());
        } catch (NumberFormatException e){
            Toast.makeText(this, "Ingrese solo numeros enteros decimales", Toast.LENGTH_SHORT).show();
            txtRespuesta.setText("");
        }
    }
}