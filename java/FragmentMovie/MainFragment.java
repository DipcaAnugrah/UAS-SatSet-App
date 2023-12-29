package androidx.constraintlayout.widget.FragmentMovie;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.satset.MenuActivity;
import androidx.constraintlayout.widget.satset.R;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


// ... (existing imports)

public class MainFragment extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    // Hapus deklarasi BottomNavigationView di sini

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            // Initial fragment setup
            replaceFragment(new HomeFragment(), "HomeFragment");
            navigationView.setCheckedItem(R.id.nav_home);
        }

        // Hapus bottomNavigationView.setBackground(null);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home) {
                replaceFragment(new HomeFragment(), "HomeFragment");
            } else if (itemId == R.id.schedule) {
                replaceFragment(new ScheduleFragment(), "ScheduleFragment");
            } else if (itemId == R.id.history) {
                replaceFragment(new HistoryFragment(), "HistoryFragment");
            } else if (itemId == R.id.profil) {
                replaceFragment(new ProfilFragment(), "ProfilFragment");
            }

            drawerLayout.closeDrawers();
            return true;
        });

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void replaceFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frame_layout, fragment, tag);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.nav_home) {
            replaceFragment(new HomeFragment(), "HomeFragment");
        } else if (itemId == R.id.nav_settings) {
            replaceFragment(new SettingFragment(), "SettingFragment");
        } else if (itemId == R.id.nav_share) {
            replaceFragment(new ShareFragment(), "ShareFragment");
        } else if (itemId == R.id.nav_about) {
            replaceFragment(new AboutFragment(), "AboutFragment");
        }

        drawerLayout.closeDrawers();
        return true;
    }
}

