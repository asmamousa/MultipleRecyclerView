package examples.android.example.com.multiplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<My_items> items_list = new ArrayList<My_items>();

    My_items i = new My_items();
    My_items i2 = new My_items();

 RecyclerView recyclerView;

 //Adapter adapter;

    OldAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        i.setName("Chocolate Cake");
//        i.setDescription(" super moist chocolate cake with a rich, melt-in-your-mouth chocolate buttercream frosting. It's covered with a chocolate ganache drip");
//        items_list.add(i);

        i.setPicURL(R.drawable.img);
        i.setPicName("Cake");
        items_list.add(i);

        i2.setName("Red Velvet");
        i2.setDescription("Red CAKE");
        items_list.add(i2);
//
//        i.setName("second");
//        i.setDescription(" CAKE");
//        items_list.add(i);


      //  System.out.println("%"+items_list.get(1).getName());


//        i.setBtn();
//        i.setText();
//        items_list.add(i);

        // adapter= new Adapter(items_list);

        adapter= new OldAdapter(items_list);


        recyclerView=(RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);



    }



}

