package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private String numberInString;
    private String takeUserInput;
    private int score;
    private int number;
    private TextView UG;

    public void on_button_click(View view)
    {
        diceRoll();
    }
    public void on_icebreaker_click(View view)
    {
        icebreaker();
    }

    public void diceRoll()
    {
        roll_the_dice();
        TextView tv = this.findViewById(R.id.ClickButton);
        tv.setText(numberInString);
        UserInput();
        UserGuess();
    }

    public void icebreaker()
    {
        roll_the_dice();
        number = number -1;
        TextView IceBreaker_Button = this.findViewById(R.id.icebreakerButton);
        ArrayList<String> questions = new ArrayList<String>();

        questions.add("If you could go anywhere in the world, where would you go?");
        questions.add("If you were stranded on a desert island, what three things would you want to take with you?");
        questions.add("If you could eat only one food for the rest of your life, what would that be?");
        questions.add("If you won a million dollars, what is the first thing you would buy?");
        questions.add("If you could spaned the day with one fictional character, who would it be?");
        questions.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");

        IceBreaker_Button.setText(questions.get(number));
    }

    public void roll_the_dice()
    {
        Random r = new Random();
        number = r.nextInt(6) +1;
        numberInString = Integer.toString(number);
    }

    public void UserInput()
    {
        EditText userInput = this.findViewById(R.id.user_input);
        takeUserInput = userInput.getText().toString();
    }

    public void UserGuess() {
        UG = this.findViewById(R.id.congratulations);

        if (takeUserInput.equals(numberInString))
        {
            UG.setText("Congratulation!");
            score++;
        }

        else
        {
            UG.setText(" ");
        }
        TextView Score = this.findViewById(R.id.Score_id);
        Score.setText(Integer.toString(score));
    }
}
