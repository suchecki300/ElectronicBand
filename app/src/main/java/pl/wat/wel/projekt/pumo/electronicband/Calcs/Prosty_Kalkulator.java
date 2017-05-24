package pl.wat.wel.projekt.pumo.electronicband.Calcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import pl.wat.wel.projekt.pumo.electronicband.R;

import static pl.wat.wel.projekt.pumo.electronicband.R.id.edittext;

public class Prosty_Kalkulator extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    double d;
    TextView editText;
    TextView textView1;
    TextView textView2;
    int i=0;
    float wynik;
    private String liczba1 = "";
    private String liczba2;
    private long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prosty__kalkulator);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView2 = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        String message = intent.getStringExtra("funkcja");
        textView2.setText(message);

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

    public void onClick(View v){

        editText = (TextView) findViewById(edittext);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        switch(v.getId()) {
            case R.id.kasujc:
                if(!editText.getText().toString().equals(""))
                    liczba1=editText.getText().toString().substring(0, liczba1.length()-1);
                editText.setText(liczba1);
                break;
            case R.id.kasujce:
                liczba1="";
                editText.setText(liczba1);
                break;
            case R.id.more:
                if(editText.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "Wprowadź jakąś wartość!", Toast.LENGTH_SHORT).show();
                else
            {
                Intent more_functions = new Intent(getApplicationContext(), More_Activity_moreee.class);
                String sending_mes = editText.getText().toString();
                more_functions.putExtra("number", sending_mes);

                startActivity(more_functions);
            }
                break;
            //////wpisywanie cyfer//////////////////////////////
            case R.id.button1:
                liczba1=editText.getText().toString() + "1";
                editText.setText(liczba1);
                break;
            case R.id.button2:
                liczba1 = editText.getText().toString() + "2";
                editText.setText(liczba1);
                break;
            case R.id.button3:
                liczba1 = editText.getText().toString() + "3";
                editText.setText(liczba1);
                break;
            case R.id.button4:
                liczba1 = editText.getText().toString() + "4";
                editText.setText(liczba1);
                break;
            case R.id.button5:
                liczba1 = editText.getText().toString() + "5";
                editText.setText(liczba1);
                break;
            case R.id.button6:
                liczba1 = editText.getText().toString() + "6";
                editText.setText(liczba1);
                break;
            case R.id.button7:
                liczba1 = editText.getText().toString() + "7";
                editText.setText(liczba1);
                break;
            case R.id.button8:
                liczba1 = editText.getText().toString() + "8";
                editText.setText(liczba1);
                break;
            case R.id.button9:
                liczba1 = editText.getText().toString() + "9";
                editText.setText(liczba1);
                break;
            case R.id.zero:
                liczba1 = editText.getText().toString() + "0";
                editText.setText(liczba1);
                break;
            case R.id.kropka:
                if(editText.getText().toString().equals(""))
                editText.setText("0.");
                else {
                    liczba1 = editText.getText().toString() + ".";
                    editText.setText(liczba1);
                }
                break;
////////////////////////////////////////////////////////
            case R.id.button10:
                if (i == 0) {
                    settters('+');
                } else {
                    if(textView2.getText().toString().equals("-") || textView2.getText().toString().equals("x") || textView2.getText().toString().equals("/") )
                    {    textView2.setText("+"); textView1.setText(textView1.getText().toString()); break; }
                    if(editText.getText().toString().equals(""))
                        editText.setText("0");
                    wynik = Float.valueOf(textView1.getText().toString()) + Float.valueOf(editText.getText().toString());
                    textView1.setText("");
                    editText.setText("");
                    textView2.setText(String.valueOf(wynik));
                    i = 0;
                }
                break;
            //---------------------ODEJMOWANIE--------------------------------------------------------
            case R.id.button11:
                if (i == 0) {
                    settters('-');
                }
                else {
                    if(textView2.getText().toString().equals("+") || textView2.getText().toString().equals("x") || textView2.getText().toString().equals("/") )
                    {    textView2.setText("-"); textView1.setText(textView1.getText().toString()); break; }
                    if(editText.getText().toString().equals(""))
                        editText.setText("0");
                    wynik = Float.valueOf(textView1.getText().toString()) - Float.valueOf(editText.getText().toString());
                    textView1.setText("");
                    editText.setText("");
                    textView2.setText(String.valueOf(wynik));
                    i = 0;
                }

                break;
            //---------------------Mnozenie--------------------------------------------------------
            case R.id.mnoz:

                if (i == 0) {
                    settters('x');
                } else {
                    if(textView2.getText().toString().equals("+") || textView2.getText().toString().equals("-") || textView2.getText().toString().equals("/") )
                    {    textView2.setText("x"); textView1.setText(textView1.getText().toString()); break; }
                    if(editText.getText().toString().equals(""))
                        editText.setText("0");
                    wynik = Float.valueOf(textView1.getText().toString()) * Float.valueOf(editText.getText().toString());
                    textView1.setText("");
                    editText.setText("");
                    textView2.setText(String.valueOf(wynik));
                    i = 0;
                }
                break;
            //---------------------Dzielenie--------------------------------------------------------
            case R.id.dziel:
                if (i == 0) {
                    settters('/');
                } else {
                    if(textView2.getText().toString().equals("+") || textView2.getText().toString().equals("x") || textView2.getText().toString().equals("-") )
                    {    textView2.setText("/"); textView1.setText(textView1.getText().toString()); break; }
                    if(editText.getText().toString().equals(""))
                        editText.setText("0");
                    wynik = Float.valueOf(textView1.getText().toString()) / Float.valueOf(editText.getText().toString());
                    textView1.setText("");
                    editText.setText("");
                    textView2.setText(String.valueOf(wynik));
                    i = 0;
                }
                break;
           case R.id.sqrt:
                liczba1 = editText.getText().toString();
               Math.sqrt(Float.valueOf(liczba1));
               editText.setText(String.valueOf(Math.sqrt(Float.valueOf(liczba1))));
               Toast.makeText(getApplicationContext(), "sqrt(" + liczba1 + ") =" + editText.getText().toString(), Toast.LENGTH_SHORT).show();

                break;

            case R.id.bin:
                liczba1 = editText.getText().toString();
                if(editText.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "Podaj liczbę!", Toast.LENGTH_SHORT).show();
                else
                Toast.makeText(getApplicationContext(), "BIN(" + Integer.toBinaryString(Integer.valueOf(liczba1)).toString() + ")", Toast.LENGTH_SHORT).show();

                break;
            case R.id.hexx:
                liczba1 = editText.getText().toString();
                if(editText.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "Podaj liczbę!", Toast.LENGTH_SHORT).show();
                else
                Toast.makeText(getApplicationContext(), "Hex(" + Integer.toHexString(Integer.valueOf(liczba1)).toString() + ")", Toast.LENGTH_SHORT).show();

                break;

            case R.id.button12:
                if (i == 0) {
                    textView1.setText("");
                    textView2.setText(editText.getText().toString());
                    editText.setText("");
                }
                else {
                    if(textView2.getText().toString().equals("+")) {
                        wynik = Float.valueOf(editText.getText().toString()) + Float.valueOf(textView1.getText().toString());
                        zerowanie_do_wyniku();
                    }
                    else if(textView2.getText().toString().equals("-")){
                        wynik = Float.valueOf(textView1.getText().toString()) - Float.valueOf(editText.getText().toString());
                        zerowanie_do_wyniku();

                                            }
                    else if(textView2.getText().toString().equals("x")){
                        wynik = Float.valueOf(editText.getText().toString()) * Float.valueOf(textView1.getText().toString());
                        zerowanie_do_wyniku();

                    }
                    else if(textView2.getText().toString().equals("/")){
                        wynik = Float.valueOf(textView1.getText().toString()) / Float.valueOf(editText.getText().toString());
                        zerowanie_do_wyniku();

                    }
                }
        }
    }




    public void zerowanie_do_wyniku()
    {
        textView1.setText("");
        editText.setText("");
        textView2.setText(String.valueOf(wynik));
        i = 0;
    }


    public void settters(char znak)
    {
        if(editText.getText().toString().equals(""))
        {
            if(textView2.getText().toString().equals(""))
                textView2.setText("0");
            textView1.setText(textView2.getText().toString());
            textView2.setText(String.valueOf(znak));
            editText.setText("");
            i=1;
        }
        else {
            liczba2 = editText.getText().toString();
            textView1.setText(liczba2);
            textView2.setText(String.valueOf(znak));
            liczba1 = "";
            editText.setText("");
            i = 1;
        }
    }

}

