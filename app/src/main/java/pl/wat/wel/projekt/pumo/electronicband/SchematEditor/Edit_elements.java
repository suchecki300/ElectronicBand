package pl.wat.wel.projekt.pumo.electronicband.SchematEditor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import pl.wat.wel.projekt.pumo.electronicband.R;

public class Edit_elements extends AppCompatActivity {

    int detector = 0;
    public static final String Elements_FILE = "elements.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_elements);

    }


    public void addelements(View view) {

        EditText editText = (EditText) findViewById(R.id.name_of_element);
        EditText editText1 = (EditText) findViewById(R.id.value_of_element);


        File file = new File(getFilesDir(), Elements_FILE);

        Log.d("ściezka pliku:", file.toString());
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
            out.write(editText.getText().toString());
            out.newLine();
            out.write("  " + editText1.getText().toString());
            out.close();
            Toast.makeText(this, "Element dodany.", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Nie udało się dodać: " + e.getCause(), Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent();
        intent.putExtra("tryb", 1);
        setResult(RESULT_FIRST_USER, intent);
        finish();

    }


    }

