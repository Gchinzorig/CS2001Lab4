package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
    private EditText textfield;
    private TextView warning;
    private String userInput;

    public void save_on_click (View view)
    {
        textfield = this.findViewById(R.id.user_input2);
        warning = this.findViewById(R.id.warning);

        userInput = textfield.getText().toString();

        if(!userInput.isEmpty())
        {
            sendData(userInput);
        }
        else
        {
            warning.setText("Textfield cannot be empty! ");
        }
    }

    public void cancel_on_click(View view)
    {
        finish();
    }

    public void sendData(String newRule)
    {
        Intent it = new Intent(this, MainActivity.class);
        it.putExtra("rule", newRule);
        startActivity(it);
    }

}
