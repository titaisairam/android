 import androidx.annotation.NonNull;
    import androidx.appcompat.app.ActionBarDrawerToggle;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.drawerlayout.widget.DrawerLayout;
    import android.app.ActionBar;
    import android.app.LauncherActivity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.os.Handler;
    import android.util.Log;
    import android.view.MenuItem;
    import java.util.ArrayList;
    import java.util.Calendar;
    import java.util.List;
    import com.google.android.material.navigation.NavigationView;

    public class MainActivity extends AppCompatActivity {
        private DrawerLayout D1;
        private ActionBarDrawerToggle t;
        private NavigationView nvs;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            D1=(DrawerLayout) findViewById(R.id.activity_main);
            t=new ActionBarDrawerToggle(this,D1,R.string.Open, R.string.Close);
            D1.addDrawerListener(t);
            t.syncState();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            final callActivity ca = new callActivity();
            nvs = (NavigationView)findViewById(R.id.nv);
            nvs.inflateMenu(R.menu.navigation_menu);
            nvs.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem options) {
                    int val = options.getItemId();
                    switch(val)
                    {
                        case R.id.home:
                            ca.showActivity(MainActivity.class, false);
                        case R.id.team:
                            Log.d("Wait","Wait");
                        case R.id.images:
                            ca.showActivity(imageActivity.class, false);
                        case R.id.audit:
                            Log.d("Wait","Wait");
                        case R.id.settings:
                            ca.showActivity(configurationActivity.class, false);
                    }
                    return true;
                }
            });
         }

        @Override
        public boolean onOptionsItemSelected(MenuItem options) {
            if(t.onOptionsItemSelected(options))
            {
                return true;
                }
            return super.onOptionsItemSelected(options);
        }
    }