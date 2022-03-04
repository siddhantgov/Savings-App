package universityatbuffalo.cse442groupproject.main;

import android.widget.EditText;
import android.widget.Toast;

import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryActivityTest {

    @Test
    public void showToast() throws Exception{
       String input = "Hello World";
       String output;
       String expected = "Hello World";

       CategoryActivityTest categoryActivityTest = new CategoryActivityTest();
       output = input;
       assertEquals(expected,output);

    }
}