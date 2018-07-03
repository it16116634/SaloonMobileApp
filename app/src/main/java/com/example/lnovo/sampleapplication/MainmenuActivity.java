package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.Snackbar;
import android.text.Selection;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

import static com.example.lnovo.sampleapplication.R.*;
import static com.example.lnovo.sampleapplication.R.id.drawer_layout;
import static com.example.lnovo.sampleapplication.R.id.fab;
import static com.example.lnovo.sampleapplication.R.id.nav_view;
import static com.example.lnovo.sampleapplication.R.id.toolbar;

public class MainmenuActivity extends AppCompatActivity
        implements OnNavigationItemSelectedListener {
    private Button button35;
    private Button button36;
    private Button button43;
    private Button button44;
    private Button button45;
    private Button button46;
    private Button button47;
    private Button button48;
    private Button button41;
    private Button button42;
   private Button button37;
   private Button btn;
   private Button btn1;
   private TextView kk;
   String uname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(layout.activity_mainmenu);

        kk =(TextView) findViewById(id.txtr);
        Intent in = getIntent();

         uname = in.getStringExtra("uname");

        kk.setText(uname);



        //viewUserName();

        button36 = (Button) findViewById(id.button36);
        button36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSalonActivity();
            }
        });

        button48 = (Button) findViewById(id.button48);
        button48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTatoActivity();
            }
        });

        button47 = (Button) findViewById(id.button47);
        button47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        button46 = (Button) findViewById(id.button46);
        button46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNailsActivity();
            }
        });

        button45 = (Button) findViewById(id.button45);
        button45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBodyActivity();
            }
        });

        button44 = (Button) findViewById(id.button44);
        button44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFaceActivity();
            }
        });

        button43 = (Button) findViewById(id.button43);
        button43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHairActivity();
            }
        });

       // button35 = (Button) findViewById(id.button35);
       /* button35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openServicesActivity();

            }

        });*/
        button41 = (Button) findViewById(id.button41);
        button41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPackageActivity();

            }

        });
        button42 = (Button) findViewById(id.button42);
        button42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProductActivity();

            }

        });


        Toolbar toolbar = findViewById(id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, string.navigation_drawer_open, string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    //private void viewUserName() {



        //Intent take = getIntent();
        //String getUname = take.getStringExtra("uname");
       // uname.setText(getUname);
    //}

    private void openOfferActivity() {
        Intent intent = new Intent(this,OfferActivity.class);
        intent.putExtra("uname",uname);
        startActivity(intent);
    }

    private void openSalonActivity() {
        Intent intent = new Intent(this,SalonActivity.class);
        intent.putExtra("uname",uname);
        startActivity(intent);
    }
    private void openPackageActivity() {
       Intent intent = new Intent(this, selection.class);
        intent.putExtra("uname",uname);
       startActivity(intent);
    }
    private void openProductActivity() {
        Intent intent = new Intent(this,view_inventory.class);
        intent.putExtra("uname",uname);
        startActivity(intent);
    }


    private void openTatoActivity() {
        Intent intent = new Intent(this,TatoActivity.class);
        intent.putExtra("uname",uname);
        startActivity(intent);
    }

    private void openMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("uname",uname);
        startActivity(intent);
    }

    private void openNailsActivity() {
        Intent intent = new Intent(this,NailsActivity.class);
        intent.putExtra("uname",uname);
        startActivity(intent);
    }

    private void openBodyActivity() {
        Intent intent = new Intent(this,BodyActivity.class);
        intent.putExtra("uname",uname);
        startActivity(intent);
    }

    private void openFaceActivity() {
        Intent intent = new Intent(this,FaceActivity.class);
        startActivity(intent);
    }

    private void openHairActivity() {
        Intent intent = new Intent(this,HairActivity.class);
        intent.putExtra("uname",uname);
        startActivity(intent);
    }

    public void openServicesActivity() {

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
           /*Intent i = new Intent(MainmenuActivity.this,HomeActivity.class);
            i.putExtra("uname",uname);
            startActivity(i);*/
        } else if (id == R.id.nav_profile) {
            Intent i = new Intent(MainmenuActivity.this, CustomerProfile.class);
            i.putExtra("uname", uname);
            startActivity(i);
        } else if (id == R.id.nav_booking) {
            Intent i = new Intent(MainmenuActivity.this, BookingFormActivity.class);
            i.putExtra("uname",uname);
            startActivity(i);
        } else if (id == R.id.nav_salons) {
            Intent i = new Intent(MainmenuActivity.this,SalonActivity.class);
            i.putExtra("uname",uname);
            startActivity(i);
        } else if (id == R.id.nav_packages) {
            Intent i = new Intent(MainmenuActivity.this,selection.class);
            i.putExtra("uname",uname);
            startActivity(i);
        } else if (id == R.id.nav_offers) {
            Intent i = new Intent(MainmenuActivity.this,OfferActivity.class);
            i.putExtra("uname",uname);
            startActivity(i);
        }
        else if (id == R.id.nav_contactus) {
            Intent i = new Intent(MainmenuActivity.this,ContactUsActivity.class);
            startActivity(i);
        }
        else if (id == R.id.nav_livechat) {
            Intent i = new Intent(MainmenuActivity.this,ChatActivity.class);
            i.putExtra("uname",uname);
            startActivity(i);
        } else if (id == R.id.nav_about) {
            Intent i = new Intent(MainmenuActivity.this,AboutActivity.class);
            startActivity(i);
        }else if (id == R.id.nav_logout) {

            System.exit(0);
        }

        DrawerLayout drawer = findViewById(drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
