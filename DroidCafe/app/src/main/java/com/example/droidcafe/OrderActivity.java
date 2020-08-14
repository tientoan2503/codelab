package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView tvOrderMessage;
    RadioGroup radioGroupDelivery;
    private Button btnDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tvOrderMessage = findViewById(R.id.order_textview);
        Intent intent = getIntent();
        tvOrderMessage.setText(intent.getStringExtra(MainActivity.EXTRA_MESSAGE));

        radioGroupDelivery = findViewById(R.id.radio_group_delivery);

        radioGroupDelivery.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.sameday:
                        Toast.makeText(OrderActivity.this, getString(R.string.same_day_delivery), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nextday:
                        Toast.makeText(OrderActivity.this, getString(R.string.next_day_delivery), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.pickup:
                        Toast.makeText(OrderActivity.this, getString(R.string.pick_up), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
//        Create the spinner
        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
//        Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
//        Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Apply the adapter to the spinner
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        //Click button Date
        btnDate = findViewById(R.id.buttonDate);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, spinnerLabel, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //Show Date Picker Dialog
    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                 calendar.set(i, i1, i2);
                 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd//MM/yyyy");
                 String date = simpleDateFormat.format(calendar.getTime());
                 Toast.makeText(OrderActivity.this, getString(R.string.date_message ) + date, Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);
        datePickerDialog.show();
    }
}