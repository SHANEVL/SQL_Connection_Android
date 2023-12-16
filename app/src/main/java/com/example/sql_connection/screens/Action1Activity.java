package com.example.sql_connection.screens;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sql_connection.R;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.ConnectionHelper;

public class Action1Activity extends AppCompatActivity {
    Button SeeRecords;
    TextView ShowRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_1);

        SeeRecords = (Button) findViewById(R.id.btnAction1_GetRecords);
        ShowRecords = (TextView) findViewById(R.id.Action1_txtRecordResults);

        SeeRecords.setOnClickListener(v -> {
            try {
                Connection connection = ConnectionHelper.openConnection(this);
                if (connection != null) {
                    String query = "SELECT * FROM TableName";
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    StringBuilder records = new StringBuilder();
                    while (rs.next()) {
                        records.append(rs.getString("ColumnName")).append("\n");
                    }
                    ShowRecords.setText(records.toString());
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
