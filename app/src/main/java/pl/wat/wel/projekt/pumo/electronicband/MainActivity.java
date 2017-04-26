package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.wat.wel.projekt.pumo.electronicband.Calcs.Kalkulatory;
import pl.wat.wel.projekt.pumo.electronicband.Courses.Courses;
import pl.wat.wel.projekt.pumo.electronicband.SchematEditor.SchematicsEditor;

public class MainActivity extends AppCompatActivity {

    TextView button;
    TextView button2;
    TextView button3;
    TextView button4;
    TextView button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (TextView) findViewById(R.id.button);
        button2= (TextView) findViewById(R.id.button2);
        button3= (TextView) findViewById(R.id.button3);
        button4= (TextView) findViewById(R.id.button4);
        button5= (TextView) findViewById(R.id.button5);
        //Przyciski do menu glownego, kalkulatory, słownik i opisy

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), DictionarysActivity.class);
               startActivity(intent);
            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), Kalkulatory.class);
               startActivity(intent);
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TheoryActivity.class);
                startActivity(intent);
            }
        });



        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Courses.class);
                startActivity(intent);
            }
        });


        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SchematicsEditor.class);
                startActivity(intent);
            }
        });
    }


}
