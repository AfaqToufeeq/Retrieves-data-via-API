package com.app.a3_gamingapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import com.app.a3_gamingapi.RecyclerAdapter.dataClass;
import com.app.a3_gamingapi.RecyclerAdapter.recyclerAdapterClass;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    recyclerAdapterClass adapter;
    public static List<dataClass> dataList;
    public static dataClass dataClass1;

    static ArrayList<String> imgList;
    static ArrayList<String> nameList;
    static ArrayList<String> desList;
    static ArrayList<String> attackList;
    static ArrayList<String> defenseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recyclerView);
        dataList = new ArrayList<>();

        imgList = new ArrayList<>();
        nameList = new ArrayList<>();
        desList = new ArrayList<>();
        attackList = new ArrayList<>();
        defenseList = new ArrayList<>();

        //Trail Arrays
        int pid[] = {21823, 89774, 34007, 12098, 45098, 10067};
        String pname[] = {"HP Laptop", "Inverters", "Volats AC", "iPhone 11", "CanonDSLR", "SonyLEDTV"};
        char pavailability[] = {'Y', 'Y', 'N', 'Y', 'Y', 'N'};
        double pprice[] = {31987, 16900, 28000, 99000, 67570, 60500};
        float prating[] = {4.5f, 4.0f, 4.7f, 4.5f, 3.9f, 4.0f};

        //Main Work Start

        //Adding Data to ArrayLists;
        for(int i=0;i<4;i++)
        {
            imgList.add(String.valueOf(pid[i]));
            nameList.add(String.valueOf(pname[i]));
            desList.add(String.valueOf(pavailability[i]));
            attackList.add(String.valueOf(pprice[i]));
            defenseList.add(String.valueOf(prating[i]));
        }

        //invoking the addElements() method that adds the elements in the ArrayList
        addElements(imgList,nameList,desList,attackList,defenseList);
//        RecyclerViewImp();

    }
    //AddElements Methods
    private void addElements(ArrayList<String> imgList, ArrayList<String> nameList, ArrayList<String> desList, ArrayList<String> attackList, ArrayList<String> defenseList) {

        //send values to the constructor to be saved in the dataClass
        for(int i=0;i<imgList.size();i++)
        {
            dataClass1 = new dataClass(imgList.get(i),nameList.get(i),desList.get(i),attackList.get(i),defenseList.get(i));
            dataList.add(dataClass1);
        }
        RecyclerViewImp();
    }

    private void RecyclerViewImp() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new recyclerAdapterClass(dataList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    
    //Option Menu for Filteration the Data

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);

        MenuItem menuItem = menu.findItem(R.id.search_Action);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s.toString());
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}