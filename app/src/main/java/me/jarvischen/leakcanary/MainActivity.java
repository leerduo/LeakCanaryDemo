package me.jarvischen.leakcanary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;

    private String[] activities = new String[]{"FirstLeakActivity","SecondLeakActivity","ThirdLeakActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,activities);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        switch (position){
            case 0:
                intent = new Intent(MainActivity.this,FirstLeakActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(MainActivity.this,SecondLeakActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(MainActivity.this,ThirdLeakActivity.class);
                startActivity(intent);
                break;
        }
    }
}