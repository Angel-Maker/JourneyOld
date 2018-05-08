package com.angelmaker.journey;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class UpdateActivities extends AppCompatActivity {

    //private static final int REQUEST_CODE_NEW_ACTIVITY = 1000;
    private TextView ActivitiesTV;
    private ActivityViewModel activityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_activities);

        activityViewModel = ViewModelProviders.of(this).get(ActivityViewModel.class);

        activityViewModel.getAllActivites().observe(this, new Observer<List<ActivityInstance>>() {
            @Override
            public void onChanged(@Nullable final List<ActivityInstance> activities) {
                // Update the cached copy of the words in the adapter.
                //ActivitiesTV.setText(activityies);
                String wordList = "";

                for(int i = 0; i < activities.size(); i++){
                    Log.i("ChangeOne",activities.get(i).getActivity());
                    wordList = wordList + activities.get(i).getActivity() + "\n";
                }

                Log.i("ChangeCheck", wordList);
            }
        });
    }






    public void newActivityBtn(View view) {
        Intent newActivity = new Intent(this, NewActivity.class);
        startActivity(newActivity);
        //startActivityForResult(newActivity, REQUEST_CODE_NEW_ACTIVITY);
    }

}
