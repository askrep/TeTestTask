package com.example.tetesttask;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tetesttask.fragments.ItemListFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "#_Main_Activity";
    private boolean isChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ItemListFragment.newInstance())
                    .commitNow();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.list_menu, menu);
        return true;
    }

    //todo add mode switcher and call add_item_fragment
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_add_item:
                Log.d(TAG, "onOptionsItemSelected: onAddItemPressed");

                return true;

            case R.id.menu_switch:
                Log.d(TAG, "onOptionsItemSelected: onSwitchPressed");
                isChecked = !item.isChecked();
                item.setChecked(isChecked);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}