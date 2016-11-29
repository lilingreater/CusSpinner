package com.lilin.cusspinner.customerspinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private CusSpinnerView spinner_name;
    private Button btn_commit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner_name = (CusSpinnerView) findViewById(R.id.spinner_name);
        btn_commit = (Button) findViewById(R.id.btn_commit);
        spinner_name.setList(Arrays.asList(getResources().getStringArray(R.array.name)));
        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "spinnerselect==" + spinner_name.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
