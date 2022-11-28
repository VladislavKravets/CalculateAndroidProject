package com.example.calculateandroidproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private StringBuilder textViewNumber = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout_activity);
        textView = findViewById(R.id.textView);
        textView.setText("");
        System.out.println(findViewById(R.id.layout).getClass());
        System.out.println(findViewById(R.id.layout).getClass() == GridLayout.class);

        if (findViewById(R.id.layout).getClass() == GridLayout.class) {
            GridLayout gridLayout = findViewById(R.id.layout);
            for (int i = 0; i < gridLayout.getChildCount(); i++) {
                findViewById(gridLayout.getChildAt(i).getId()).setOnClickListener(this);
            }
        }
        if (findViewById(R.id.layout).getClass() == TableLayout.class) {
            TableLayout tableLayout = findViewById(R.id.layout);
            for (int i = 0; i < tableLayout.getChildCount(); i++) {
                TableRow row = (TableRow) tableLayout.getChildAt(i);
                for (int j = 0; j < row.getChildCount(); j++) {
                    row.getChildAt(j).setOnClickListener(this);
                }
            }
        }
        if (findViewById(R.id.layout).getClass() == RelativeLayout.class) {
            RelativeLayout relativeLayout = findViewById(R.id.layout);
            for (int i = 0; i < relativeLayout.getChildCount(); i++) {
                findViewById(relativeLayout.getChildAt(i).getId()).setOnClickListener(this);
            }
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.num1_button: {
                textViewNumber.append(1);
            }
            break;
            case R.id.num2_button: {
                textViewNumber.append(2);
            }
            break;
            case R.id.num3_button: {
                textViewNumber.append(3);
            }
            break;
            case R.id.num4_button: {
                textViewNumber.append(4);
            }
            break;
            case R.id.num5_button: {
                textViewNumber.append(5);
            }
            break;
            case R.id.num6_button: {
                textViewNumber.append(6);
            }
            break;
            case R.id.num7_button: {
                textViewNumber.append(7);
            }
            break;
            case R.id.num8_button: {
                textViewNumber.append(8);
            }
            break;
            case R.id.num9_button: {
                textViewNumber.append(9);
            }
            break;
            case R.id.num0_button: {
                textViewNumber.append(0);
            }
            break;
            case R.id.point_button: {
                textViewNumber.append(".");
            }
            break;
            case R.id.clear_button: {
                textViewNumber = new StringBuilder();
            }
            break;
            case R.id.oneNumDelete_button: {
                if (textViewNumber.length() > 0)
                    textViewNumber.delete(textViewNumber.length() - 1, textViewNumber.length());
            }
            break;
            case R.id.percent_button: {
                textViewNumber.append("%");
            }
            break;
            case R.id.addition_button: {
                textViewNumber.append("+");
            }
            break;
            case R.id.multiply_button: {
                textViewNumber.append("*");
            }
            break;
            case R.id.minus_button: {
                textViewNumber.append("-");
            }
            break;
            case R.id.division_button: {
                textViewNumber.append("/");
            }
            break;
            case R.id.equal_button: {
                textViewNumber = new StringBuilder(
                        new Calculator(textViewNumber.toString()).getResult());
            }
            break;
        }
        textView.setText(textViewNumber);
    }
}