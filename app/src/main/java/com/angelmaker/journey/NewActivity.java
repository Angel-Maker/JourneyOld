package com.angelmaker.journey;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.angelmaker.journey.activitylistsql.REPLY";
    EditText activityNameET;

    private ActivityViewModel activityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_activity);

        activityViewModel = ViewModelProviders.of(this).get(ActivityViewModel.class);

        activityNameET = findViewById(R.id.activityNameET);


        final Button button = findViewById(R.id.SubmitBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent replyIntent = new Intent();

                if (TextUtils.isEmpty(activityNameET.getText())) {
                    //setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String activityName = activityNameET.getText().toString();

                    ActivityInstance newActivity = new ActivityInstance(activityName);
                    activityViewModel.insert(newActivity);

                    //replyIntent.putExtra(EXTRA_REPLY, word);
                    //setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
