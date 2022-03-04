package universityatbuffalo.cse442groupproject.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.SearchManager;
import android.content.Intent;


public class CouponActivity extends AppCompatActivity {

    String searchinput;
    Button searchButton;
    EditText couponinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        couponinput = findViewById(R.id.coupontext);
        searchButton = findViewById(R.id.searchbutton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    String searchinput = couponinput.getText().toString();
                    intent.putExtra(SearchManager.QUERY, searchinput);
                    startActivity(intent);
                }
                catch(Exception e){
                     System.out.println("Sorry, try again");
                }

            }
        });

    }


    }

