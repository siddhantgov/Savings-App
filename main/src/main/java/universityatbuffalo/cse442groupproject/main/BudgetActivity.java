package universityatbuffalo.cse442groupproject.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Vector;

public class BudgetActivity extends AppCompatActivity {
    float inputbugdet;
    float amountspent;
    int rating;
    String inputlocation;
    Button submitButton;
    Button spendingHistory;
    Button saveButton;
    EditText budgetinput;
    EditText locationinput;
    EditText amountinput;
    EditText ratinginput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        budgetinput = findViewById(R.id.budgettext);
        submitButton = findViewById(R.id.submitbutton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    inputbugdet = Float.valueOf(budgetinput.getText().toString());
                }
                catch(NumberFormatException error){
                    inputbugdet = 0;
                    showToast("Error");
                }
                showToast(String.valueOf(inputbugdet));
            }
    });
//        locationinput = findViewById(R.id.locationtext);
//        amountinput = findViewById(R.id.amounttext);
//        ratinginput = findViewById(R.id.ratingtext);
//        saveButton = findViewById(R.id.savebutton);
//        saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try{
//                    amountspent = Float.valueOf(amountinput.getText().toString());
//                    rating = Integer.valueOf(ratinginput.getText().toString());
//                    if(rating > 5 || rating < 1){
//                        rating =0;
//                        showToast("Error Rating must be between 1 and 5");}
//                }catch(NumberFormatException t){
//                    amountspent = 0;
//
//                    showToast("Error");
//                }
//            }
//        });
        spendingHistory = findViewById(R.id.spendinghistory);
        spendingHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(BudgetActivity.this,HistoryActivity.class);
                startActivity(k);
            }
        });

        spendingHistory = findViewById(R.id.spendinghistory);
        spendingHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(BudgetActivity.this,HistoryActivity.class);
                startActivity(k);
            }
        });

    }

    private void showToast(String text){
        Toast.makeText(BudgetActivity.this, text, Toast.LENGTH_SHORT).show();
        //return text;
    }
}