package com.calc.simple.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    //Ids of all numeric buttons
    private int[] numericbuttons = {R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.zero};

    //Ids of all operator buttons
    private int[] operatorbuttons = {R.id.plus, R.id.minus, R.id.multiply, R.id.divide};

    //TextView for output
    private TextView output1, output2;

    //Checks whether last key is numeric or not
    private boolean lastNumeric;

    //Checks whether current state is in error or not
    private boolean stateError;

    //If true, donot allow another dot as input
    private boolean lastDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Find textView to display output
        output1 = (TextView) findViewById(R.id.output1);
        output2 = (TextView) findViewById(R.id.output2);
        // Find and set OnClickListener to numeric buttons
        setNumericOnClickListener();
        // Find and set OnClickListener to operator buttons, equal button and decimal point button
        setOperatorOnClickListener();
        

    }

    private void setNumericOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                if(stateError){
                    output2.setText(button.getText());
                    stateError = false;
                }
                else {
                    output2.append(button.getText());
                }

                lastNumeric = true;
            }
        };

        for(int id : numericbuttons){
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setOperatorOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(lastNumeric && !stateError){
                    Button button = (Button) v;
                    if(output1.getText().toString() != ""){
                        output2.setText(output1.getText().toString());
                    }
                    output2.append(button.getText());
                    lastNumeric = false;
                    lastDot = false;
                }
            }
        };

        for(int id : operatorbuttons){
            findViewById(id).setOnClickListener(listener);
        }

        findViewById(R.id.dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastNumeric && !stateError && !lastDot){
                    output2.append(".");
                    lastNumeric = false;
                    lastDot = true;
                }
            }
        });

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = output2.getText().toString();
                if(a.length() > 1){
                    a = a.substring(0, a.length()-1);
                    output2.setText(a);
                }
                else{
                    output1.setText("");
                    output2.setText("");
                    lastNumeric = false;
                    lastDot = false;
                    stateError = false;
                }
               /* output1.setText("");
                output2.setText("");*/


            }
        });

        findViewById(R.id.equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEqual();
            }
        });
    }

    private void onEqual() {

        if(lastNumeric && !stateError){
            String txt = output2.getText().toString();

            Expression  expression = new ExpressionBuilder(txt).build();

            try{
                double result = expression.evaluate();
                output1.setText(Double.toString(result));
                lastDot = true;
            }
            catch (ArithmeticException e){
                output1.setText("Error");
                stateError = true;
                lastNumeric = false;
            }

        }
    }
}




