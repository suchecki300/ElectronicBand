package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Courses extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        Context context = getApplicationContext();
        CharSequence text = "Dotknij nazwy lub obrazka aby przejsc do kursu";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void ard1OnClick(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_arduino1)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void ard1OnClick2(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_arduino1)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void ard2OnClick(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_arduino2)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void ard2OnClick2(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_arduino2)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void robOnClick(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_robotow)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void robOnClick2(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_robotow)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void ediOnClick(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_edison)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void ediOnClick2(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_edison)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void elek1OnClick(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_elektroniki1)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void elek1OnClick2(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_elektroniki1)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void elek2OnClick(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_elektroniki2)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void elek2OnClick2(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_elektroniki2)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void stmf4OnClick(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_stmf4)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void stmf4OnClick2(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_stmf4)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void stm32OnClick(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_stm32)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void stmf32OnClick2(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_stm32)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void lutOnClick(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_lutowania)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void lutOnClick2(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_lutowania)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void eagOnClick(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_eagle)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void eagOnClick2(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_eagle)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void cyfrOnClick(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_cyfrowki)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void cyfrOnClick2(View view) {
        Uri uri = Uri.parse(getString(R.string.kurs_cyfrowki)); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


}
