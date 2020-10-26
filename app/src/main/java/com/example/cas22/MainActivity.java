package com.example.cas22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button btStart;
    private Button btStop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btStart=findViewById(R.id.btStart);
        btStop=findViewById(R.id.bStop);
        editText=findViewById(R.id.edText);

        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMyService();
            }
        });

        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMyService();
            }
        });


    }



    private void startMyService(){
        String msg=editText.getText().toString();
        Intent intent=new Intent(this,MyService.class);
        intent.putExtra(MyService.MSG_TAG,msg);
        ContextCompat.startForegroundService(this,intent);

    }
    private void stopMyService(){
        Intent intent=new Intent(this,MyService.class);
        stopService(intent);

    }

}