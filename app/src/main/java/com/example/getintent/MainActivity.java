package com.example.getintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.mainactivityId);
        textView=(TextView) findViewById(R.id.TextViewid);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });

        AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(MainActivity.this);
        alertdialogbuilder.setMessage("Do you want to exit.");
        alertdialogbuilder.setTitle("this is title.");
        alertdialogbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1) {
            String value = data.getStringExtra("key");
            textView.setText(value);
        }
    }



}
