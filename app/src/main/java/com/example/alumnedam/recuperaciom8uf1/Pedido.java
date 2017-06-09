package com.example.alumnedam.recuperaciom8uf1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Pedido extends AppCompatActivity {
//    SharedPreferences sharedPreferences = getSharedPreferences("misPreferencias",MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        DBHelper dbHelper = new DBHelper(this,DBHelper.DATABASE_NOMBRE,null,DBHelper.DATABASE_VERSION);
        dbHelper.obtener(Integer.parseInt(i.getStringExtra("client")));
        setContentView(R.layout.activity_pedido);

        int cerveses = i.getIntExtra("cerveses", 0);
        int hamburgueses = i.getIntExtra("hamburgueses", 0);
        int entrepans = i.getIntExtra("entrepansConsumits", 0);
        System.out.println("TIENES " + cerveses + " cervezas");
        if (cerveses == 11) {
            Toast.makeText(this, "HAS GANADO UNA CERVEZA GRATIS", Toast.LENGTH_LONG);
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(50);
        } else if (hamburgueses == 11) {
            Toast.makeText(this, "HAS GANADO UNA HAMBURGUESA GRATIS", Toast.LENGTH_LONG);
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(50);
        } else if (entrepans == 11) {
            Toast.makeText(this, "HAS GANADO UN BOCADILLO GRATIS", Toast.LENGTH_LONG);
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(50);
        } else {
            Toast.makeText(this, "todavia no has consumido suficientes productos", Toast.LENGTH_SHORT);
        }
    }
}
