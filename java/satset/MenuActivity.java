package androidx.constraintlayout.widget.satset;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.FragmentMovie.MainFragment;
import androidx.constraintlayout.widget.Second.OneActivity;

public class MenuActivity extends AppCompatActivity {

    LinearLayout tombolSatu;
    LinearLayout tombolDua;
    LinearLayout tombolTiga;
    LinearLayout tombolEmpat;
    LinearLayout tombolLima;
    LinearLayout tombolEnam;
    LinearLayout tombolTujuh;
    LinearLayout tombolDelapan;
    LinearLayout tombolSembilan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        tombolSatu = findViewById(R.id.cdMenu1);
        tombolSatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, HelloActivity.class);
                startActivity(intent);
            }
        });

        tombolDua = findViewById(R.id.cdMenu2);
        tombolDua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        tombolTiga = findViewById(R.id.cdMenu3);
        tombolTiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        tombolEmpat = findViewById(R.id.cdMenu4);
        tombolEmpat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuActivity.this, ScrollingIcecold.class);
                startActivity(intent);
            }
        });

        tombolLima = findViewById(R.id.cdMenu5);
        tombolLima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setAlarm();

            }
        });

        tombolEnam = findViewById(R.id.cdMenu6);
        tombolEnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuActivity.this, FibonacciActivity.class);
                startActivity(intent);
            }
        });

        tombolTujuh = findViewById(R.id.cdMenu7);
        tombolTujuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuActivity.this, OneActivity.class);
                startActivity(intent);
            }
        });

        tombolDelapan = findViewById(R.id.cdMenu8);
        tombolDelapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuActivity.this, MainFragment.class);
                startActivity(intent);
            }
        });

        tombolSembilan = findViewById(R.id.cdMenu9);
        tombolSembilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, HelloActivity.class);
                startActivity(intent);
            }
        });
    }
        private void setAlarm() {
                Intent alarm = new Intent(android.provider.AlarmClock.ACTION_SET_ALARM);
                startActivity(alarm);
        }

}
