package com.example.alumnedam.recuperaciom8uf1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button seguent, afegirCervesaButton, afegirHamburguesaButton, afegirEntrepaButton;
    private SharedPreferences sharedPreferences;
    int cervesesConsumides, hamburguesesConsumides, entrepansConsumits;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //EditText (clienteID)
        final EditText idClienteEditText = (EditText) findViewById(R.id.editTextIDCliente);
        //BOTONES
        seguent = (Button) findViewById(R.id.buttonSeguent);
        afegirCervesaButton = (Button) findViewById(R.id.btnAfegirCervesa);
        afegirHamburguesaButton = (Button) findViewById(R.id.btnAfegirHamburguesa);
        afegirEntrepaButton = (Button) findViewById(R.id.btnAfegirEntrepa);
        //INTENT
        final Intent intent = new Intent(this, Pedido.class);
        //(PERSISTENCIA) SQLLite
        dbHelper = new DBHelper(this,DBHelper.DATABASE_NOMBRE,null,DBHelper.DATABASE_VERSION);
        dbHelper.onCreate(dbHelper.getWritableDatabase());
//        sharedPreferences = getSharedPreferences("misPreferencias", MODE_PRIVATE);
//        final SharedPreferences.Editor editor = sharedPreferences.edit();

        seguent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("cerveses", cervesesConsumides);
                intent.putExtra("hamburgueses", hamburguesesConsumides);
                intent.putExtra("entrepansConsumits", entrepansConsumits);
                intent.putExtra("client",String.valueOf(idClienteEditText.getText()));
//                editor.putString("IDCliente", String.valueOf(idClienteEditText.getText()));
//                editor.commit();
                dbHelper.agregar(String.valueOf(cervesesConsumides),String.valueOf(hamburguesesConsumides),String.valueOf(entrepansConsumits));
                startActivity(intent);
            }
        });
        afegirCervesaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cervesesConsumides++;
            }
        });
        afegirHamburguesaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hamburguesesConsumides++;
            }
        });
        afegirEntrepaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrepansConsumits++;
            }
        });
    }
}
