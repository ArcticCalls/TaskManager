package sg.edu.rp.webservices.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ListView lvTask;
    Button btnAddTask;
    ArrayAdapter aa;
    ArrayList<Tasks> tasksList;

    Button btnAddTask;
    int reqCode = 12345;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTask = findViewById(R.id.lvTask);
        btnAddTask = findViewById(R.id.btnAddTask);

        tasksList = new ArrayList<Tasks>();
        DBHelper dbh = new DBHelper(MainActivity.this);
        tasksList.addAll(dbh.getAllNotes());
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


        btnAddTask = findViewById(R.id.btnAddTask);
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = null;
                i = new Intent(MainActivity.this, AddActivity.class);
                startActivity(i);

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, 5);

                Intent intent = new Intent(MainActivity.this, fivesecondlater.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, reqCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager am = (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);

            }
        });
    }
}