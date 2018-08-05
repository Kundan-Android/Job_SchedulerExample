package com.kundankishore.job_schedulerexample;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int JOB_ID = 700;
    private JobScheduler jobScheduler;
    private JobInfo jobInfo;
    private Button startJob;
    private Button stopJob;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startJob = findViewById(R.id.b1);
        stopJob = findViewById(R.id.b2);
        context = MainActivity.this;
        ComponentName componentName = new ComponentName(context,MJobScheduler.class);
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID,componentName);

        builder.setPeriodic(5000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);

        jobInfo = builder.build();
        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        startJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jobScheduler.schedule(jobInfo);
                Toast.makeText(MainActivity.this, "Job Scheduled...", Toast.LENGTH_SHORT).show();
            }
        });
        stopJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jobScheduler.cancel(JOB_ID);
                Toast.makeText(MainActivity.this, "Job Cancelled...", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

