package sv.edu.udb.ejercicio1_guia2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;
    private TextView textV;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(new MyLifeCycleObserver(this));
        setContentView(R.layout.activity_main);
        textV =(TextView) findViewById(R.id.textView);
        btn =(Button) findViewById(R.id.btnAdd);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                if(counter == 10){
                    counter = 0;
                }
                textV.setText(Integer.toString(counter));
            }
        });
    }


}