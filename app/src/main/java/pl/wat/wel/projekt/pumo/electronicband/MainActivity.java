package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import pl.wat.wel.projekt.pumo.electronicband.Calcs.Kalkulatory;
import pl.wat.wel.projekt.pumo.electronicband.Courses.CourseRelativeActivity;
import pl.wat.wel.projekt.pumo.electronicband.SchematEditor.SchematicsEditor;



public class MainActivity extends AppCompatActivity {
    TextView button;
    TextView button2;
    TextView button3;
    TextView button4;
    TextView button5;
    private long back_pressed;

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
                Intent intent = new Intent(getApplicationContext(), AboutUsActivity.class);
                startActivity(intent);
            }
        });



        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CourseRelativeActivity.class);
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

    @Override
    public void onBackPressed() {
        if (back_pressed + 1000 > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), R.string.back_button_clicked_twice, Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
    }
}
