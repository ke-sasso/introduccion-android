package com.edu.sv.ejemplodbrealfirebase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.edu.sv.ejemplodbrealfirebase.datos.Persona;

public class AddPersonaActivity extends AppCompatActivity {
    EditText edtDUI, edtNombre, edtBirthday, edtGenre;
    String key="",nombre="",dui="",birthday="",genre="",accion="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_persona);
        inicializar();

    }

    private void inicializar() {
        edtNombre = findViewById(R.id.edtNombre);
        edtDUI = findViewById(R.id.edtDUI);

        edtBirthday = findViewById(R.id.edtBirthday);
        edtGenre = findViewById(R.id.edtGenre);


        // Obtención de datos que envia actividad anterior
        Bundle datos = getIntent().getExtras();
        key = datos.getString("key");
        dui = datos.getString("dui");
        nombre=datos.getString("nombre");

        birthday = datos.getString("birthday");
        genre = datos.getString("genre");

        accion=datos.getString("accion");
        edtDUI.setText(dui);
        edtNombre.setText(nombre);
        edtBirthday.setText(birthday);
        edtGenre.setText(genre);
    }

    public void guardar(View v){
        String nombre = edtNombre.getText().toString();
        String dui = edtDUI.getText().toString();
        String birthday = edtBirthday.getText().toString();
        String genre = edtGenre.getText().toString();

        // Se forma objeto persona
        Persona persona = new Persona(dui,nombre,birthday,genre);

        if (accion.equals("a")) { //Agregar usando push()
            PersonasActivity.refPersonas.push().setValue(persona);
        }
        else // Editar usando setValue
        {
            PersonasActivity.refPersonas.child(key).setValue(persona);
        }
        finish();
    }
    public void cancelar(View v){
        finish();
    }


}
