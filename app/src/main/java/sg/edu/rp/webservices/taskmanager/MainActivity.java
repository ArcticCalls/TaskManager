package sg.edu.rp.webservices.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvTask;
    Button btnAddTask;
    ArrayAdapter aa;
    ArrayList<Tasks> tasksList;
    int reqCode = 12345;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTask = findViewById(R.id.lvTask);
        btnAddTask = findViewById(R.id.btnAddTask);

        tasksList = new ArrayList<Tasks>();
        DBHelper dbh = new DBHelper(MainActivity.this);
        tasksList.addAll(dbh.getAllTasks());
        dbh.close();
        aa = new TaskAdapter(MainActivity.this, R.layout.row, tasksList);
        lvTask.setAdapter(aa);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivity(i);
            }
        });

    }
}