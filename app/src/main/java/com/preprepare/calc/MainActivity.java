package com.preprepare.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    TextView textView;
    private double firstValue=0, secondValue=0;
    private int firstIntValue=0, secondIntValue=0;
    private int noOfInput =0;
    private int count = 0;
    private String currentDigit= "" ;
    private String operation="digit";
    private String action="";
    private MyCalculation myClaculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myClaculation = new MyCalculation(MainActivity.this);

        Log.d(TAG,"Inside mainActivity");

        textView = findViewById(R.id.textView);
        findViewById(R.id.one).setOnClickListener(this);
        findViewById(R.id.two).setOnClickListener(this);
        findViewById(R.id.three).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
        findViewById(R.id.five).setOnClickListener(this);
        findViewById(R.id.six).setOnClickListener(this);
        findViewById(R.id.seven).setOnClickListener(this);
        findViewById(R.id.eight).setOnClickListener(this);
        findViewById(R.id.nine).setOnClickListener(this);
        findViewById(R.id.decimal).setOnClickListener(this);
        findViewById(R.id.zero).setOnClickListener(this);
        findViewById(R.id.doubleZero).setOnClickListener(this);
        findViewById(R.id.cLetter).setOnClickListener(this);
        findViewById(R.id.acLetter).setOnClickListener(this);
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.subtract).setOnClickListener(this);
        findViewById(R.id.multiply).setOnClickListener(this);
        findViewById(R.id.divide).setOnClickListener(this);
        findViewById(R.id.percent).setOnClickListener(this);
        findViewById(R.id.equals).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

//        if (operation.equals("add") || operation.equals("subtract") || operation.equals("multiply")
//                || operation.equals("divide")|| operation.equals("equals")
//                         ){
//            currentDigit = "";
//        }

        switch (view.getId()){
            case R.id.one :
                myClaculation.onDigitPressed("1");
                break;

            case R.id.two :
                myClaculation.onDigitPressed("2");
                break;

            case R.id.three :
                myClaculation.onDigitPressed("3");
                break;

            case R.id.four :
                myClaculation.onDigitPressed("4");
                break;

            case R.id.five :
                myClaculation.onDigitPressed("5");
                break;

            case R.id.six :
                myClaculation.onDigitPressed("6");
                break;

            case R.id.seven :
                myClaculation.onDigitPressed("7");
                break;

            case R.id.eight :
                myClaculation.onDigitPressed("8");
                break;

            case R.id.nine :
                myClaculation.onDigitPressed("9");
                break;

            case R.id.decimal :
                myClaculation.onDigitPressed(".");
                break;

            case R.id.zero :
                myClaculation.onDigitPressed("0");
                break;

            case R.id.doubleZero :
                myClaculation.onDigitPressed("00");
                break;

            case R.id.cLetter :
                //currentDigit= textView.getText().toString();
                myClaculation.onCLetterPressed();
                break;

            case R.id.acLetter :
                //currentDigit= textView.getText().toString();
                myClaculation.onACLetterPressed();
                break;

            case R.id.add :

                Log.d(TAG,"Add is pressed");
                //findViewById(R.id.add).setBackgroundColor(getResources().getColor(R.color.shadeOrange));
                myClaculation.calculation("add");
                //currentDigit= textView.getText().toString();

//                if (count==1) {
//                    if (firstIntValue != 0 && secondIntValue != 0) {
//                        firstIntValue = onEqualsPressed(firstIntValue, secondIntValue, "add");
//                        currentDigit = String.valueOf(firstIntValue);
//                    } else {
//                        firstValue = onEqualsPressed(firstValue, secondValue, "add");
//                        currentDigit = String.valueOf(firstValue);
//                    }
//                }

//                operation = "add";
//                action = "add";
//                count = 1;
                break;

            case R.id.subtract :

                Log.d(TAG,"Subtract is pressed");
                myClaculation.calculation("subtract");
                //currentDigit= textView.getText().toString();


//                if (count==1) {
//                    if (firstIntValue != 0 && secondIntValue != 0) {
//                        firstIntValue = onEqualsPressed(firstIntValue, secondIntValue, "subtract");
//                        currentDigit = String.valueOf(firstIntValue);
//                    } else {
//                        firstValue = onEqualsPressed(firstValue, secondValue, "subtract");
//                        currentDigit = String.valueOf(firstValue);
//                    }
//                }

//                if (count==1 && !operation.equals("subtract"))
//                    firstValue = onEqualsPressed(firstValue,secondValue,"subtract");
                //currentDigit = String.valueOf(firstValue);
//                textView.setText(currentDigit);
//                operation = "subtract";
//                action = "subtract";
//                count = 1;
                break;

            case R.id.multiply :
                if (noOfInput==0) {
                    firstValue = Double.valueOf(currentDigit);
                    noOfInput = 1;
                    Log.d(TAG, "First value is "+firstValue);
                }
                else if(noOfInput==1) {
                    secondValue = Double.valueOf(currentDigit);
                    Log.d(TAG, "Second value is "+secondValue);
                    //noOfInput = 0;
                }
                textView.setText(currentDigit);
                operation = "multiply";
                action = "multiply";
                break;

            case R.id.divide :
                if (noOfInput==0) {
                    firstValue = Double.valueOf(currentDigit);
                    noOfInput = 1;
                    Log.d(TAG, "First value is "+firstValue);
                }
                else if(noOfInput==1) {
                    secondValue = Double.valueOf(currentDigit);
                    Log.d(TAG, "Second value is "+secondValue);
                    //noOfInput = 0;
                }
                textView.setText(currentDigit);
                operation = "divide";
                action = "divide";
                break;

            case R.id.percent :
                currentDigit = String.valueOf(Double.valueOf(currentDigit)/100.0);
                Log.d(TAG, "Second value is "+secondValue);
                textView.setText(String.valueOf(secondValue));
                break;

            case R.id.equals :
                myClaculation.beforeCalculation();
                break;

            default :
                        break;
        }
    }




}
