package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyText;
    Button btnTop;
    Button btnBot;

    int i = 1;

    int storyNr;
    int ans1Nr;
    int ans2Nr;

    final int arrStory[] = {
            R.string.T1_Story,
            R.string.T2_Story,
            R.string.T3_Story,
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End,
    };

    final int arrBtnTop [] = {
            R.string.T1_Ans1,
            R.string.T2_Ans1,
            R.string.T3_Ans1
    };

    final int arrBtnBot [] = {
            R.string.T1_Ans2,
            R.string.T2_Ans2,
            R.string.T3_Ans2
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyText = findViewById(R.id.storyTextView);
        btnTop = findViewById(R.id.buttonTop);
        btnBot = findViewById(R.id.buttonBottom);

        storyText.setText(arrStory[storyNr]);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            updateQuestion();    }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        btnBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            updateQuestion();

            }
        });

    }

    private void updateQuestion(){
        //i == storyLevel

        //T1 Story solution
        if (i==1 & btnTop.isPressed()){
            changeStory(2);

        }
        else if (i==1 & btnBot.isPressed()){
            changeStory(1);

        }
        else if (i==2 & btnTop.isPressed()){
            changeStory(1);

        }
        else if (i==2 & btnBot.isPressed()){
            changeStory(2);

        }
        else if (i==3 & btnTop.isPressed()){
            changeStory(3);

        }
        else if (i==3 & btnBot.isPressed()){
            changeStory(2);

        }
    }

    private void changeStory(int storyLevelChange){
        storyNr = (storyNr + storyLevelChange) % arrStory.length;
        storyText.setText(arrStory[storyNr]);

        if(storyNr >=1 & storyNr <3){
            ans1Nr = (ans1Nr + storyLevelChange) % arrBtnTop.length;
            btnTop.setText(arrBtnTop[ans1Nr]);

            ans2Nr = (ans2Nr + storyLevelChange) % arrBtnBot.length;
            btnBot.setText(arrBtnBot[ans2Nr]);
        }
        else{
            btnTop.setVisibility(View.GONE);
            btnBot.setVisibility(View.GONE);
        }
        i = storyNr + 1;
    }
}
