package sv.edu.udb.ejercicio2_guia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        Float hours = intent.getFloatExtra(MainActivity.EXTRA_HOURS,0);

        double rawPay = 8.50*hours;
        double payment = rawPay - (rawPay*0.02 + rawPay*0.03 + rawPay*0.04);

        TextView viewName = (TextView) findViewById(R.id.textView1);
        TextView viewPayment = (TextView) findViewById(R.id.textView2);

        viewName.setText(name);
        viewPayment.setText("$" + payment);
    }
}