package com.example.postobon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Locale;

public class Home extends AppCompatActivity {

    //atributos
    ArrayList<Trabajador>listadeTrabajadores = new ArrayList<>();
    RecyclerView listadoGrafico;

    //metodos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listadoGrafico = findViewById(R.id.listado);
        listadoGrafico.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        crearLista();
        ListaAdapatador adapatador = new ListaAdapatador(listadeTrabajadores);
        listadoGrafico.setAdapter(adapatador);

    }

    //configuracon cambiar idioma

    public void cambiarIdioma (String lenguaje) {
        Locale idioma = new Locale(lenguaje); //tipo de datos que recibe el lenguaje a configurar en el telefono
        Locale.setDefault(idioma); //se establece el lenguaje del telefono

        Configuration configuracionTelefono = getResources().getConfiguration();
        configuracionTelefono.locale = idioma;
        getBaseContext().getResources().updateConfiguration(configuracionTelefono,getBaseContext().getResources().getDisplayMetrics());
    }

    //Metodo encagardado de pintar el menu de opciones

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    //Metodo para controlar la accion del menu
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();

        switch (id) {
            case (R.id.opcion1):
                Intent intent1 = new Intent(Home.this,Acercade.class);
                startActivity(intent1);
                break;

            case (R.id.opcion2):
                cambiarIdioma("en");
                Intent intent2 = new Intent(Home.this,Home.class);
                startActivity(intent2);
                break;

            case (R.id.opcion3):
                cambiarIdioma("es");
                Intent intent3 = new Intent(Home.this,Home.class);
                startActivity(intent3);

                break;
        }
        return  super.onOptionsItemSelected(item);
    }

    private  void crearLista (){
        listadeTrabajadores.add(new Trabajador("Sandra Perez", R.drawable.avatar1));
        listadeTrabajadores.add(new Trabajador("Raul Motoa", R.drawable.avatar2));
        listadeTrabajadores.add(new Trabajador("Martha Nielsen", R.drawable.avatar3));
        listadeTrabajadores.add(new Trabajador("Byron Mosquera", R.drawable.avatar4));

    }
}