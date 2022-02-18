package com.example.salarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {

    private TextView txtNombre;
    private TextView txtSalario;
    private TextView txtISSS;
    private TextView txtAFP;
    private TextView txtRenta;
    private TextView txtNeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtSalario = (TextView) findViewById(R.id.txtSalario);
        txtISSS = (TextView) findViewById(R.id.txtISSS);
        txtAFP = (TextView) findViewById(R.id.txtAFP);
        txtRenta = (TextView) findViewById(R.id.txtRenta);
        txtNeto = (TextView) findViewById(R.id.txtNeto);

        Bundle bundle = getIntent().getExtras();
        txtNombre.setText("Nombre: " + bundle.getString("Nombre"));
        txtSalario.setText("Salario: " + bundle.getDouble("Salario"));
        txtISSS.setText("ISSS 2%: " + bundle.getDouble("isss"));
        txtAFP.setText("AFP 3%: " + bundle.getDouble("afp"));
        txtRenta.setText("Renta 4%: " + bundle.getDouble("renta"));
        txtNeto.setText("Salario Neto: " + bundle.getDouble("neto"));

    }
}