package com.example.droidcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    
    private ImageView imgDounts, imgIceCream, imgFroyo;
    private FloatingActionButton floatBtnCart;
    public static final String EXTRA_MESSAGE = "com.example.android.droidcafe.extra.MESSAGE";
    private String orderMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgDounts = findViewById(R.id.donut);
        imgIceCream = findViewById(R.id.ice_cream);
        imgFroyo = findViewById(R.id.froyo);
        floatBtnCart = findViewById(R.id.float_button_cart);

        //Click image donuts
        imgDounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderMessage = getString(R.string.donut_order_message);
                Toast.makeText(MainActivity.this, getString(R.string.donut_order_message), Toast.LENGTH_SHORT).show();
            }
        });

        //Click image ice cream
        imgIceCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderMessage = getString(R.string.ice_cream_order_message);
                Toast.makeText(MainActivity.this, getString(R.string.ice_cream_order_message), Toast.LENGTH_SHORT).show();
            }
        });

        //Click image froyo
        imgFroyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderMessage = getString(R.string.froyo_order_message);
                Toast.makeText(MainActivity.this, getString(R.string.froyo_order_message), Toast.LENGTH_SHORT).show();
            }
        });

        //Click button cart
        floatBtnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, orderMessage);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order:
                Toast.makeText(this, getString(R.string.action_order_message), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_status:
                Toast.makeText(this, getString(R.string.action_status_message), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_favorites:
                Toast.makeText(this,getString(R.string.action_favorites_message), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_contact:
                Toast.makeText(this,getString(R.string.action_contact_message), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}