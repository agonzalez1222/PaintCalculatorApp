package net.androidbootcamp.paintcalculatorapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    double feetSquaredPerGallon = 250;
    double heightFt;
    double distanceFt;
    double result;
    String gallonPaint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText inputHeight = findViewById(R.id.inputHeight);
        final EditText inputDistance = findViewById(R.id.inputDiatance);
        final Spinner color = findViewById(R.id.txtPaint);
        Button calcGallons = findViewById(R.id.btnCost);
        calcGallons.setOnClickListener(new View.OnClickListener()
        {
            final TextView output = findViewById(R.id.textResult);
            @Override
            public void onClick(View v)
            {
                heightFt = Integer.parseInt(inputHeight.getText().toString());
                distanceFt = Integer.parseInt(inputDistance.getText().toString());
                result = (heightFt * distanceFt) / feetSquaredPerGallon;
                DecimalFormat currency = new DecimalFormat("###,###.##");
                gallonPaint = color.getSelectedItem().toString();
                output.setText("Color of Paint: " + gallonPaint + ", number of gallons: " + currency.format(result));
            }
        });
    }

}
