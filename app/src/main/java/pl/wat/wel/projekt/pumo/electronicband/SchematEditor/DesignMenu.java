package pl.wat.wel.projekt.pumo.electronicband.SchematEditor;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

import pl.wat.wel.projekt.pumo.electronicband.R;

public class DesignMenu extends AppCompatActivity {

    String arrayName[] = {"Usuń","Zapisz", "Połącz_elementy","Zmień_parametry","Ołóż_elementy"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_menu);

        circle_menu();
    }

    protected void circle_menu()

    {
        CircleMenu circleMenu = (CircleMenu)findViewById(R.id.circle);
        circleMenu.setMainMenu(Color.parseColor("#000000"),R.drawable.ic_build_white_36dp, R.drawable.ic_build_white_36dp)
                .addSubMenu(Color.BLUE,R.drawable.ic_delete_forever_blue_50_48dp)                            //delete
                .addSubMenu(Color.CYAN,R.drawable.ic_save_light_green_a700_48dp)                                   //save
                .addSubMenu(Color.GRAY,R.drawable.ic_repeat_green_a700_48dp)                              //connet
                .addSubMenu(Color.GREEN,R.drawable.ic_colorize_deep_orange_400_48dp)                         //parametrs
                .addSubMenu(Color.RED,R.drawable.ic_grain_white_48dp)                                   //moves
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        Toast.makeText(DesignMenu.this, "Wybrales " + arrayName[index], Toast.LENGTH_SHORT).show();

                        if(index==2)
                        {
                            Intent intent = new Intent();
                            intent.putExtra("tryb", 1);
                            setResult(RESULT_FIRST_USER, intent);
                            finish();
                        }




                        if(index==3)
                        {
                            Intent intent = new Intent();
                            intent.putExtra("tryb", 2);
                            setResult(RESULT_FIRST_USER, intent);
                            finish();
                        }

                        if(index==4)
                        {
                            Intent intent = new Intent();
                            intent.putExtra("tryb", 0);
                            setResult(RESULT_FIRST_USER, intent);
                            finish();
                        }

                        if(index==0)
                        {
                            Intent intent = new Intent(getApplicationContext(), SchematicsEditor.class);
                            startActivity(intent);
                        }



                    }
                });

    }
}
