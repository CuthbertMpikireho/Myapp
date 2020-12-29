package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class My_lists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lists);  this.arrayAdapterListView();
    }


    private void arrayAdapterListView()
    {
        setTitle("Uganda Premier League");

        List<String> dataList = new ArrayList<String>();
        dataList.add("KCCA");
        dataList.add("Vipers");
        dataList.add("Express");
        dataList.add("Wakiso Giants");
        dataList.add("Mbarara City");
        dataList.add("Tooro United");

        ListView listView = (ListView)findViewById(R.id.read);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, dataList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Object clickItemObj = adapterView.getAdapter().getItem(index);
                Toast.makeText(My_lists.this, "You Selected " + clickItemObj.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

