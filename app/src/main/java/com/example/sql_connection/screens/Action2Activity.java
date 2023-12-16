package com.example.sql_connection.screens;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sql_connection.R;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.ConnectionHelper;

public class Action2Activity extends AppCompatActivity {
    Button SeeRecords;
    TextView ShowRecords;
    TextView ShowTextAfterRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_2);

        SeeRecords = findViewById(R.id.btnAction2_btnSeeRecords);
        ShowRecords = findViewById(R.id.txtAction2_SeeResults);
        ShowTextAfterRecords = findViewById(R.id.txtAction2_ConditionalUIText);

        SeeRecords.setOnClickListener(v -> {
            try {
                Connection connection = ConnectionHelper.openConnection(this);
                if (connection != null) {
                    String query = "SELECT * FROM TableName";
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    StringBuilder records = new StringBuilder();
                    boolean hasData = false;
                    while (rs.next()) {
                        hasData = true;
                        records.append(rs.getString("ColumnName")).append("\n");
                    }
                    ShowRecords.setText(records.toString());
                    if (hasData) {
                        ShowTextAfterRecords.setVisibility(View.VISIBLE);
                        ShowTextAfterRecords.setText("We got the values!");
                    }
                    ConnectionHelper.closeConnection(this);
                } else {
                    ShowRecords.setText("Connection Error");
                }
            } catch (Exception e) {
                ShowRecords.setText("Error: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }
}

