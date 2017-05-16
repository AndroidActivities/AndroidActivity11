package cat.udl.eps.navigationdrawer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar appbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appbar = (Toolbar)findViewById(R.id.appbar);
        setSupportActionBar(appbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        textView = (TextView) findViewById(R.id.textView);
        registerForContextMenu(textView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        navView = (NavigationView)findViewById(R.id.navview);
        navView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {

                    boolean fragmentTransaction = false;
                    //Fragment fragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.menu_seccion_1:
                            //fragment = new Fragment1();
                            textView.setText(getString(R.string.Part1));
                            fragmentTransaction = true;
                            break;
                        case R.id.menu_seccion_2:
                            //fragment = new Fragment2();
                            textView.setText(getString(R.string.Part2));
                            fragmentTransaction = true;
                            break;
                        case R.id.menu_seccion_3:
                            //fragment = new Fragment3();
                            textView.setText(getString(R.string.Part3));
                            fragmentTransaction = true;
                            break;
                        case R.id.menu_opcion_1:
                            //Log.i("NavigationView", "Pulsada opción 1");
                            textView.setText(getString(R.string.Part4));
                            break;
                        case R.id.menu_opcion_2:
                            //Log.i("NavigationView", "Pulsada opción 2");
                            textView.setText(getString(R.string.Part5));
                            break;
                    }

                    if(fragmentTransaction) {
                        //getSupportFragmentManager().beginTransaction()
                        //       .replace(R.id.content_frame, fragment)
                        //        .commit();

                        menuItem.setChecked(true);
                        getSupportActionBar().setTitle(menuItem.getTitle());
                    }

                    drawerLayout.closeDrawers();

                    return true;
                }
            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_navview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch(item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.menu_seccion_1:
                //fragment = new Fragment1();
                textView.setText(getString(R.string.Part1));
                break;
            case R.id.menu_seccion_2:
                //fragment = new Fragment2();
                textView.setText(getString(R.string.Part2));
                break;
            case R.id.menu_seccion_3:
                //fragment = new Fragment3();
                textView.setText(getString(R.string.Part3));
                break;
            case R.id.menu_opcion_1:
                //Log.i("NavigationView", "Pulsada opción 1");
                textView.setText(getString(R.string.Part4));
                break;
            case R.id.menu_opcion_2:
                //Log.i("NavigationView", "Pulsada opción 2");
                textView.setText(getString(R.string.Part5));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.context1:
                Toast.makeText(this, getString(R.string.context1), Toast.LENGTH_LONG).show();
            case R.id.context2:
                Toast.makeText(this, getString(R.string.context2), Toast.LENGTH_LONG).show();
            default:
                return super.onContextItemSelected(item);
        }
    }
}
