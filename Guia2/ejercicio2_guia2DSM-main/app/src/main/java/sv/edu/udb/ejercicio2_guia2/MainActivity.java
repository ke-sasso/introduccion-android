package sv.edu.udb.ejercicio2_guia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "sv.edu.udb.ejercicio2_guia2.EXTRA_NAME";
    public  static final  String EXTRA_HOURS = "sv.edu.udb.ejercicio2_guia2.EXTRA_HOURS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCal = (Button) findViewById(R.id.btnToActi2);
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
    }

    public void openActivity2(){
        EditText editText1 = (EditText)findViewById(R.id.TextPersonName);
        String name = editText1.getText().toString();

        EditText editText2 = (EditText)findViewById(R.id.NumberDecimal);
        float hours = Float.parseFloat(editText2.getText().toString());

        Intent intent = new Intent(this,SecondActivity2.class);
        intent.putExtra(EXTRA_NAME,name);
        intent.putExtra(EXTRA_HOURS,hours);
        startActivity(intent);
    }
}