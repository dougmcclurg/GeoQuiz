package com.example.amplify.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {

    private boolean answerIsTrue;
    private TextView answerTextView;
    private Button showAnswer;
    public static final String EXTRA_ANSWER_IS_TRUE ="com.example.amplify.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN ="com.example.amplify.geoquiz.answer_shown";

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        answerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        answerTextView = (TextView)findViewById(R.id.answerTextView);
        setAnswerShownResult(false);
        showAnswer = (Button)findViewById(R.id.showAnswerButton);
        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerIsTrue) {
                    answerTextView.setText(R.string.true_button);
                } else {
                    answerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });


    }
}
