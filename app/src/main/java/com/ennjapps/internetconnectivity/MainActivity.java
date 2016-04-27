package com.ennjapps.internetconnectivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    int exitValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            exitValue = ipProcess.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (exitValue == 0){
            Toast.makeText(this,"Internet Connected",Toast.LENGTH_LONG).show();
    }else{
            Toast.makeText(this,"No Internet Connected",Toast.LENGTH_LONG).show();
        }


    }
}