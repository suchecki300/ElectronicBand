package pl.wat.wel.projekt.pumo.electronicband;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import pl.wat.wel.projekt.pumo.electronicband.Dictionary.FragmentPagerAdapter;

public class DictionarysActivity extends AppCompatActivity {

    TextView buttonElectronicElements;
    TextView buttonChips;
    TextView buttonCommonTerms;
    TextView buttonWorkshop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionarys);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
