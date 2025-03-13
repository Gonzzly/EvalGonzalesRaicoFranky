package pe.edu.unc.evalgonzalesraicofranky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvListEje;
    String [] lista = {"Ejercicio 3","Ejercicio 4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lvListEje = findViewById(R.id.lvListaEjer);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,lista);
        lvListEje.setAdapter(adapter);
        lvListEje.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent oInten;
                switch (lista[position]){
                    case "Ejercicio 3":
                        oInten = new Intent(MainActivity.this, Ejercicio3.class);
                        break;
                    case "Ejercicio 4":
                        oInten = new Intent(MainActivity.this, Ejercicio4.class);
                        break;
                    default:
                        return;
                }
                startActivity(oInten);
            }
        });
    }
}