package sg.edu.rp.webservices.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    Button btnAddTask, btnCancel;
    EditText etName, etDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnCancel = findViewById(R.id.btnCancel);
        btnAddTask = findViewById(R.id.btnAddTask);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    String dataName = etName.getText().toString();
                    String dataDescription = etDescription.getText().toString();
                    DBHelper dbh = new DBHelper(AddActivity.this);
                    long inserted_id = dbh.addTask(dataName);
                    dbh.close();

                    if (inserted_id != -1) {
                        Toast.makeText(AddActivity.this, "Note added!",
                                Toast.LENGTH_SHORT).show();
                    }



            }
        });
    }
}