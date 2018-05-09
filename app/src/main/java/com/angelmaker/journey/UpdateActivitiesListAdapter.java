package com.angelmaker.journey;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AngelPlayer on 5/8/2018.
 */

public class UpdateActivitiesListAdapter extends RecyclerView.Adapter<UpdateActivitiesListAdapter.ActivityViewHolder> {

    class ActivityViewHolder extends RecyclerView.ViewHolder {
        private final TextView activityItemView;

        private ActivityViewHolder(View itemView) {
            super(itemView);
            activityItemView = itemView.findViewById(R.id.textView);
        }
    }

        private final LayoutInflater inflater;
        private List<ActivityInstance> activities; // Cached copy of words


    UpdateActivitiesListAdapter(Context context) { inflater = LayoutInflater.from(context); }

        @Override
        public ActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = inflater.inflate(R.layout.recyclerview_manage_activities, parent, false);
            return new ActivityViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ActivityViewHolder holder, int position) {
            if (activities != null) {
                ActivityInstance current = activities.get(position);
                holder.activityItemView.setText(current.getActivity());
            } else {
                // Covers the case of data not being ready yet.
                holder.activityItemView.setText("No Activities");
            }
        }

        void setActivities(List<ActivityInstance> newActivities){
            activities = newActivities;
            notifyDataSetChanged();
        }

        // getItemCount() is called many times, and when it is first called,
        // mWords has not been updated (means initially, it's null, and we can't return null).
        @Override
        public int getItemCount() {
            if (activities != null)
                return activities.size();
            else return 0;
        }
}

