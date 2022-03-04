package universityatbuffalo.cse442groupproject.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.content.Context;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.ArrayList;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Locale;

public class HistoryActivity  extends AppCompatActivity {


    EditText et;
    EditText ratingET;
    EditText amountET;
    Button bt;
    Button tryB;
    ListView lv;
    TextView tv;
    EditText date;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);

        et = findViewById(R.id.testEdit);
        ratingET = findViewById(R.id.ratingText);
        amountET = findViewById(R.id.amountText);
        bt =  findViewById(R.id.testButton);
        lv =  findViewById(R.id.listViewTest);
        //tryB = findViewById(R.id.tryButton);

        final Button pickDate = (Button) findViewById(R.id.pick_date);
        tv = (TextView) findViewById(R.id.date1);

        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                // myCalendar.add(Calendar.DATE, 0);
                String myFormat = "yyyy-MM-dd"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                tv.setText(sdf.format(myCalendar.getTime()));
            }


        };

        pickDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Calendar c = Calendar.getInstance();
                final int mYear = c.get(Calendar.YEAR);
                final int mMonth = c.get(Calendar.MONTH);
                final int mDay = c.get(Calendar.DAY_OF_MONTH);

                // Launch Date Picker Dialog
                DatePickerDialog dpd = new DatePickerDialog(HistoryActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // Display Selected date in textbox


                                if (year < mYear)
                                    view.updateDate(mYear,mMonth,mDay);

                                if (monthOfYear < mMonth && year == mYear)
                                    view.updateDate(mYear,mMonth,mDay);

                                if (dayOfMonth < mDay && year == mYear && monthOfYear == mMonth)
                                    view.updateDate(mYear,mMonth,mDay);

                                tv.setText(dayOfMonth + "-"
                                        + (monthOfYear + 1) + "-" + year);


                            }
                        }, mYear, mMonth, mDay);
                dpd.getDatePicker().setMinDate(System.currentTimeMillis());
                dpd.show();

            }
        });




        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(HistoryActivity.this,android.R.layout.simple_list_item_1, arrayList );
        lv.setAdapter(adapter);

        onButtonClick();


    }



    public void onButtonClick() {
        bt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                try {

                    String location1 = et.getText().toString();
                    float amount1 = Float.parseFloat(amountET.getText().toString());
                    int rating1 = Integer.parseInt(ratingET.getText().toString());


                    if(tv.getText().equals("")){
                        showToast("Please Select Date");
                    }

                    if (rating1 >= 1 && rating1 <= 5 && amount1 > 0 ) {

                        String result = "Date: " + tv.getText() + "  Location: " + location1 + "  Amount: " + amount1 + "  Rating: " + rating1;

                        String str = tv.getText() + " " + amount1;

                        bwrite(str);

                        arrayList.add(result);

                        adapter.notifyDataSetChanged();


                    }
                    else {
                        showToast("Enter a rating between 1 and 5, and an amount larger than 0");
                    }
                }catch(NumberFormatException e){
                    showToast("Error, try again");
                }


            }
        });


    }

   private void showToast(String text){
        Toast.makeText(HistoryActivity.this, text, Toast.LENGTH_SHORT).show();

    }

    public void bwrite(String s){

            final String ls = System.getProperty("line.separator");
            BufferedWriter writer = null;
            try {
                writer =
                        new BufferedWriter(new OutputStreamWriter(openFileOutput("try.txt",
                                Context.MODE_APPEND)));
                writer.write(s + ls);
                //showToast("Written");

            } catch (Exception exe) {
                exe.printStackTrace();
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    public void showDatePickerDialog(View view) {
    }
}




