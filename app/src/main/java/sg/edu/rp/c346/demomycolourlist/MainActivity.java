package sg.edu.rp.c346.demomycolourlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText etColour,editTextIndex;
    Button btnAdd,buttonRemoveItem,buttonUpdateItem;
    ListView lvColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etColour = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        editTextIndex = findViewById(R.id.editTextIndex);
        buttonRemoveItem = findViewById(R.id.buttonRemoveItem);
        buttonUpdateItem = findViewById(R.id.buttonUpdateItem);

        //Create ArrayList String
        final ArrayList alColours;
        final ArrayAdapter<String> aaColour;
        alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");


        aaColour = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String color = etColour.getText().toString();

                int index = Integer.parseInt(editTextIndex.getText().toString());

                alColours.add(index,color);
                aaColour.notifyDataSetChanged();
            }
        });

        buttonRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = Integer.parseInt(editTextIndex.getText().toString());
                alColours.remove(index);
                aaColour.notifyDataSetChanged();
            }
        });

        buttonUpdateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String color = etColour.getText().toString();

                int index = Integer.parseInt(editTextIndex.getText().toString());

                alColours.set(index,color);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position).toString();
                Toast.makeText(MainActivity.this,colour, Toast.LENGTH_LONG).show();


            }
        });


    }




}
