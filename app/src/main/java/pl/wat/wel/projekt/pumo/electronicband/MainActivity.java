package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static pl.wat.wel.projekt.pumo.electronicband.R.id.button4;
import static pl.wat.wel.projekt.pumo.electronicband.R.id.button5;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (Button) findViewById(R.id.button);
        button2= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        button4= (Button) findViewById(R.id.button4);
        button5= (Button) findViewById(R.id.button5);
        //Przyciski do menu glownego, kalkulatory, słownik i opisy

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), TheoryActivity.class);
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
                Intent intent = new Intent(getApplicationContext(), DictionaryActivity.class);
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
