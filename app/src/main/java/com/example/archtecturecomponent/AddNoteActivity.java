package com.example.archtecturecomponent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    public static final String EXTRA_TITLE=
         "com.example.archtecturecomponent.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION=
            "com.example.archtecturecomponent.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY=
            "com.example.archtecturecomponent.EXTRA_PRIORITY";

    EditText editTextTitle;
    EditText editTextDescription;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        numberPicker = findViewById(R.id.number_picker_priority);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void saveNote() {
        String title=editTextTitle.getText().toString();
        String descraption=editTextDescription.getText().toString();
        int pirotity=numberPicker.getValue();
        if(title.trim().isEmpty()||descraption.trim().isEmpty()){
            Toast.makeText(this,"Please Insert A title and description",Toast.LENGTH_LONG).show();
            return;
        }
        Intent data=new Intent();
        data.putExtra(EXTRA_TITLE,title);
        data.putExtra(EXTRA_DESCRIPTION,descraption);
        data.putExtra(EXTRA_PRIORITY,pirotity);

        setResult(RESULT_OK,data);
        finish();


    }
}
