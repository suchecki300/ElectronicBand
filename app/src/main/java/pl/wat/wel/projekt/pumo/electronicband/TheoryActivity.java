package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TheoryActivity extends AppCompatActivity {

    Button buttonElectronicElements;
    Button buttonChips;
    Button buttonCommonTerms;
    Button buttonWorkshop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);

        buttonElectronicElements = (Button) findViewById(R.id.electronics_elements);
        buttonChips = (Button) findViewById(R.id.integrated_circuits);
        buttonCommonTerms = (Button) findViewById(R.id.basic_terms);
        buttonWorkshop = (Button) findViewById(R.id.workshop);

        onClickButton(buttonElectronicElements,ElectronicElementsActivity.class);
        onClickButton(buttonChips,ChipsActivity.class);
        onClickButton(buttonCommonTerms,BasicTermsActivity.class);
        onClickButton(buttonWorkshop,WorkshopActivity.class);
    }

    /**
     * Metoda obsługująca przełączanie pomiędzy aktywnościami.
     * @param button    Przycisk, który ma przełączyć aktywność.
     * @param c         Aktywność, która się uruchomi po naciśnięciu przycisku.
     */
    private void onClickButton(Button button, final Class c){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TheoryActivity.this,c);
                startActivity(intent);
            }
        });
    }
}
