package com.example.jakevitale.amherstdo;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<String> descrips = new ArrayList<String>();
    boolean[] urgencies = {true, false, false, true, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.textarea);
        final LinearLayout searchLayout = (LinearLayout) findViewById(R.id.searcharea);

        titles.add("Finish Mobile Midterm");
        titles.add("Go for run");
        titles.add("Eat dinner");
        titles.add("Paper for Art History");
        titles.add("Call Danny back");
        titles.add("Clean Room");
        titles.add("Pick up package");

        descrips.add("Finish building app");
        descrips.add("6 miles minimum");
        descrips.add("Make sure it's a salad");
        descrips.add("4 page minimum");
        descrips.add("After 3 pm");
        descrips.add("And do laundry");
        descrips.add("Window closes at 3:45");

        for (int i = 0; i < titles.size(); i++) {
            String title = titles.get(i);
            String desc = descrips.get(i);
            boolean urgency = urgencies[i];

            final CheckBox check = new CheckBox(this);
            check.setText(title);
            if (urgency)
                check.setTextColor(Color.RED);
            check.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (check.getPaintFlags() == 1281)
                        check.setPaintFlags(check.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    else
                        check.setPaintFlags(check.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            });

            linearLayout.addView(check);

            TextView valueTV = new TextView(this);
            valueTV.setText(desc);
            valueTV.setPadding(30, 0, 10, 0);
            valueTV.setId(Integer.parseInt(String.valueOf(1)));
            valueTV.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            linearLayout.addView(valueTV);
        }
    }

    protected void search(View view)
    {
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.textarea);
        final LinearLayout searchLayout = (LinearLayout) findViewById(R.id.searcharea);

        searchLayout.removeAllViews();
        linearLayout.setVisibility(View.GONE);

        EditText search_edit = (EditText) findViewById(R.id.searchtxt);
        String search_text = search_edit.getText().toString();

        ArrayList<String> subsettitles = new ArrayList<String>();
        ArrayList<String> subsetdescrips = new ArrayList<String>();
        boolean [] subseturgencies = new boolean [titles.size()];
        int b = 0;

        for (int i = 0; i<titles.size(); i++)
        {
            if (titles.get(i).contains(search_text) || descrips.get(i).contains(search_text))
            {
                subsettitles.add(titles.get(i));
                subsetdescrips.add(descrips.get(i));
                subseturgencies[b++] = urgencies[i];
            }
        }

        for (int i = 0; i < subsettitles.size(); i++) {
            String title = subsettitles.get(i);
            String desc = subsetdescrips.get(i);
            boolean urgency = subseturgencies[i];

            final CheckBox check = new CheckBox(this);
            check.setText(title);
            if (urgency)
                check.setTextColor(Color.RED);
            check.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (check.getPaintFlags() == 1281)
                        check.setPaintFlags(check.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    else
                        check.setPaintFlags(check.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            });

            searchLayout.addView(check);

            TextView valueTV = new TextView(this);
            valueTV.setText(desc);
            valueTV.setPadding(30, 0, 10, 0);
            valueTV.setId(Integer.parseInt(String.valueOf(1)));
            valueTV.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            searchLayout.addView(valueTV);
        }

    }

    protected void clear(View view)
    {
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.textarea);
        final LinearLayout searchLayout = (LinearLayout) findViewById(R.id.searcharea);

        EditText search_edit = (EditText) findViewById(R.id.searchtxt);

        searchLayout.removeAllViews();
        linearLayout.setVisibility(View.VISIBLE);
        search_edit.setText("");
    }

//    protected void addtext(View view) {
//
//        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.textarea);
//
//        EditText title_edit = (EditText) findViewById(R.id.tasktitle);
//        EditText title_desc = (EditText) findViewById(R.id.taskdescription);
//        CheckBox urgent_edit = (CheckBox) findViewById(R.id.taskurgent);
//
//        String title = title_edit.getText().toString();
//        String desc = title_desc.getText().toString();
//        boolean urgency = urgent_edit.isChecked();
//
//        if (title.equals("") || desc.equals("")) {
//            Toast.makeText(MainActivity.this, "Enter both a title and description",
//                    Toast.LENGTH_LONG).show();
//        } else {
//
//            final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.textarea);
//            final CheckBox check = new CheckBox(this);
//            check.setText(title);
//            if (urgency)
//                check.setTextColor(Color.RED);
//            check.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    if (check.getPaintFlags() == 1281)
//                        check.setPaintFlags(check.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
//                    else
//                        check.setPaintFlags(check.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
//                }
//            });
//
//
//            linearLayout.addView(check);
//
//            TextView valueTV = new TextView(this);
//            valueTV.setText(desc);
//            valueTV.setPadding(30, 0, 10, 0);
//            valueTV.setId(Integer.parseInt(String.valueOf(1)));
//            valueTV.setLayoutParams(new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.FILL_PARENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT));
//            linearLayout.addView(valueTV);
//        }
//    }
}
