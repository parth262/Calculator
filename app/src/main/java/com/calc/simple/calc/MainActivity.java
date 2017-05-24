package com.calc.simple.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    public Button one, two, three, four, five, six, seven, eight, nine, dot, zero, equals,  delete, divide, multiply, minus, plus;
    public TextView input1, input2;
    Double c;
    String a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization method initialized onCreate
        init();

        input();

        operation();



    }

    /*private void checkDot() {

        char last = a.charAt(a.length()-1);
        if(last == '.'){
            a+=0;
        }
    }*/

    //Initializing widgets
    private void init() {

        equals = (Button) id(R.id.equals);
        delete = (Button) id(R.id.delete);
        divide = (Button) id(R.id.divide);
        multiply = (Button) id(R.id.multiply);
        minus = (Button) id(R.id.minus);
        plus = (Button) id(R.id.plus);
        input1 = (TextView) id(R.id.input1);
        input2 = (TextView) id(R.id.input2);
        one = (Button) id(R.id.one);
        two = (Button) id(R.id.two);
        three = (Button) id(R.id.three);
        four = (Button) id(R.id.four);
        five = (Button) id(R.id.five);
        six = (Button) id(R.id.six);
        seven = (Button) id(R.id.seven);
        eight = (Button) id(R.id.eight);
        nine = (Button) id(R.id.nine);
        dot = (Button) id(R.id.dot);
        zero = (Button) id(R.id.zero);
        b = "";
    }

    private String input() {


        a = "";

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setText(a + "1");
                a = input1.getText().toString();

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setText(a + "2");
                a = input1.getText().toString();

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setText(a + "3");
                a = input1.getText().toString();

            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setText(a + "4");
                a = input1.getText().toString();

            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setText(a + "5");
                a = input1.getText().toString();

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setText(a + "6");
                a = input1.getText().toString();

            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setText(a + "7");
                a = input1.getText().toString();

            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setText(a + "8");
                a = input1.getText().toString();

            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setText(a + "9");
                a = input1.getText().toString();

            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setText(a + "0");
                a = input1.getText().toString();

            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setText(a + ".");
                a = input1.getText().toString();

            }
        });

            return a;
    }


        private void operation() {



            plus.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    //checkDot();
                    b = b + a + "+"; //To Store the first number displayed in textView  to aa
                    input2.setText(b);
                    input1.setText(input());
                    a = input1.getText().toString();



                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(a != "") {

                        input1.setText(a.replace(a.substring(a.length() - 1), ""));
                        a = input1.getText().toString();
                    }

                    else{

                        a = input2.getText().toString();
                        input2.setText("");
                        input1.setText(a);
                        input1.setText(a.replace(a.substring(a.length() - 1), ""));
                        a = input1.getText().toString();
                    }
                }
            });

            equals.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    c = Double.parseDouble(String.valueOf(b)) + Double.parseDouble(String.valueOf(a));
                    a = c.toString();
                    input2.setText("");
                    input1.setText(c.toString());
                }
            });

        }



    //Returns findViewById with just using id
    private View id(int id){
        return findViewById(id);
    }



}
