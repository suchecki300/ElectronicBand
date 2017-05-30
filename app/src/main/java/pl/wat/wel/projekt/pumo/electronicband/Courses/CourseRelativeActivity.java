package pl.wat.wel.projekt.pumo.electronicband.Courses;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import pl.wat.wel.projekt.pumo.electronicband.R;

/**
 * Created by Damian Bondaruk on 2017-05-24.
 */

public class CourseRelativeActivity extends AppCompatActivity {
    private final ArrayList<CourseModel> courseModels = new ArrayList<>();
    private RecyclerView recyclerView;
    private String tabUrl[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_relative);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toast.makeText(this, "Dotknij nazwy lub obrazka aby przejsc do kursu", Toast.LENGTH_SHORT).show();

        tabUrl = new String[]{getString(R.string.kurs_arduino1),
                getString(R.string.kurs_arduino2),
                getString(R.string.kurs_robotow),
                getString(R.string.kurs_edison),
                getString(R.string.kurs_elektroniki1),
                getString(R.string.kurs_elektroniki2),
                getString(R.string.kurs_stmf4),
                getString(R.string.kurs_stm32),
                getString(R.string.kurs_lutowania),
                getString(R.string.kurs_eagle),
                getString(R.string.kurs_cyfrowki)
        };

        courseModels.add(new CourseModel(getString(R.string.kurs_arduino_poziom1), R.drawable.arduinokurs, tabUrl[0]));
        courseModels.add(new CourseModel(getString(R.string.kurs_arduino_10_poziom_2), R.drawable.arduinokurs2, tabUrl[1]));
        courseModels.add(new CourseModel(getString(R.string.kurs_budowy_10_robotow), R.drawable.kursbudowyrotow_1, tabUrl[2]));
        courseModels.add(new CourseModel(getString(R.string.kurs_intel_10_edisona), R.drawable.kursedisona_1, tabUrl[3]));
        courseModels.add(new CourseModel(getString(R.string.kurs_podstaw_10_elektroniki), R.drawable.kurselektroniki, tabUrl[4]));
        courseModels.add(new CourseModel(getString(R.string.kurs_podstaw_10_elektroniki_ii), R.drawable.kurselektroniki2_1, tabUrl[5]));
        courseModels.add(new CourseModel(getString(R.string.kurs_stm32_10_f4_cube_i_hal), R.drawable.kursstm32f4_1, tabUrl[6]));
        courseModels.add(new CourseModel(getString(R.string.kurs_stm32_1), R.drawable.kursstm32_1, tabUrl[7]));
        courseModels.add(new CourseModel(getString(R.string.kurs_lutowania_1), R.drawable.kurslutowania, tabUrl[8]));
        courseModels.add(new CourseModel(getString(R.string.kurs_eagle_1), R.drawable.eagle, tabUrl[9]));
        courseModels.add(new CourseModel(getString(R.string.kurs_techniki_10_cyfrowej), R.drawable.kurstc_miniaturka_1, tabUrl[10]));

        recyclerView = (RecyclerView) findViewById(R.id.com_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        CourseAdapter adapter = new CourseAdapter(courseModels, new CourseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CourseModel item) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrlAdres()));
                startActivity(intent);
            }
        });
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
