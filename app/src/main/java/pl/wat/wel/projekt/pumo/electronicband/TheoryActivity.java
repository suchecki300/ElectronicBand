package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TheoryActivity extends AppCompatActivity {

    //======================  Deklaracja obiektów design'u =========================================
    Button buttonElectronicElements;
    Button buttonChips;
    Button buttonBasicTerms;
    Button buttonWorkshop;

    //==============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);

        // Powiązanie wcześniej zadeklarowanych obiektów z elementami zawartymi w layout'cie.
        buttonElectronicElements = (Button) findViewById(R.id.electronics_elements);
        buttonChips = (Button) findViewById(R.id.integrated_circuits);
        buttonBasicTerms = (Button) findViewById(R.id.basic_terms);
        buttonWorkshop = (Button) findViewById(R.id.workshop);

        //Wywołanie metod obsługi przycisku.
        onClickButton(buttonElectronicElements, ElectronicElementrsActivity.class);
        onClickButton(buttonChips, ChipsActivity.class);
        onClickButton(buttonBasicTerms, BasicTermsActivity.class);
        onClickButton(buttonWorkshop, WorkshopActivity.class);
    }

    /**
     * Funkcja do obsługi kliknięcia przycisku.
     *
     * @param button Przycisk, który został przyciśnięty.
     * @param c      Aktywność, na którą aplikacja ma się przełączyć.
     */
    private void onClickButton(Button button, final Class c) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TheoryActivity.this, c);
                startActivity(intent);
            }
        });
    }
}
