package universityatbuffalo.cse442groupproject.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private Button budgetpage;
    private Button graphpage;
    private Button couponpage;
    private Button settingspage;
    Button signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        budgetpage = findViewById(R.id.BudgetButton);
        budgetpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,BudgetActivity.class);
                startActivity(i);
            }
        });

        graphpage = findViewById(R.id.GraphButton);
        graphpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(MainActivity.this,GraphActivity.class);
                startActivity(k);
            }
        });

        settingspage = findViewById(R.id.settingsbt);
        settingspage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(m);
            }
        });

        couponpage = findViewById(R.id.CouponButton);
        couponpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://www.groupon.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }
        });
        signout = findViewById(R.id.logout);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(m);
            }
        });


        }






}
