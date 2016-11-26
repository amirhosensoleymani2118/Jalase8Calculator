package com.example.amirhosein.jalase8calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn7;
    Button btn8;
    Button btn9;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn0;
    Button btnplus;
    Button btnminus;
    Button btnmint;
    Button btndivide;
    Button btnequal1;
    Button btnac;
    TextView Tvinp;
    double b1,b2;
    int opera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btntv();


    }

    //============================= BTN & TV ===============================

    private void btntv (){
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn0 = (Button) findViewById(R.id.btn0);
        btnplus = (Button) findViewById(R.id.btnplus);
        btnminus = (Button) findViewById(R.id.btnminus);
        btnmint = (Button) findViewById(R.id.btnmint);
        btndivide = (Button) findViewById(R.id.btndivide);
        btnequal1 = (Button) findViewById(R.id.btnequal1);
        btnac = (Button) findViewById(R.id.btnac);
        Tvinp = (TextView) findViewById(R.id.TVinp);

        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnplus.setOnClickListener(this);
        btnminus.setOnClickListener(this);
        btnmint.setOnClickListener(this);
        btndivide.setOnClickListener(this);
        btnequal1.setOnClickListener(this);
        btnac.setOnClickListener(this);


    }

    //========================== onClick & Switch ===========================

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn7:
                showtv("7" , false);
                break;
            case R.id.btn8:
                showtv("8" , false);
                break;
            case R.id.btn9:
                showtv("9" , false);
                break;
            case  R.id.btn4:
                showtv("4" , false);
                break;
            case R.id.btn5:
                showtv("5" , false);
                break;
            case R.id.btn6:
                showtv("6" , false);
                break;
            case R.id.btn1:
                showtv("1" , false);
                break;
            case R.id.btn2:
                showtv("2" , false);
                break;
            case R.id.btn3:
                showtv("3" , false);
                break;
            case R.id.btn0:
                showtv("0" , false);
                break;
            case R.id.btnplus:
                operationRead(1);
                break;
            case R.id.btnequal1:
                equal();
                break;
            case R.id.btnminus:
                operationRead(2);
                break;
            case R.id.btnmint:
                operationRead(3);
                break;
            case R.id.btndivide:
                operationRead(4);
                break;
            case R.id.btnac:
                Ac();
                break;
        }

    }

    //=========================== ac ======================================
    private void Ac(){
        Tvinp.setText("0");
        b1 = 0;
        opera = 0;
    }

    //=========================== equal ===================================
    private void equal(){
        switch (opera) {
            case 1:
                showtv(plus(b1,getTV()), true);
                break;
            case 2:
                showtv(minus(b1,getTV()), true);
                break;
            case 3:
                showtv(mint(b1,getTV()), true);
                break;
            case 4:
                showtv(divide(b1,getTV()), true);
        }
    }

    public double plus(double a, double b){
        return  a+b;
    }

    public double minus(double a , double b){
        return a-b;
    }
    public double mint(double a , double b){
        return a*b;
    }
    public double divide(double a , double b){
        return a/b;
    }

    //============================ Ready ====================================
    private void operationRead(int operation){
        opera = operation;
        b1 = getTV();
        Tvinp.setText("0");
    }
    private double getTV(){
        return Double.parseDouble(Tvinp.getText().toString());
    }

    //============================ Show TV =================================

    private void showtv(String inp , boolean alwaysshow) {
        realshow(inp , alwaysshow);

    }
    private void showtv(int inp , boolean alwaysshow) {
        String inp1 = String.valueOf(inp);
        realshow(inp1 , alwaysshow);

    }
    private void showtv(double inp , boolean alwaysshow) {
        realshow(String.valueOf(inp) , alwaysshow);

    }
    private void realshow(String inp , boolean alwaysshow){
        String currentTV = Tvinp.getText().toString();
        if (currentTV.equals("0") || alwaysshow){
            Tvinp.setText(inp);
        }else {
            Tvinp.append(inp);
        }

    }
}
