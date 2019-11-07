package com.example.contextmenuprac;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edittext;
    Button btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        edittext = (EditText) findViewById(R.id.edittext);
        registerForContextMenu(btn);
        registerForContextMenu(edittext);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        switch(v.getId()) {
            case R.id.btn:
                menu.setHeaderTitle("Font Color");
                menu.add(0, 1, 0, "Black");
                        menu.add(0, 2, 0, "Red");
                menu.add(0, 3, 0, "Blue");
                break;
            case R.id.edittext:
                menu.setHeaderTitle("Font Size");
                menu.add(0, 4, 0, "12");
                menu.add(0, 5, 0, "24");
                menu.add(0, 6, 0, "36");
                break;
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
            edittext.setTextColor(Color.RED);
        } else if (item.getItemId() == 2) {
            edittext.setTextColor(Color.BLUE);
        } else if (item.getItemId() == 3) {
            edittext.setTextSize(12);
        } else if (item.getItemId() == 4) {
            edittext.setTextSize(24);
        } else if (item.getItemId() == 5) {
            edittext.setTextSize(36);
        } else  return false;
        return true;
    }
    public void clearText(View v) {
        edittext.setText("");
    }
}
