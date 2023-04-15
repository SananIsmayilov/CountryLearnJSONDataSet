package com.example.countrylearn;

import java.util.List;

import io.reactivex.Observable;

import retrofit2.http.GET;

public interface CountryAdd {
    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    Observable <List<CountryConteyner>>getData();
}
