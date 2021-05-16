package com.example.postobon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText cajahoras;
    TextView cajaresultado;
    Button botonCalcular;
    Trabajador trabajador;

    ImageView fotoEmpleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajahoras = findViewById(R.id.numeroHoras);
        cajaresultado = findViewById(R.id.resultado);
        botonCalcular = findViewById(R.id.calcular);
        fotoEmpleado = findViewById(R.id.imageView);

        //3.enlazar el atributo trabajador con los datos que llegan del adaptador
        trabajador = (Trabajador) getIntent().getSerializableExtra("datosTrabajador");

        //4.utilizar los datos del trabajador para cargar los recursos
        fotoEmpleado.setImageResource(trabajador.getFotoTrabajador());

        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int horasDigitadas = Integer.parseInt(cajahoras.getText().toString());

               if (horasDigitadas <= 40){
                   int salario = horasDigitadas * 20000;
                   cajaresultado.setText("Su salario fue de: " + salario);
               }else {
                   int salarioBase = 800000;
                   int numeroHorasExtra = horasDigitadas-40;
                   int salario = salarioBase + (numeroHorasExtra * 25000);
                   cajaresultado.setText("Su salario es de: " + salario);
                }
            }
        });
    }
}