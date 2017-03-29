package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TheoryActivity extends AppCompatActivity {

    Button buttonElemElektro;
    Button buttonUkladyScalone;
    Button buttonOgolnePojecia;
    Button buttonWarsztat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);

        buttonElemElektro = (Button) findViewById(R.id.elem_elektroniczne);
        buttonUkladyScalone = (Button) findViewById(R.id.uklady);
        buttonOgolnePojecia = (Button) findViewById(R.id.ogolne_pojecia);
        buttonWarsztat = (Button) findViewById(R.id.warsztat);

        onClickButton(buttonElemElektro,ElementyElektoniczneActivity.class);
        onClickButton(buttonUkladyScalone,UkladyScaloneActivity.class);
        onClickButton(buttonOgolnePojecia,OgolnePojeciaActivity.class);
        onClickButton(buttonWarsztat,WarsztatActivity.class);
    }

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
