package com.test.xyz.daggersample.presenter.main;

import com.test.xyz.daggersample.interactor.MainInteractor;
import com.test.xyz.daggersample.presenter.BasePresenterTest;
import com.test.xyz.daggersample.presenter.weather.WeatherPresenter;
import com.test.xyz.daggersample.presenter.weather.WeatherPresenterImpl;
import com.test.xyz.daggersample.view.fragment.weather.WeatherView;
import com.test.xyz.daggersample.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherPresenterTest extends BasePresenterTest {
    private static final String USER_NAME = "hazems";

    private WeatherPresenter weatherPresenter;

    @Mock
    MainInteractor mainInteractor;

    @Mock
    WeatherView mainView;

    @Before
    public void setup() {
        mockInteractor(mainInteractor);

        // Instantiate main object
        weatherPresenter = new WeatherPresenterImpl(mainView, mainInteractor);
    }

    @Test
    public void requestInformation_whenUserNameAndCityAreValid_shouldReturnInfo() throws Exception {
        //GIVEN
        when(mainView.getUserNameText()).thenReturn(USER_NAME);
        when(mainView.getCityText()).thenReturn(VALID_CITY);

        //WHEN
        weatherPresenter.requestWeatherInformation();

        //THEN
        //TODO comment the next line to show how it work.
        //verify(mainView).showBusyIndicator();
        //verify(mainView).hideBusyIndicator();
        verify(mainView).showResult(MOCK_INFO_SUCCESS_MSG);
    }

    @Test
    public void requestInformation_whenUserNameIsEmpty_shouldReturnError() throws Exception {
        //GIVEN
        when(mainView.getUserNameText()).thenReturn("");
        when(mainView.getCityText()).thenReturn(VALID_CITY);

        //WHEN
        weatherPresenter.requestWeatherInformation();

        //THEN
        //TODO comment the next method to show how it work.
        //verify(mainView).showBusyIndicator();
        //verify(mainView).hideBusyIndicator();
        //verify(mainView, never()).showResult(any(String.class));
        verify(mainView).showUserNameError(R.string.username_empty_message);
    }

    @Test
    public void requestInformation_whenCityIsEmpty_shouldReturnError() throws Exception {
        //GIVEN
        when(mainView.getUserNameText()).thenReturn(USER_NAME);
        when(mainView.getCityText()).thenReturn("");

        //WHEN
        weatherPresenter.requestWeatherInformation();

        //THEN
        //TODO comment the next method to show how it work.
        //verify(mainView).showBusyIndicator();
        //verify(mainView).hideBusyIndicator();
        //verify(mainView, never()).showResult(any(String.class));
        verify(mainView).showCityNameError(R.string.city_empty_message);
    }

    @Test
    public void requestInformation_whenCityIsInvalid_shouldReturnError() throws Exception {
        //GIVEN
        when(mainView.getUserNameText()).thenReturn(USER_NAME);
        when(mainView.getCityText()).thenReturn(INVALID_CITY);

        //WHEN
        weatherPresenter.requestWeatherInformation();

        //THEN
        //TODO comment the next method to show how it work.
        //verify(mainView).showBusyIndicator();
        //verify(mainView).hideBusyIndicator();
        verify(mainView).showError(anyString());
    }
}
