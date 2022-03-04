package universityatbuffalo.cse442groupproject.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import com.softmoore.android.graphlib.Function;
import com.softmoore.android.graphlib.Graph;
import com.softmoore.android.graphlib.GraphView;
import com.softmoore.android.graphlib.Label;
import com.softmoore.android.graphlib.Point;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GraphActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

       ArrayList<ArrayList<String>> list = read();

        Point[] points = new Point[list.size()];

        //double [] ymark = new double[list.size()];

        Label [] xLabels = new Label[list.size()];

        int x = 10;

        for(int i = 0; i<list.size();i++){

            points[i] = new Point(x,Float.valueOf(list.get(i).get(0)));

            xLabels[i] = new Label(x,list.get(i).get(1));

            x = x+10;
        }


        Graph graph = new Graph.Builder()
                .setWorldCoordinates(-10, (list.size()*10)+10, -10, 110)
                .setAxes(0, 0)
                .setXLabels(xLabels)
                .setXTicks(new double[] {10, 20, 30, 40, 50, 60,70,80,90,100})
                .setYTicks(new double[] {10,20,30,40,50,60,70,80,90,100})
                .addLineGraph(points, Color.RED)
                .build();
        GraphView graphView = findViewById(R.id.graph_view);
        graphView.setGraph(graph);


    }


    private void showToast(String text){
        Toast.makeText(GraphActivity.this, text, Toast.LENGTH_SHORT).show();
    }


    public ArrayList<ArrayList<String>> read(){
        ArrayList<ArrayList<String>> retVal = new  ArrayList<ArrayList<String>>();



        FileInputStream fis = null;
        try {
            fis = openFileInput("try.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] values = line.split(" ");
                ArrayList<String> y = new ArrayList<String>();
                y.add(values[1]);
                String c = "-";
                String k = values[0].substring(0,values[0].length()-5);
                String z = values[0].substring(values[0].length()-2,values[0].length());
                y.add(k+c+z);

                retVal.add(y);
                //showToast("Nuh");

            }
        } catch (FileNotFoundException e) {
            showToast("Exception e!");
            e.printStackTrace();
        } catch (IOException e) {
            showToast("IOException");
            e.printStackTrace();
        }

        return retVal;

    }

}



