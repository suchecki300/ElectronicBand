package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.wat.wel.projekt.pumo.electronicband.Dictionary.BasicTermsActivity;
import pl.wat.wel.projekt.pumo.electronicband.Dictionary.ChipsActivity;
import pl.wat.wel.projekt.pumo.electronicband.Dictionary.ElectronicElementsActivity;
import pl.wat.wel.projekt.pumo.electronicband.Dictionary.WorkshopActivity;

public class DictionarysActivity extends AppCompatActivity {

    TextView buttonElectronicElements;
    TextView buttonChips;
    TextView buttonCommonTerms;
    TextView buttonWorkshop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionarys);

        buttonElectronicElements = (TextView) findViewById(R.id.electronics_elements);
        buttonChips = (TextView) findViewById(R.id.integrated_circuits);
        buttonCommonTerms = (TextView) findViewById(R.id.basic_terms);
        buttonWorkshop = (TextView) findViewById(R.id.workshop);

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
    private void onClickButton(TextView button, final Class c){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DictionarysActivity.this,c);
                startActivity(intent);
            }
        });
    }
}
