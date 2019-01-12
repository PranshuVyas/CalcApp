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
    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnTen;
    Button btnZero;



    private SharedPreferences sharedPref;

    public static final String SHAREDPREFENCE_NAME = "CalcApp";
    public static final String KEY_VALUE_LEFT = "value_left";
    public static final String KEY_VALUE_RIGHT = "value_right";
    public static final String ADD ="add";
    public static final String SUBTRACT = "subtract";
    public static final String MULTIPLY = "multiply";
    public static final String DIVIDE = "divide";
    public static final String MOD = "mod";

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
        performOperation(ADD);
    }

    @OnClick(R.id.btn_subtract)
    public void subtract() {
        performOperation(SUBTRACT);
    }

    @OnClick(R.id.btn_multiply)
    public void multiply() {
        performOperation(MULTIPLY);
    }

    @OnClick(R.id.btn_divide)
    public void divide() {
      performOperation(DIVIDE);
    }

    @OnClick(R.id.btn_mod)
    public void mod() {
        performOperation(MOD);
    }

    @OnClick(R.id.btn_clear)
    public void clear() {
            SharedPreferences.Editor prefEditor = sharedPref.edit();
            prefEditor.putString(KEY_VALUE_LEFT, "").apply();
            prefEditor.putString(KEY_VALUE_RIGHT, "").apply();
            etxLeftValue.getText().clear();
            etxRightValue.getText().clear();
            txtResult.setText("");
            txtOperation.setText("");
    }

    @OnClick(R.id.btn_one)
    public void one(){
        if (etxLeftValue.getText().toString().isEmpty()){
            etxLeftValue.setText("1");
        }
        else{
            etxRightValue.setText("1");
        }
    }

    @OnClick(R.id.btn_two)
    public void two(){
        if (etxLeftValue.getText().toString().isEmpty()){
            etxLeftValue.setText("2");
        }
        else{
            etxRightValue.setText("2");
        }
    }
    @OnClick(R.id.btn_three)
    public void three(){
        if (etxLeftValue.getText().toString().isEmpty()){
            etxLeftValue.setText("3");
        }
        else{
            etxRightValue.setText("3");
        }
    }
    @OnClick(R.id.btn_four)
    public void four(){
        if (etxLeftValue.getText().toString().isEmpty()){
            etxLeftValue.setText("4");
        }
        else{
            etxRightValue.setText("4");
        }
    }
    @OnClick(R.id.btn_five)
    public void five(){
        if (etxLeftValue.getText().toString().isEmpty()){
            etxLeftValue.setText("5");
        }
        else{
            etxRightValue.setText("5");
        }
    }
    @OnClick(R.id.btn_six)
    public void six(){
        if (etxLeftValue.getText().toString().isEmpty()){
            etxLeftValue.setText("6");
        }
        else{
            etxRightValue.setText("6");
        }
    }
    @OnClick(R.id.btn_seven)
    public void seven(){
        if (etxLeftValue.getText().toString().isEmpty()){
            etxLeftValue.setText("7");
        }
        else{
            etxRightValue.setText("7");
        }
    }
    @OnClick(R.id.btn_eight)
    public void eight(){
        if (etxLeftValue.getText().toString().isEmpty()){
            etxLeftValue.setText("8");
        }
        else{
            etxRightValue.setText("8");
        }
    }
    @OnClick(R.id.btn_nine)
    public void nine(){
        if (etxLeftValue.getText().toString().isEmpty()){
            etxLeftValue.setText("9");
        }
        else{
            etxRightValue.setText("9");
        }
    }

    @OnClick(R.id.btn_zero)
    public void zero(){
        if (etxLeftValue.getText().toString().isEmpty()){
            etxLeftValue.setText("0");
        }
        else{
            etxRightValue.setText("0");
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

    private void performOperation(String operation){
        double firstValue = 0;
        double secondValue = 0;
        double result = 0;
        if(isEmpty())
            Toast.makeText(this, "Invalid Entry", Toast.LENGTH_LONG).show();
        else {
            firstValue = Integer.parseInt(etxLeftValue.getText().toString());
            secondValue = Integer.parseInt(etxRightValue.getText().toString());

            if (operation == ADD) {
                result = firstValue + secondValue;
                txtOperation.setText("+");
            } else if (operation == SUBTRACT) {
                result = firstValue - secondValue;
                txtOperation.setText("-");
            } else if (operation == MULTIPLY) {
                result = firstValue * secondValue;

                txtOperation.setText("X");
            } else if (operation == DIVIDE) {
                result = firstValue / secondValue;

                txtOperation.setText("/");
            } else if (operation == MOD) {
                result = firstValue % secondValue;
                txtOperation.setText("mod");

            }
            savePreference();
            txtResult.setText(Double.toString(result));
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