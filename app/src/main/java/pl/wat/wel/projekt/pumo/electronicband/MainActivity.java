package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import pl.wat.wel.projekt.pumo.electronicband.Calcs.CalculatorsActivity;
import pl.wat.wel.projekt.pumo.electronicband.Courses.CoursesActivity;
import pl.wat.wel.projekt.pumo.electronicband.SchematEditor.SchematicsEditor;


public class MainActivity extends AppCompatActivity {
    private long backButtonPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView theoryView = (TextView) findViewById(R.id.theoryView);
        TextView calculatorsView = (TextView) findViewById(R.id.calculatorsView);
        TextView aboutUsView = (TextView) findViewById(R.id.aboutUsView);
        TextView coursesView = (TextView) findViewById(R.id.coursesView);
        TextView schemaEditorView = (TextView) findViewById(R.id.schemaEditorView);

        moveToAnotherActivity(theoryView, TheoryActivity.class);
        moveToAnotherActivity(calculatorsView, CalculatorsActivity.class);
        moveToAnotherActivity(aboutUsView, AboutUsActivity.class);
        moveToAnotherActivity(coursesView, CoursesActivity.class);
        moveToAnotherActivity(schemaEditorView, SchematicsEditor.class);
    }

    @Override
    public void onBackPressed() {
        if (backButtonPressed + 1000 > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), R.string.back_button_clicked_twice, Toast.LENGTH_SHORT).show();
        }
        backButtonPressed = System.currentTimeMillis();
    }

    private void moveToAnotherActivity(TextView clickView, final Class classActivity) {
        clickView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), classActivity);
                startActivity(intent);
            }
        });
    }
}
