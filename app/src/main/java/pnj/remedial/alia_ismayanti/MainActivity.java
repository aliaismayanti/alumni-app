package pnj.remedial.alia_ismayanti;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import pnj.remedial.alia_ismayanti.fragmen.BeritaFragment;
import pnj.remedial.alia_ismayanti.fragmen.HomeFragment;
import pnj.remedial.alia_ismayanti.fragmen.Profile;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
       BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        bottomNavigationView = findViewById(R.id.nav_view);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.navigation_berita:
                        fragment = new BeritaFragment();
                        break;
                    case R.id.navigation_profile:
                        fragment = new Profile();


                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.actiontambah) {
            Intent intent = new Intent(this, TambahmahasiswaActivity.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.actionlist) {

            Intent intent = new Intent(this, ListMahasiswaActivity.class);
            startActivity(intent);
        } else {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();

        }
        return true;
    }

}
