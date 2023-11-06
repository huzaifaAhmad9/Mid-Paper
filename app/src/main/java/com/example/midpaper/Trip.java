package com.example.midpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Trip extends AppCompatActivity implements SelectedListener{
    RecyclerView rec;
    ArrayList<Modal> arr1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);
        rec = findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(this));
//        arr1.add(new Modal(R.drawable.cont, "Tokyo" , "Tokyo, the capital of Japan"));
        arr1.add(new Modal(R.drawable.bhwl, "Bhawalpur" , "Bhawalpur, the city of Pakistan"));
        arr1.add(new Modal(R.drawable.mul, "Multan" , "Multan, the city of Pakistan"));
        arr1.add(new Modal(R.drawable.isl, "Islamabad" , "Islamabad, the city of Pakistan"));
        arr1.add(new Modal(R.drawable.naro, "Narowal" , "Narowal, the city of Pakistan"));
        arr1.add(new Modal(R.drawable.lhr, "Lahore" , "LHR, the city of Pakistan"));
        arr1.add(new Modal(R.drawable.swat, "Swat" , "Swat, the city of Pakistan"));
        arr1.add(new Modal(R.drawable.mur, "Murree" , "Murree, the city of Pakistan"));
        arr1.add(new Modal(R.drawable.kar, "Karachi" , "Karachi, the city of Pakistan"));
        arr1.add(new Modal(R.drawable.kpk, "KPK" , "KPK, the city of Pakistan"));
        arr1.add(new Modal(R.drawable.sial, "Sialkot" , "Sialkot, the city of Pakistan"));
        arr1.add(new Modal(R.drawable.fas, "Faislabad" , "Faislabad, the city of Pakistan"));
        CustomAdapterInspired adpi = new CustomAdapterInspired(this,arr1,this);
        rec.setAdapter(adpi);

    }

    @Override
    public void onItemClicked(Modal modal) {
        Intent intent;
        String itemName = modal.getName();
        switch(itemName){
            case "Bhawalpur":
                intent = new Intent(this,Damam.class);
                startActivity(intent);
                break;

            case "Multan":
                intent = new Intent(this,Damam.class);
                startActivity(intent);
                break;

            case "Islamabad":
                intent = new Intent(this,Damam.class);
                startActivity(intent);
                break;

            case "Narowal":
                intent = new Intent(this,Damam.class);
                startActivity(intent);
                break;

            case "Lahore":
                intent = new Intent(this,Damam.class);
                startActivity(intent);
                break;

            case "Swat":
                intent = new Intent(this,Damam.class);
                startActivity(intent);
                break;

            case "Murree":
                intent = new Intent(this,Damam.class);
                startActivity(intent);
                break;

            case "Karachi":
                intent = new Intent(this,Damam.class);
                startActivity(intent);
                break;

            case "KPK":
                intent = new Intent(this,Damam.class);
                startActivity(intent);
                break;

            case "Sialkot":
                intent = new Intent(this,Damam.class);
                startActivity(intent);
                break;

            case "Faislabad":
                intent = new Intent(this,Damam.class);
                startActivity(intent);
                break;

        }
    }
}