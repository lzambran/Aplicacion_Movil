package facci.luiszambrano.aplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button btnConvert;
    TextView result;
    EditText input;
    Double inputNumber;
    RadioButton centigrado, fahrenheit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w("MainActivity", "Luis Antonio Zambrano Demera");

        btnConvert = (Button) findViewById(R.id.btnConvert);
        result = (TextView) findViewById(R.id.result);
        input = (EditText) findViewById(R.id.input);

        centigrado = (RadioButton) findViewById(R.id.centigrado);
        fahrenheit = (RadioButton) findViewById(R.id.fahrenheit);

        btnConvert.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = input.getText().toString();

                if (inputText.isEmpty()) {
                    result.setText("Ingrese una Cantidad.");
                } else {
                    inputNumber = Double.parseDouble(inputText);

                    if (inputNumber <= 0) {
                        result.setText("Recomendable ingresar una cantidad mayor a 0.");
                    } else {
                        if (centigrado.isChecked() || fahrenheit.isChecked()) {
                            if (centigrado.isChecked()) {
                                Double r = (inputNumber -32) * 5/9 ;
                                result.setText(String.valueOf(r) + " C");
                            } else {
                                Double r = (inputNumber * 9/5)+ 32 ;
                                result.setText(String.valueOf(r) + " F");
                            }
                        } else {
                            result.setText("Seleccione un Convertidor");
                        }
                    }
                }
            }
        });



    }
}