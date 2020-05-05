package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnStart,btnStop;
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        tvContent = findViewById(R.id.tvContent);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CountTask countTask = new CountTask();
                countTask.execute(100000L);
//                /*This is non-UI thread*/
//                Thread thread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Thread.sleep(5000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                tvContent.setText("Counting Done!");
//                            }
//                        });
//                    }
//                });
//                thread.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Timer Stopped ",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    class CountTask extends AsyncTask<Long,Double,String>{

        /*Runs on Main Thread*/
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvContent.setText("Counting Started");
        }

        /*Runs on Background Thread*/
        @Override
        protected String doInBackground(Long... longs) {

            Long countThreshold = longs[0];/*If there is only one "Long Variable" present*/
//            try {
//                Thread.sleep(countThreshold);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            /*or*/
            for (int i = 0; i < countThreshold ; i++){
                /*Here we can also show How onProgress method works*/
                if(i%10000 == 0){
                    publishProgress((double) i);
                }
            }
//            /*For more than one long variable*/
//            for (int i = 0; i < longs.length ; i++){
//                long currentCount = longs[i];
//            }
            return "Counting Till " + countThreshold + " done";
        }

        /*Runs on Main Thread*/
        @Override
        protected void onProgressUpdate(Double... values) {
            super.onProgressUpdate(values);

            Double currentProgress = values[0];
            Toast.makeText(MainActivity.this,
                    "Count is : " + currentProgress,
                    Toast.LENGTH_SHORT).show();
        }

        /*Runs on Main Thread*/
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvContent.setText(s);
        }

    }

}
