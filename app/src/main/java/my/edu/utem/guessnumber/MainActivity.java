package my.edu.utem.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText guessEdit;
    TextView ansTextView;
    Button resetBtn, sendBtn;

    int number = 0;
    int numberOfTries;
    boolean gameOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guessEdit = findViewById(R.id.number_EditView);
        ansTextView = findViewById(R.id.ans_TextView);
        resetBtn = findViewById(R.id.reset_button);
        sendBtn = findViewById(R.id.send_button);

        initialiazeGame();
        Log.d("debug", "Number generated is "+number);
    }

    private void initialiazeGame() {
        number = (int)(Math.random()*100);
        numberOfTries = 3;
        gameOn = true;
        ansTextView.setText("");
        resetBtn.setVisibility(View.GONE);
        sendBtn.setVisibility(View.VISIBLE);
    }

    public void sendPressed(View view) {
        if (guessEdit.getText().toString().equals("")){
                Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_LONG).show();
        }

        else{
            numberOfTries --;

            if (Integer.parseInt(guessEdit.getText().toString()) > number) {
                ansTextView.setText("The number is too big");
            }

            else if (Integer.parseInt(guessEdit.getText().toString()) < number) {
                ansTextView.setText("The number is too small");
            }

            else {
                //Toast.makeText(MainActivity.this, "The number is correct", Toast.LENGTH_LONG).show();
                ansTextView.setText("Congratulation you win");
                gameOn = false;
                resetBtn.setVisibility(View.VISIBLE);
                sendBtn.setVisibility(View.GONE);
            }

            if (numberOfTries == 0 && gameOn){
                ansTextView.setText("Sorry you lost. The number is "+number);
                gameOn = false;
                resetBtn.setVisibility(View.VISIBLE);
                sendBtn.setVisibility(View.GONE);
            }
        }
    }

    public void resetPressed(View view) {
        initialiazeGame();
    }
}
