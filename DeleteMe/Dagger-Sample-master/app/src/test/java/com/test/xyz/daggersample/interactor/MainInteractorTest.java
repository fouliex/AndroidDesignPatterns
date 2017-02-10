package com.test.xyz.daggersample.interactor;

import com.test.xyz.daggersample.R;
import com.test.xyz.daggersample.presenter.repodetails.OnRepoDetailsCompletedListener;
import com.test.xyz.daggersample.presenter.repolist.OnRepoListCompletedListener;
import com.test.xyz.daggersample.presenter.weather.OnWeatherInfoCompletedListener;
import com.test.xyz.daggersample.service.api.ErrorMessages;
import com.test.xyz.daggersample.service.api.HelloService;
import com.test.xyz.daggersample.service.api.RepoListService;
import com.test.xyz.daggersample.service.api.WeatherService;
import com.test.xyz.daggersample.service.api.model.Repo;
import com.test.xyz.daggersample.service.exception.InvalidCityException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

import static junit.framework.Assert.fail;
import static org.mockito.AdditionalMatchers.and;
import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainInteractorTest {
    private static final String USER_NAME = "hazems";
    private static final String CITY = "New York, USA";
    private static final String PROJECT_ID = "Test";
    private static final String INVALID_CITY = "INVALID_CITY";
    private static final String UNLUCKY_ACCOUNT = "UNLUCKY_ACCOUNT";
    private static final String EMPTY_VALUE = "";

    private MainInteractorImpl testSubject;

    @Mock
    private OnWeatherInfoCompletedListener onInfoCompletedListener;

    @Mock
    private OnRepoListCompletedListener onRepoListCompletedListener;

    @Mock
    private OnRepoDetailsCompletedListener onRepoDetailsCompletedListener;

    @Mock
    private HelloService helloService;

    @Mock
    private WeatherService weatherService;

    @Mock
    private RepoListService repoListService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        setupRxSchedulers();

        testSubject = new MainInteractorImpl(helloService, weatherService, repoListService);
    }

    private void setupRxSchedulers() {
        RxJavaPlugins.getInstance().reset();
        RxJavaPlugins.getInstance().registerSchedulersHook(new RxJavaSchedulersHook() {
            @Override
            public Scheduler getIOScheduler() {
                return Schedulers.immediate();
            }
        });
        RxAndroidPlugins.getInstance().reset();
        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });
    }

    @After
    public void tearDown() {
        RxAndroidPlugins.getInstance().reset();
        RxJavaPlugins.getInstance().reset();
    }

    @Test
    public void getInformation_whenUserNameAndCityAreCorrect_shouldReturnWeatherInfo() {
        try {
            //GIVEN
            mockWeatherServiceAPIs();

            //WHEN
            testSubject.getWeatherInformation(USER_NAME, CITY, onInfoCompletedListener);

            //THEN
            verify(onInfoCompletedListener).onSuccess(any(String.class));
        } catch (Exception exception) {
            exception.printStackTrace();
            fail("Unable to getWeatherInfo !!!");
        }
    }

    @Test
    public void getInformation_whenCityIsInvalid_shouldReturnFailure() {
        try {
            //GIVEN
            mockWeatherServiceAPIs();

            //WHEN
            testSubject.getWeatherInformation(USER_NAME, INVALID_CITY, onInfoCompletedListener);

            //THEN
            verify(onInfoCompletedListener).onFailure(any(String.class));
        } catch (Exception exception) {
            fail("Unable to getWeatherInfo !!!");
        }
    }

    @Test
    public void getInformation_whenUserNameIsEmpty_shouldReturnValidationError() {
        try {
            //GIVEN
            mockWeatherServiceAPIs();

            //WHEN
            testSubject.getWeatherInformation("", CITY, onInfoCompletedListener);

            //THEN
            verify(onInfoCompletedListener).onUserNameValidationError(R.string.username_empty_message);
        } catch (Exception exception) {
            fail("Unable to getWeatherInfo !!!");
        }
    }

    @Test
    public void getInformation_whenCityIsEmpty_shouldReturnValidationError() {
        try {
            //GIVEN
            mockWeatherServiceAPIs();

            //WHEN
            testSubject.getWeatherInformation(USER_NAME, "", onInfoCompletedListener);

            //THEN
            verify(onInfoCompletedListener).onCityValidationError(R.string.city_empty_message);
        } catch (Exception exception) {
            fail("Unable to getWeatherInfo !!!");
        }
    }

    @Test
    public void getRepoList_whenUserNameIsCorrect_shouldReturnRepoListInfo() throws Exception {
        //GIVEN
        mockGetRepoListAPI();

        //WHEN
        testSubject.getRepoList(USER_NAME, onRepoListCompletedListener);

        //THEN
        verify(onRepoListCompletedListener).onRepoListRetrievalSuccess(anyList());
    }

    @Test
    public void getRepoList_whenUserNameIsEmpty_shouldReturnValidationError() throws Exception {
        //GIVEN
        mockGetRepoListAPI();

        //WHEN
        testSubject.getRepoList("", onRepoListCompletedListener);

        //THEN
        verify(onRepoListCompletedListener).onRepoListRetrievalFailure(anyString());
    }

    @Test
    public void getRepoList_whenNetworkErrorHappen_shouldReturnFailureError() throws Exception {
        //GIVEN
        mockGetRepoListAPI();

        //WHEN
        testSubject.getRepoList(UNLUCKY_ACCOUNT, onRepoListCompletedListener);

        //THEN
        verify(onRepoListCompletedListener).onRepoListRetrievalFailure(anyString());
    }

    @Test
    public void getRepoItemDetails_whenUserNameAndProjectIDAreCorrect_shouldReturnRepoItemInfo() throws Exception {
        //GIVEN
        mockGetRepoItemDetailsAPI();

        //WHEN
        testSubject.getRepoItemDetails(USER_NAME, PROJECT_ID, onRepoDetailsCompletedListener);

        //THEN
        verify(onRepoDetailsCompletedListener).onRepoDetailsRetrievalSuccess(any(Repo.class));
    }

    @Test
    public void getRepoItemDetails_whenUserNameIsEmpty_shouldReturnValidationError() throws Exception {
        //GIVEN
        mockGetRepoItemDetailsAPI();

        // WHEN
        testSubject.getRepoItemDetails("", PROJECT_ID, onRepoDetailsCompletedListener);

        //THEN
        verify(onRepoDetailsCompletedListener).onRepoDetailsRetrievalFailure(anyString());
    }

    @Test
    public void getRepoItemDetails_whenProjectIDIsEmpty_shouldReturnValidationError() throws Exception {
        //GIVEN
        mockGetRepoItemDetailsAPI();

        // WHEN
        testSubject.getRepoItemDetails("", PROJECT_ID, onRepoDetailsCompletedListener);

        //THEN
        verify(onRepoDetailsCompletedListener).onRepoDetailsRetrievalFailure(anyString());
    }

    @Test
    public void getRepoItemDetails_whenNetworkErrorHappen_shouldReturnFailureError() throws Exception {
        //GIVEN
        mockGetRepoItemDetailsAPI();

        // WHEN
        testSubject.getRepoItemDetails(UNLUCKY_ACCOUNT, PROJECT_ID, onRepoDetailsCompletedListener);

        //THEN
        verify(onRepoDetailsCompletedListener).onRepoDetailsRetrievalFailure(anyString());
    }

    private void mockWeatherServiceAPIs() {
        // Happy Path Scenario ...
        Observable<Integer> observable = Observable.just(10);

        when(weatherService.getWeatherInfo(and(not(eq(EMPTY_VALUE)), not(eq(INVALID_CITY))))).thenReturn(observable);

        // Empty City ...
        when(weatherService.getWeatherInfo(eq(EMPTY_VALUE)))
                .thenReturn(Observable.error(
                        new RuntimeException(ErrorMessages.CITY_REQUIRED))
                        .cast(Integer.class));

        // Invalid City ...
        when(weatherService.getWeatherInfo(eq(INVALID_CITY)))
                .thenReturn(Observable.error(
                        new InvalidCityException(ErrorMessages.INVALID_CITY_PROVIDED))
                        .cast(Integer.class));
    }

    private void mockGetRepoListAPI() {
        // Happy Path Scenario ...
        List<Repo> repoList = new ArrayList<>();
        Observable<List<Repo>> observable = Observable.just(repoList);

        when(repoListService.getRepoList(not(eq(UNLUCKY_ACCOUNT)))).thenReturn(observable);

        // Error Scenario ...
        when(repoListService.getRepoList(eq(UNLUCKY_ACCOUNT)))
                .thenReturn(Observable.error(new IOException("Invalid account"))
                        .cast((Class) List.class));
    }

    private void mockGetRepoItemDetailsAPI() {
        // Happy Path Scenario ...
        Repo repo = new Repo("SampleRepoItem");
        Observable<Repo> observable = Observable.just(repo);

        when(repoListService.getRepoItemDetails(not(eq(UNLUCKY_ACCOUNT)), anyString())).thenReturn(observable);

        // Error Scenario ...
        when(repoListService.getRepoItemDetails(eq(UNLUCKY_ACCOUNT), anyString()))
                .thenReturn(Observable.error(
                        new IOException("Invalid account"))
                        .cast((Class) List.class));
    }

}
