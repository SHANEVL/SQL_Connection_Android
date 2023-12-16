package com.example.sql_connection;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sql_connection.screens.Action1Activity;
import com.example.sql_connection.screens.Action2Activity;

import db.ConnectionHelper;

public class MainActivity extends AppCompatActivity {

    Button Connect;
    Button Disconnect;
    Button Action1;
    Button Action2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // auto start connection with launching app
        // example if needed
        // ConnectionHelper.openConnection(MainActivity.this);

        Connect = (Button) findViewById(R.id.btnConnect);
        Disconnect = (Button) findViewById(R.id.btnDisconnect);

        Action1 = (Button) findViewById(R.id.btnAction1);
        Action2 = (Button) findViewById(R.id.btnAction2);

        // logic for opening and closing db connections
        Connect.setOnClickListener(v -> ConnectionHelper.openConnection(MainActivity.this));
        Disconnect.setOnClickListener(v -> ConnectionHelper.closeConnection(MainActivity.this));

        // navigate to actions
        Action1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Action1Activity.class);
            startActivity(intent);
        });

        Action2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Action2Activity.class);
            startActivity(intent);
        });
    }

}
