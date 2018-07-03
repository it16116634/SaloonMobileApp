package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Selection;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button36 = (Button) findViewById(R.id.button36);
        button36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSalonActivity();
            }
        });

        button48 = (Button) findViewById(R.id.button48);
        button48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTatoActivity();
            }
        });

        button47 = (Button) findViewById(R.id.button47);
        button47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        button46 = (Button) findViewById(R.id.button46);
        button46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNailsActivity();
            }
        });

        button45 = (Button) findViewById(R.id.button45);
        button45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBodyActivity();
            }
        });

        button44 = (Button) findViewById(R.id.button44);
        button44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFaceActivity();
            }
        });

        button43 = (Button) findViewById(R.id.button43);
        button43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHairActivity();
            }
        });

        /*button35 = (Button) findViewById(R.id.button35);
        button35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openServicesActivity();

            }

        });*/
        button41 = (Button) findViewById(R.id.button41);
        button41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPackageActivity();

            }

        });
        button42 = (Button) findViewById(R.id.button42);
        button42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProductActivity();

            }

        });

    }

    private void openSalonActivity() {

    }

    private void openTatoActivity() {
        Intent intent = new Intent(this,TatoActivity.class);
        startActivity(intent);
    }

    private void openMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void openNailsActivity() {
        Intent intent = new Intent(this,NailsActivity.class);
        startActivity(intent);
    }

    private void openBodyActivity() {
        Intent intent = new Intent(this,BodyActivity.class);
        startActivity(intent);
    }

    private void openFaceActivity() {
        Intent intent = new Intent(this,FaceActivity.class);
        startActivity(intent);
    }

    private void openHairActivity() {
        Intent intent = new Intent(this,HairActivity.class);
        startActivity(intent);
    }

    public void openServicesActivity() {

    }
    private void openPackageActivity() {
        Intent intent = new Intent(this, selection.class);
        startActivity(intent);
    }
    private void openProductActivity() {
        Intent intent = new Intent(this,view_inventory.class);
        startActivity(intent);
    }


}
