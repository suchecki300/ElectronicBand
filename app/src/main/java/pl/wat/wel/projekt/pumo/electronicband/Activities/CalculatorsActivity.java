package pl.wat.wel.projekt.pumo.electronicband.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import pl.wat.wel.projekt.pumo.electronicband.Calcs.LogicCalcs.LogicCalcsAND;
import pl.wat.wel.projekt.pumo.electronicband.Calcs.LogicCalcs.LogicCalcsNAND;
import pl.wat.wel.projekt.pumo.electronicband.Calcs.LogicCalcs.LogicCalcsNOR;
import pl.wat.wel.projekt.pumo.electronicband.Calcs.LogicCalcs.LogicCalcsNOT;
import pl.wat.wel.projekt.pumo.electronicband.Calcs.LogicCalcs.LogicCalcsOR;
import pl.wat.wel.projekt.pumo.electronicband.Calcs.LogicCalcs.LogicCalcsXOR;
import pl.wat.wel.projekt.pumo.electronicband.Calcs.SimpleCalc.Prosty_Kalkulator;
import pl.wat.wel.projekt.pumo.electronicband.R;
import pl.wat.wel.projekt.pumo.electronicband.ResistorCalcs;

public class CalculatorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView gateCalculatorView = (TextView) findViewById(R.id.logic_gates_calculator);

        final Animation animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        final Animation animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        final Animation animZoomInFromZero = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in_from_zero);

        gateCalculatorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout logic_sub = (LinearLayout) findViewById(R.id.logic_submenu);
                if (logic_sub.getVisibility() == View.GONE) {
                    logic_sub.setVisibility(View.VISIBLE);
                    logic_sub.startAnimation(animZoomInFromZero);
                    findViewById(R.id.calc_pic).startAnimation(animZoomOut);
                    findViewById(R.id.calc_pic_res).startAnimation(animZoomOut);
                } else {
                    logic_sub.setVisibility(View.GONE);
                    findViewById(R.id.calc_pic).startAnimation(animZoomIn);
                    findViewById(R.id.calc_pic_res).startAnimation(animZoomIn);
                }
            }
        });

        moveToCalculator(findViewById(R.id.resistors_calculator), ResistorCalcs.class);
        moveToCalculator(findViewById(R.id.simple_calculator), Prosty_Kalkulator.class);
        moveToCalculator(findViewById(R.id.gate_nor), LogicCalcsNOR.class);
        moveToCalculator(findViewById(R.id.gate_nand), LogicCalcsNAND.class);
        moveToCalculator(findViewById(R.id.gate_not), LogicCalcsNOT.class);
        moveToCalculator(findViewById(R.id.gate_and), LogicCalcsAND.class);
        moveToCalculator(findViewById(R.id.gate_or), LogicCalcsOR.class);
        moveToCalculator(findViewById(R.id.gate_xor), LogicCalcsXOR.class);
    }

    private void moveToCalculator(View clickView, final Class classActivity) {
        clickView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), classActivity);
                startActivity(intent);
            }
        });
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
