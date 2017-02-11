package com.example.di.fouliex.diwithdaggertwo.service.api;

import java.util.Observable;

/**
 * Created by 212361198 on 2/10/17.
 */

public interface WeatherService {
   rx.Observable<Integer> getWeatherInfo(String city);
}
