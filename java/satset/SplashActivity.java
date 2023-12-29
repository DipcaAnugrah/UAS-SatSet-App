package androidx.constraintlayout.widget.satset;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 3000; // Waktu penundaan dalam milidetik (contoh: 3000 ms atau 3 detik)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // inisialisasi view
        View decorView = getWindow().getDecorView();
        // hide the status bar
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        // Pindah ke MenuActivity setelah penundaan
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MenuActivity.class);
                startActivity(intent);
                finish(); // Optional: sebaiknya ditambahkan untuk menutup SplashActivity setelah membuka MenuActivity
            }
        }, SPLASH_DELAY);
    }
}
