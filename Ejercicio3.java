package pe.edu.unc.evalgonzalesraicofranky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio3 extends AppCompatActivity {

    EditText etxPalabras, etxNIntentos;
    Button btnJugar;
    public static ArrayList<String> listPalabras = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ly_ejercicio3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etxPalabras = findViewById(R.id.etxPalabra);
        etxNIntentos = findViewById(R.id.etxNIntentos);
        btnJugar = findViewById(R.id.btnJugar);
        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                juego();
                listPalabras = new ArrayList<>(Arrays.asList(etxPalabras.getText().toString().split(",")));

            }
        });
    }

    private void juego() {
        Intent oIntent = new Intent(Ejercicio3.this, Juego.class);
        startActivity(oIntent);
    }
}