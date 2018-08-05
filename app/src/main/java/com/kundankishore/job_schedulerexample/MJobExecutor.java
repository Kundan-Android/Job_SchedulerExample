package com.kundankishore.job_schedulerexample;

import android.os.AsyncTask;

/**
 * Created by Caliber on 05-08-2018.
 */

public class MJobExecutor extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... voids) {
        return "Background long running task finishes....";
    }
}
