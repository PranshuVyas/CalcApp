package com.homeworkone.calcapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CalcActivity extends AppCompatActivity {
    @BindView(R.id.etx_leftvalue)
    EditText etxLeftValue;
    @BindView(R.id.etx_rightvalue)
    EditText etxRightValue;
    @BindView(R.id.txt_operation)
    TextView txtOperation;
    @BindView(R.id.txt_result)
    TextView txtResult;
    Button btnSum;
    Button btnSubtract;
    Button btnMultiply;
    Button btnDivide;
    Button btnMod;
    Button btnLog;
    Button btnClear;

    private SharedPreferences sharedPref;

    public static final String SHAREDPREFENCE_NAME = "CalcApp";
    public static final String KEY_VALUE_LEFT = "value_left";
    public static final String KEY_VALUE_RIGHT = "value_right";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        ButterKnife.bind(this);
        sharedPref = getSharedPreferences(SHAREDPREFENCE_NAME, MODE_PRIVATE);
        loadPreference();
    }


    @OnClick(R.id.btn_sum)
    public void sum() {
        if(isEmpty())
            Toast.makeText(this, "Invalid Entry", Toast.LENGTH_LONG).show();
        else {
            double leftValue = Integer.parseInt(etxLeftValue.getText().toString());
            double rightValue = Integer.parseInt(etxRightValue.getText().toString());
            double result = leftValue + rightValue;
            txtResult.setText("The result is : " + Double.toString(result));
            txtOperation.setText("+");
            savePreference();
        }
    }

    @OnClick(R.id.btn_subtract)
    public void subtract() {
        if(isEmpty())
            Toast.makeText(this, "Invalid Entry", Toast.LENGTH_LONG).show();
        else {
            double leftValue = Integer.parseInt(etxLeftValue.getText().toString());
            double rightValue = Integer.parseInt(etxRightValue.getText().toString());
            double result = leftValue - rightValue;
            txtResult.setText("The result is : " + Double.toString(result));
            txtOperation.setText("-");
            savePreference();
            loadPreference();
        }
    }

    @OnClick(R.id.btn_multiply)
    public void multiply() {
        if(isEmpty())
            Toast.makeText(this, "Invalid Entry", Toast.LENGTH_LONG).show();
        else {
            double leftValue = Integer.parseInt(etxLeftValue.getText().toString());
            double rightValue = Integer.parseInt(etxRightValue.getText().toString());
            double result = leftValue * rightValue;
            txtResult.setText("The result is : " + Double.toString(result));
            txtOperation.setText("X");
            savePreference();
        }
    }

    @OnClick(R.id.btn_divide)
    public void divide() {
        if(isEmpty())
            Toast.makeText(this, "Invalid Entry", Toast.LENGTH_LONG).show();
        else {
            double leftValue = Integer.parseInt(etxLeftValue.getText().toString());
            double rightValue = Integer.parseInt(etxRightValue.getText().toString());
            double result = (leftValue / rightValue);
            txtResult.setText("The result is : " + Double.toString(result));
            txtOperation.setText("/");
            savePreference();
        }
    }

    @OnClick(R.id.btn_mod)
    public void mod() {
        if(isEmpty())
            Toast.makeText(this, "Invalid Entry", Toast.LENGTH_LONG).show();
        else {
            double leftValue = Integer.parseInt(etxLeftValue.getText().toString());
            double rightValue = Integer.parseInt(etxRightValue.getText().toString());
            double result = (leftValue % rightValue);
            txtResult.setText("The result is : " + Double.toString(result));
            txtOperation.setText("mod");
            savePreference();
        }
    }

    @OnClick(R.id.btn_clear)
    public void clear() {
        if(isEmpty())
            Toast.makeText(this, "Invalid Entry", Toast.LENGTH_LONG).show();
        else {
            SharedPreferences.Editor prefEditor = sharedPref.edit();
            prefEditor.putString(KEY_VALUE_LEFT, "").apply();
            prefEditor.putString(KEY_VALUE_RIGHT, "").apply();
            etxLeftValue.getText().clear();
            etxRightValue.getText().clear();
            txtResult.setText("");
            txtOperation.setText("");
        }
    }

    public boolean isEmpty(){
        if (etxLeftValue.getText().toString().isEmpty() || etxRightValue.getText().toString().isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }


    private void savePreference() {
        SharedPreferences.Editor prefEditor = sharedPref.edit();
        prefEditor.putString(KEY_VALUE_LEFT, etxLeftValue.getText().toString()).apply();
        prefEditor.putString(KEY_VALUE_RIGHT, etxRightValue.getText().toString()).apply();
    }

    private void loadPreference(){
        String leftValue = sharedPref.getString(KEY_VALUE_LEFT, "");
        String rightValue = sharedPref.getString(KEY_VALUE_RIGHT, "");
        etxLeftValue.setText(leftValue);
        etxRightValue.setText(rightValue);
    }
}