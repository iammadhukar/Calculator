package com.preprepare.calc;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class MyCalculation {

    private static final String TAG = "MyCalculation";

    private MainActivity mainActivity;
    private String currentDigit="";
    private int firstIntValue,secondIntValue,noOfInput;
    private double firstDoubleValue, secondDoubleValue;
    private String operation="";
    private Context context;

    public MyCalculation(MainActivity mainActivity, Context context) {
        this.mainActivity=mainActivity;
        this.context = context;
    }

    protected void onDigitPressed(String digit){
        currentDigit+=digit;
        mainActivity.textView.setText(currentDigit);
//        operation = "digit";
    }

    protected void onCLetterPressed(){
        currentDigit=currentDigit.substring(0,currentDigit.length()-1);
        Log.d(TAG, "Value of current digit is : "+currentDigit);
        mainActivity.textView.setText(currentDigit);
        noOfInput=0;
    }

    protected void onACLetterPressed(){
        Log.d(TAG, "AC pressed");
        currentDigit="";
        firstDoubleValue=secondDoubleValue=0;
        firstIntValue=secondIntValue=0;
        noOfInput=0;
        mainActivity.textView.setText(currentDigit);
    }

    protected void calculation(String action){
        switch (action){
            case "add":
                Log.d(TAG, "Inside add");
                if (noOfInput==0) {
                    if(currentDigit.contains(".")) {
                        Log.d(TAG, "Current double is: " + currentDigit);
                        firstDoubleValue = Double.valueOf(currentDigit);
                    }
                    else {
                        Log.d(TAG, "Current int is: " + currentDigit);
                        firstIntValue = Integer.valueOf(currentDigit);
                        Log.d(TAG, "First value is " + firstIntValue);
                    }
                    noOfInput = 1;
                }
                else if(noOfInput==1) {
//                    if(currentDigit.contains("."))
//                        secondDoubleValue = Double.valueOf(currentDigit);
//                    else
//                        secondIntValue=Integer.valueOf(currentDigit);

                }
                currentDigit="";
                mainActivity.textView.setText(currentDigit);
                operation=action;

                break;

            case "subtract":
                if (noOfInput==0) {
                    if(currentDigit.contains("."))
                        firstDoubleValue = Double.valueOf(currentDigit);
                    else
                        firstIntValue=Integer.valueOf(currentDigit);
                    //firstValue = Double.valueOf(currentDigit);
                    noOfInput = 1;
                }
                else if(noOfInput==1) {
                    if(currentDigit.contains("."))
                        secondDoubleValue = Double.valueOf(currentDigit);
                    else
                        secondIntValue=Integer.valueOf(currentDigit);
                }
                currentDigit="";
                Log.d(TAG, "Currentdigit is: " + currentDigit);
                mainActivity.textView.setText(currentDigit);
                operation=action;

                break;

            case "multiply" :
                if (noOfInput==0) {
                    if(currentDigit.contains("."))
                        firstDoubleValue = Double.valueOf(currentDigit);
                    else
                        firstIntValue=Integer.valueOf(currentDigit);
                    //firstValue = Double.valueOf(currentDigit);
                    noOfInput = 1;
                }

                currentDigit="";
                Log.d(TAG, "Currentdigit is: " + currentDigit);
                mainActivity.textView.setText(currentDigit);
                operation=action;

                break;

            case "divide" :
                if (noOfInput==0) {
                    if(currentDigit.contains("."))
                        firstDoubleValue = Double.valueOf(currentDigit);
                    else
                        firstIntValue=Integer.valueOf(currentDigit);
                    //firstValue = Double.valueOf(currentDigit);
                    noOfInput = 1;
                }

                currentDigit="";
                Log.d(TAG, "Currentdigit is: " + currentDigit);
                mainActivity.textView.setText(currentDigit);
                operation=action;

                break;

            case "percent" :
                if (noOfInput==0) {
                    Toast.makeText(context, "Please enter the digit first", Toast.LENGTH_LONG).show();
//                    if(currentDigit.contains("."))
//                        firstDoubleValue = Double.valueOf(currentDigit);
//                    else
//                        firstIntValue=Integer.valueOf(currentDigit);
//                    //firstValue = Double.valueOf(currentDigit);
//                    noOfInput = 1;
                }else{
                    secondDoubleValue = Double.valueOf(currentDigit)/100.0;
                }

                currentDigit=String.valueOf(secondDoubleValue);
                Log.d(TAG, "Currentdigit is: " + currentDigit);
                mainActivity.textView.setText(currentDigit);
                //operation=action;

                break;
        }
    }

    protected void beforeCalculation(){
        Log.d(TAG, "beforeCalculation is called");
        if(currentDigit.contains(".")) {
            secondDoubleValue = Double.valueOf(currentDigit);
        }
        else {
            secondIntValue = Integer.valueOf(currentDigit);
        }

        Log.d(TAG, "First value is "+firstIntValue);
        Log.d(TAG, "second value is "+secondIntValue);
        Log.d(TAG, "second d value is "+secondDoubleValue);

        if(operation!="") {
                if (firstIntValue != 0) {
                    if (secondIntValue != 0) {
                        if (operation=="divide"){
                            firstDoubleValue = divide(firstIntValue, secondIntValue);
                            firstIntValue=secondIntValue=0;
                            secondDoubleValue=0;
                            currentDigit = String.valueOf(firstDoubleValue);
                        }else {
                            firstIntValue = onEqualsPressed(firstIntValue, secondIntValue, operation);
                            firstDoubleValue = secondDoubleValue = secondIntValue = 0;
                            Log.d(TAG, "First value is " + firstIntValue);
                            Log.d(TAG, "firstDoubleValue is " + firstDoubleValue);
                            Log.d(TAG, "secondDoubleValue is " + secondDoubleValue);
                            Log.d(TAG, "secondIntValue is " + secondIntValue);
                            currentDigit = String.valueOf(firstIntValue);
                        }
                    } else {
                        if (operation=="divide"){
                            firstDoubleValue=divide(firstIntValue, secondDoubleValue);
                            firstIntValue=secondIntValue=0;
                            secondDoubleValue=0;
                            currentDigit = String.valueOf(firstDoubleValue);
                        }else {
                            firstDoubleValue = onEqualsPressed(firstIntValue, secondDoubleValue, operation);
                            firstIntValue = 0;
                            secondDoubleValue = secondIntValue = 0;
                            Log.d(TAG, "First value is " + firstDoubleValue);
                            currentDigit = String.valueOf(firstDoubleValue);
                        }

                    }
                } else {
                    if (secondIntValue != 0) {
                        if (operation=="divide"){
                            firstDoubleValue=divide(firstDoubleValue, secondIntValue);
                            firstIntValue=secondIntValue=0;
                            secondDoubleValue=0;
                            currentDigit = String.valueOf(firstDoubleValue);
                        }else {
                            firstDoubleValue = onEqualsPressed(firstDoubleValue, secondIntValue, operation);
                            firstIntValue = 0;
                            secondDoubleValue = secondIntValue = 0;
                            currentDigit = String.valueOf(firstDoubleValue);
                        }
                    } else {
                        if (operation=="divide") {
                            firstDoubleValue = divide(firstDoubleValue, secondDoubleValue);
                            firstIntValue=secondIntValue=0;
                            secondDoubleValue=0;
                            currentDigit = String.valueOf(firstDoubleValue);
                        }else {
                            firstDoubleValue = onEqualsPressed(firstDoubleValue, secondDoubleValue, operation);
                            firstIntValue = 0;
                            secondDoubleValue = secondIntValue = 0;
                            currentDigit = String.valueOf(firstDoubleValue);
                        }
                    }
                }
        }
        mainActivity.textView.setText(currentDigit);
    }

    public double onEqualsPressed(double firstNumber, double secondNumber, String operation){
        Log.d(TAG, "Method with both double is called");
        Log.d(TAG, "First value is "+firstNumber);
        Log.d(TAG, "second value is "+secondNumber);
        double value = 0;
        switch (operation){
            case "add" :
                value= sum(firstNumber, secondNumber);
                //textView.setText(String.valueOf(value));
                break;
            case "subtract" :
                value = subtract(firstNumber, secondNumber);
                //textView.setText(String.valueOf(value));
                break;
            case "divide" :
                value = divide(firstNumber, secondNumber);
                if (value==0.01101100322)
                    mainActivity.textView.setText("Error");
                break;
            case "multiply" :
                value = multiply(firstNumber, secondNumber);
                break;

            case "percent" :

        }
        return value;
    }

    public int onEqualsPressed(int firstNumber, int secondNumber, String operation){
        Log.d(TAG, "Method with both int is called");
        Log.d(TAG, "First value is "+firstNumber);
        Log.d(TAG, "second value is "+secondNumber);
        int value = 0;
        switch (operation){
            case "add" :
                value= sum(firstNumber, secondNumber);
                break;
            case "subtract" :
                value = subtract(firstNumber, secondNumber);
                break;
            case "divide" :
                //value = divide(firstNumber, secondNumber);
                if (value==0.01101100322)
                    mainActivity.textView.setText("Error");
                break;
            case "multiply" :
                value = multiply(firstNumber, secondNumber);
                break;
        }
        return value;
    }

    private int sum(int firstNumber, int secondNumber){
        return firstNumber+secondNumber;
    }

    private double sum(double firstNumber, int secondNumber){
        return firstNumber+secondNumber;
    }

    private double sum(int firstNumber, double secondNumber){
        return firstNumber+secondNumber;
    }

    private double sum(double firstNumber, double secondNumber){
        return firstNumber+secondNumber;
    }

    private int subtract(int firstNumber, int secondNumber){
        return firstNumber-secondNumber;
    }

    private double subtract(double firstNumber, double secondNumber){
        return firstNumber-secondNumber;
    }

    private double divide(double firstNumber, double secondNumber){
        double value=0;
        try{
            value = firstNumber/secondNumber;
        }catch (ArithmeticException e){
            currentDigit="Error";
        }

//        if (secondNumber!=0){
//            return firstNumber/secondNumber;
//        }else
//            return 0.01101100322;
        return value;
    }

//    private double divide(int firstNumber, int secondNumber){
//        if (secondNumber!=0){
//            return firstNumber/secondNumber;
//        }else
//            return 0.01101100322;
//    }

    private double multiply(double firstNumber, double secondNumber){
        return firstNumber*secondNumber;
    }

    private int multiply(int firstNumber, int secondNumber){
        return firstNumber*secondNumber;
    }

}
