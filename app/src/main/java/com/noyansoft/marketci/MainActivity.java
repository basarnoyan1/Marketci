package com.noyansoft.marketci;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ConstraintLayout con1 = (ConstraintLayout) findViewById(R.id.calc_con);
        final EditText fiyat = (EditText) findViewById(R.id.editText3);
        final EditText gr_adet = (EditText) findViewById(R.id.editText);
        final TextView txt1 = (TextView) findViewById(R.id.textView5);
        final TextView txt2 = (TextView) findViewById(R.id.textView6);
        final TextView txt0 = (TextView) findViewById(R.id.textView4);
        final TextView txtg = (TextView) findViewById(R.id.textView8);
        final Button button = (Button) findViewById(R.id.button);
        final Switch sw = (Switch) findViewById(R.id.switch1);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    txt0.setText("Gram");
                    txt1.setText("Birim Fiyat (Gram): ");
                    txt2.setText("Birim Fiyat (Kilogram): ");
                    txtg.setText("g");
                    txtg.setTextSize(24);
                } else {
                    txt0.setText("Adet");
                    txt1.setText("Birim Fiyat (Adet): ");
                    txt2.setText("Birim Fiyat (10 Adet): ");
                    txtg.setText("adet");
                    txtg.setTextSize(12);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(sw.isChecked() == false) {
                    float floatf = Float.parseFloat(fiyat.getText().toString());
                    int intg = Integer.parseInt(gr_adet.getText().toString());
                    String s1 = String.format("%.2f",floatf / intg);
                    txt1.setText("Birim Fiyat (Gram): " + s1 + " ₺");
                    String s2 = String.format("%.2f", floatf / intg * 1000);
                    txt2.setText("Birim Fiyat (Kilogram): " + s2 + " ₺");
                } else {
                    float floatf = Float.parseFloat(fiyat.getText().toString());
                    int intg = Integer.parseInt(gr_adet.getText().toString());
                    String s1 = String.format("%.2f",floatf / intg);
                    txt1.setText("Birim Fiyat (Adet): " + s1 + " ₺");
                    String s2 = String.format("%.2f",floatf / intg * 10);
                    txt2.setText("Birim Fiyat (10 Adet): " + s2 + " ₺");
                }
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Intent in;
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                //mTextMessage.setText(R.string.title_home);
                                con1.setVisibility(View.VISIBLE);
                                return true;
                            case R.id.navigation_dashboard:
                                in = new Intent(getBaseContext(),ListActivity.class);
                                startActivity(in);
                                overridePendingTransition(0, 0);
                                con1.setVisibility(View.INVISIBLE);
                                return true;
                            case R.id.navigation_camera:
                                //mTextMessage.setText(R.string.title_notifications);
                                con1.setVisibility(View.INVISIBLE);
                                return true;
                        }
                        return false;
                    }
                });
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

    }
}
