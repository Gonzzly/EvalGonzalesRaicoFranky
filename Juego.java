package pe.edu.unc.evalgonzalesraicofranky;

import static pe.edu.unc.evalgonzalesraicofranky.Ejercicio3.listPalabras;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Juego extends AppCompatActivity {

    TextView tvPalJuego;
    String palabraJuego;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ly_activity_juego);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvPalJuego = findViewById(R.id.tvPAdivinar);
        palabraJuego= listPalabras.get((int)(Math.random()*listPalabras.size())+1);
        Toast.makeText(this, ""+palabraJuego, Toast.LENGTH_SHORT).show();

        char [] cPalabra ={};
        String palabraMostra="";
        for (int i=0; i<palabraJuego.length();i++){
             cPalabra [i]= palabraJuego.charAt(i);
             if (siNo(cPalabra.length)){
                 palabraMostra += cPalabra[i];
             }else
                 palabraMostra+="_";
        }
        tvPalJuego.setText(palabraJuego);
    }

    private boolean siNo(int i) {
        i=(int)(i/2);
        int contador = 0;
        int bol= (int)(Math.random()*2+1);
        if (bol ==1 && contador<i ) {
            contador++;
            return true;
        }
        return false;
    }
}