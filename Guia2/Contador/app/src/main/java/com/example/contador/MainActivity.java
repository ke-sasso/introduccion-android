package com.example.contador;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextView txtNum;
    private ClassViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum = (TextView) findViewById(R.id.txtNum);

        model = new ViewModelProvider(this).get(ClassViewModel.class);

        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                txtNum.setText(newName);
            }
        };
        model.getCurrentName().observe(this, nameObserver);
    }

    public void sumar(View view){
        int num = Integer.parseInt(txtNum.getText().toString());
        if (num<9){
            int suma = num + 1;
            txtNum.setText(""+suma);
        }
        else {
            txtNum.setText("0");
        }
        model.getCurrentName().setValue(txtNum.getText().toString());
    }
}