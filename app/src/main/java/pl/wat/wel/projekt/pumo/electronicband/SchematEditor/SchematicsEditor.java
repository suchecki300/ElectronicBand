package pl.wat.wel.projekt.pumo.electronicband.SchematEditor;


import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import pl.wat.wel.projekt.pumo.electronicband.R;

import static android.widget.Toast.makeText;
import static pl.wat.wel.projekt.pumo.electronicband.R.id.left_adding;
import static pl.wat.wel.projekt.pumo.electronicband.R.id.right_adding;


public class SchematicsEditor extends AppCompatActivity {


    private ImageView img;
    private ViewGroup rootLayout;
    private int _xDelta;
    private int _yDelta;
    private ImageView[] imgs = new ImageView[50];
    private ImageView[] connections = new ImageView[30];
    private ImageView[] connectionspion = new ImageView[30];

    private ImageView setting;
    private ImageView instruction;
    private int i=1;
    private int j=1;
    private int tryb =0;             //określa tryb w jakim pracujemy 1 - łączenie
    private int second_click=0;
    ImageButton left_adding;         //połączenie z lewej
    ImageButton right_adding;        //połączenie z prawej
    private int side_of_line=0;      // 1 -- lewa    0 --- prawa


    int first_x;
    int first_y;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schematics_editor);

        //określa z której strony wykonać połączenie
        left_adding = (ImageButton) findViewById(R.id.left_adding);
        right_adding = (ImageButton) findViewById(R.id.right_adding);

        setting = (ImageView) findViewById(R.id.settings);
        instruction = (ImageView) findViewById(R.id.instruction);       //podpowiedź


        instruction.postDelayed(new Runnable(){
            public void run(){ instruction.setVisibility(View.GONE);}
        },3000);

        gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener());



        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settin = new Intent(SchematicsEditor.this, DesignMenu.class);
                startActivityForResult(settin, 1);
            }
        });

        left_adding.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                side_of_line=1;
            }
        });

        right_adding.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                side_of_line=0;
            }
        });



        //Przyciski decydujące czy połączenie ma być z lewej czy prawej
        if(tryb ==1)
        {
            left_adding.setVisibility(View.VISIBLE);
            right_adding.setVisibility(View.VISIBLE);
        }
        else
        {
            left_adding.setVisibility(View.INVISIBLE);
            right_adding.setVisibility(View.INVISIBLE);
        }




    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode==1 && resultCode==RESULT_OK)
        {

            int receive = data.getIntExtra("pozycja",1);

            //Toast.makeText(getApplicationContext(), String.valueOf(receive), Toast.LENGTH_SHORT).show();
            i++;
            tworz(i, receive);
        }

        if(requestCode==1 && resultCode==RESULT_FIRST_USER)
        {

            int receive2 = data.getIntExtra("tryb",1);



            //Toast.makeText(getApplicationContext(), "działa_result", Toast.LENGTH_SHORT).show();
            tryb = receive2;  //przesuwanie
        }



        //Przyciski decydujące czy połączenie ma być z lewej czy prawej
        left_adding = (ImageButton) findViewById(R.id.left_adding);
        right_adding = (ImageButton) findViewById(R.id.right_adding);
        if(tryb ==1)
        {
            left_adding.setVisibility(View.VISIBLE);
            right_adding.setVisibility(View.VISIBLE);
        }
        else
        {
            left_adding.setVisibility(View.INVISIBLE);
            right_adding.setVisibility(View.INVISIBLE);
        }
        /////////////////koniec konfiguracji przycisków/////////////////////////////

    }




    protected void tworz(int general_id, int position)
    {
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.view_root);


        imgs[general_id]= new ImageView(this);
        layout.addView(imgs[general_id]);

        imgs[general_id].setVisibility(View.VISIBLE);

        if(position==1)
            imgs[general_id].setImageResource(R.drawable.kondens);
        else if(position==2)
            imgs[general_id].setImageResource(R.drawable.cewka2);
        else if(position==0)
            imgs[general_id].setImageResource(R.drawable.rezystor2);
        else if(position==3)
            imgs[general_id].setImageResource(R.drawable.diode3);
        else if(position==4)
            imgs[general_id].setImageResource(R.drawable.diode_led);


        imgs[general_id].getBackground();
        imgs[general_id].getLayoutParams().width=400;
        rootLayout = (ViewGroup) findViewById(R.id.view_root);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150,150);
        imgs[general_id].setLayoutParams(layoutParams);
        imgs[general_id].setOnTouchListener(new ChoiceTouchListener());



    }



    protected void tworz_connect2(final int general_id, int x_position, int y_position, int x_first, int y_first )
    {
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.view_root);


        connections[general_id]= new ImageView(this);
        layout.addView(connections[general_id]);

        connections[general_id].setVisibility(View.VISIBLE);
        connections[general_id].setImageResource(R.drawable.kreska2);
        connections[general_id].getLayoutParams().width=600;

        connections[general_id].setMaxHeight(10);


        connectionspion[general_id]= new ImageView(this);
        layout.addView(connectionspion[general_id]);

        connectionspion[general_id].setVisibility(View.VISIBLE);
        connectionspion[general_id].setImageResource(R.drawable.kreska2);
        connectionspion[general_id].getLayoutParams().width=600;

        connectionspion[general_id].setMaxHeight(40);




    float scale=1;
    float start=1;
    float fin_scale =1;
                                                // PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA
        if(side_of_line==0) {                   //PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA PRAWA

            // POZIOMO POZIOMO POZIOMO POZIOMO POZIOMO POZIOMO POZIOMO POZIOMO
            if (x_first < x_position) {
                //      connections[general_id].setMaxWidth(x_position - x_first);

                fin_scale = 600;
                scale = (x_position - 68 - x_first) / fin_scale;
                //(fin_scale-(scale*fin_scale)
                start = x_first + 140;
                connections[general_id].getLayoutParams().width = (int) (scale * fin_scale) - 68;
                connections[general_id].setX(start);
                connections[general_id].setY(y_first + 68);
                // connections[general_id].setScaleX(scale);
                //connections[general_id].getLayoutParams().height = 8;
                //connections[general_id].setScaleX((x_position- x_first)/scale);

                if (y_first < y_position) {

                    connectionspion[general_id].setRotation((float) 90.0);
                    connectionspion[general_id].setX(start -70 + (scale * fin_scale) - (y_position - (y_first)) * (float) 0.5);    //-300
                    connectionspion[general_id].setY(y_first + 68 + (y_position - (y_first)) * (float) 0.5);
                    connectionspion[general_id].getLayoutParams().width = (int) y_position - (y_first);
                }
                else if (y_first > y_position) {
                    int tempx, tempy;
                    tempx = x_first;
                    tempy = y_first;

                    x_first = x_position;
                    y_first = y_position;
                    x_position = tempx;
                    y_position = tempy;


                    connectionspion[general_id].setX(start + (scale * fin_scale) - 70 - (y_position - (y_first)) * (float) 0.5);    //-300
                    connectionspion[general_id].setY(y_first + 68 + (y_position - (y_first)) * (float) 0.5);
                    connectionspion[general_id].getLayoutParams().width = (int) y_position - (y_first);

                    connectionspion[general_id].setRotation((float) 90.0);

                }


            } else if (x_first > x_position) {
                int tempx, tempy;
                tempx = x_first;
                tempy = y_first;

                x_first = x_position;
                y_first = y_position;
                x_position = tempx;
                y_position = tempy;

                fin_scale = 600;
                scale = (x_position - 68 - x_first) / fin_scale;
                start = x_first + 143;
                connections[general_id].getLayoutParams().width = (int) (scale * fin_scale) +70;
                connections[general_id].setX(start);
                connections[general_id].setY(y_first + 68);

                tempx = x_first;
                tempy = y_first;

                x_first = x_position;
                y_first = y_position;
                x_position = tempx;
                y_position = tempy;

                if (y_first < y_position) {

                    connectionspion[general_id].setRotation((float) 90.0);
                    connectionspion[general_id].setX(start + 70 + (scale * fin_scale) - (y_position - (y_first)) * (float) 0.5);    //-300
                    connectionspion[general_id].setY(y_first + 68 + (y_position - (y_first)) * (float) 0.5);
                    connectionspion[general_id].getLayoutParams().width = (int) y_position - (y_first);
                }
                else if (y_first > y_position) {
                    tempx = x_first;
                    tempy = y_first;

                    x_first = x_position;
                    y_first = y_position;
                    x_position = tempx;
                    y_position = tempy;

                    start = x_first + 140;
                    connectionspion[general_id].setX(start +68 + (scale * fin_scale) - (y_position - (y_first)) * (float) 0.5);    //-300
                    connectionspion[general_id].setY(y_first + 68 + (y_position - (y_first)) * (float) 0.5);
                    connectionspion[general_id].getLayoutParams().width = (int) y_position - (y_first);

                    connectionspion[general_id].setRotation((float) 90.0);

                }

            }


        }
        else                                // LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA
        {                                   // LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA LEWA
            if (y_first < y_position) {
                connectionspion[general_id].setRotation((float) 90.0);
                start = x_first + 68;
                connectionspion[general_id].setX(start + (scale * fin_scale) - 68 - (y_position - (y_first)) * (float) 0.5);    //-300
                connectionspion[general_id].setY(y_first + 68 + (y_position - (y_first)) * (float) 0.5);
                connectionspion[general_id].getLayoutParams().width = (int) y_position - (y_first);


                if (x_first < x_position) {
                    fin_scale = 600;
                    scale = (x_position - 70 - x_first) / fin_scale;
                    //(fin_scale-(scale*fin_scale)
                    start = x_first;
                    connections[general_id].getLayoutParams().width = (int) (scale * fin_scale + 70);
                    connections[general_id].setX(start);
                    connections[general_id].setY(y_position + 70);


                } else if (x_first > x_position) {

                    fin_scale = 600;
                    scale = (x_first - 70- x_position) / fin_scale;
                    start = x_position+140 ;
                    connections[general_id].getLayoutParams().width = (int) (scale * fin_scale - 70);
                    connections[general_id].setX(start);
                    connections[general_id].setY(y_position + 70);

                }


            } else if (y_first > y_position) {
                start = x_first +68;
                int tempx, tempy;
                tempx = x_first;
                tempy = y_first;

                x_first = x_position;
                y_first = y_position;
                x_position = tempx;
                y_position = tempy;


                connectionspion[general_id].setX(start + (scale * fin_scale) - 68 - (y_position - (y_first)) * (float) 0.5);    //-300
                connectionspion[general_id].setY(y_first + 68 + (y_position - (y_first)) * (float) 0.5);
                connectionspion[general_id].getLayoutParams().width = (int) y_position - (y_first);

                connectionspion[general_id].setRotation((float) 90.0);

                if (x_first < x_position) {
                    fin_scale = 600;
                    scale = (x_position - 70 - x_first) / fin_scale;
                    //(fin_scale-(scale*fin_scale)
                    start = x_first+140;
                    connections[general_id].getLayoutParams().width = (int) (scale * fin_scale - 70);
                    connections[general_id].setX(start);
                    connections[general_id].setY(y_first + 70);


                } else if (x_first > x_position) {

                    fin_scale = 600;
                    scale = (x_first - 70- x_position) / fin_scale;
                    start = x_position;
                    connections[general_id].getLayoutParams().width = (int) (scale * fin_scale + 70);
                    connections[general_id].setX(start);
                    connections[general_id].setY(y_first + 70);

                }


            }



        }

        int[] location= new int[2];
        int[] location2= new int[2];
        connections[general_id].getLocationOnScreen(location);

        int x_location = location[0];
        int y_location = location[1];

        connectionspion[general_id].getLocationOnScreen(location2);

        int x_locationpio = location2[0];
        int y_locationpio = location2[1];

        Log.d("x_first", String.valueOf(side_of_line));
        /*
        Log.d("x_first", String.valueOf(x_first));
        Log.d("y_first", String.valueOf(y_first));
        Log.d("x_position", String.valueOf(x_position));
        Log.d("y_position", String.valueOf(y_position));
        Log.d("scalowanie", String.valueOf(scale));
        Log.d("scalowanie", String.valueOf(scale));
        Log.d("x kreski", String.valueOf(x_location));
        Log.d("y kreski", String.valueOf(y_location));
        Log.d("x kreski2", String.valueOf(x_locationpio));
        Log.d("y kreski2", String.valueOf(y_locationpio));
        Log.d("-----------", "---------");
        */

  //      Toast.makeText(getApplicationContext(), String.valueOf(x_location), Toast.LENGTH_SHORT).show();
  //      Toast.makeText(getApplicationContext(), String.valueOf(y_location), Toast.LENGTH_SHORT).show();

        rootLayout = (ViewGroup) findViewById(R.id.view_root);

    }









    private final class ChoiceTouchListener implements View.OnTouchListener {

        

        public boolean onTouch(View view, MotionEvent event) {
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();



        ////////////////////PRZESUWANIE ELEMENTÓW//////////////////////////////////////
            if (tryb == 0) {

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        _xDelta = X - lParams.leftMargin;
                        _yDelta = Y - lParams.topMargin;
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        layoutParams.leftMargin = X - _xDelta;
                        layoutParams.topMargin = Y - _yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        view.setLayoutParams(layoutParams);
                        break;

                }
            }
            /////////////////////ŁĄCZENIE ELEMENTÓW////////////////////////////////////////////////
            if(tryb ==1)                        //2  5dluuugo  3                          2   5   3
            {
                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_BUTTON_PRESS:
                        //Toast.makeText(getApplicationContext(), "działa_click1", Toast.LENGTH_SHORT).show();
                        break;

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        _xDelta = X - lParams.leftMargin;
                        _yDelta = Y - lParams.topMargin;


                        if(second_click==0)
                        {
                            first_x= (int)view.getX();

                            first_y=(int)view.getY();
                            second_click=1;
                        }
                        else if(second_click==1) {
                            //Toast.makeText(getApplicationContext(), "działa_click2", Toast.LENGTH_SHORT).show();
                            tworz_connect2(j, (int)view.getX(), (int)view.getY(), first_x, first_y);
                            second_click=0;
                            j++;
                        }
                        break;
                //    case MotionEvent.ACTION_UP:
                  //      Toast.makeText(getApplicationContext(), "działa_click3", Toast.LENGTH_SHORT).show();
                    //    break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        Toast.makeText(getApplicationContext(), "działa_click4", Toast.LENGTH_SHORT).show();
                        break;
                 //   case MotionEvent.ACTION_POINTER_UP:
                 //       Toast.makeText(getApplicationContext(), "działa_click5", Toast.LENGTH_SHORT).show();
                 //       break;
            //        case MotionEvent.ACTION_MOVE:
            //            Toast.makeText(getApplicationContext(), "działa_click6", Toast.LENGTH_SHORT).show();
             //           break;

                }

            }
                rootLayout.invalidate();
                return true;



        }
    }


        /////////////////////////////////////////SWIPE/////////////////////////////////////////////////
        private GestureDetectorCompat gestureDetectorCompat;



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        //handle 'swipe left' action only

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

         /*
         Toast.makeText(getBaseContext(),
          event1.toString() + "\n\n" +event2.toString(),
          Toast.LENGTH_SHORT).show();
         */

            if(event2.getY() < event1.getY()){
                makeText(getBaseContext(),"Wykryto swipe: Wybierz element", Toast.LENGTH_SHORT).show();

                //switch another activity
                Intent intent = new Intent(SchematicsEditor.this, Switching_Elements.class);
                startActivityForResult(intent, 1);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_in_up);
            }

            return true;
        }
    }
}








