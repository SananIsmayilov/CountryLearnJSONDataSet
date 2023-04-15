package com.example.countrylearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String BASE_URL = "https://raw.githubusercontent.com/";
    Retrofit retrofit;
    ArrayList<CountryConteyner> conteynerArrayList;
    RecyclerView recyclerView;
    AdapterClass adapterClass;
    CompositeDisposable compositeDisposable;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gson gson = new GsonBuilder().create();
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        recyclerView = findViewById(R.id.rcyc);
        getData();
    }

    public void getData() {
        CountryAdd countryAdd = retrofit.create(CountryAdd.class);
        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(countryAdd.getData()
                .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::load)

                );
    }
    public  void load(List<CountryConteyner> conteynerList){
       conteynerArrayList = new ArrayList<>(conteynerList);

       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       adapterClass = new AdapterClass(conteynerArrayList);
       recyclerView.setAdapter(adapterClass);

    }


}