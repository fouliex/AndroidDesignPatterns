package com.test.xyz.daggersample.presenter.details;

import com.test.xyz.daggersample.interactor.MainInteractor;
import com.test.xyz.daggersample.presenter.BasePresenterTest;
import com.test.xyz.daggersample.presenter.repodetails.RepoDetailsPresenter;
import com.test.xyz.daggersample.presenter.repodetails.RepoDetailsPresenterImpl;
import com.test.xyz.daggersample.service.api.model.Repo;
import com.test.xyz.daggersample.view.activity.repodetails.RepoDetailsView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RepoDetailsPresenterTest  extends BasePresenterTest {
    private static final String USER_NAME = "google";
    private static final String PROJECT_ID = "test";

    private RepoDetailsPresenter repoDetailsPresenter;

    @Mock
    MainInteractor mainInteractor;

    @Mock
    RepoDetailsView repoDetailsView;

    @Before
    public void setup() {
        mockInteractor(mainInteractor);
        repoDetailsPresenter = new RepoDetailsPresenterImpl(repoDetailsView, mainInteractor);
    }

    @Test
    public void requestRepoDetails_whenUserNameAndProjectIDAreValid_shouldReturnRepoDetails() {
        //GIVEN
        //NOTHING

        //WHEN
        repoDetailsPresenter.requestRepoDetails(USER_NAME, PROJECT_ID);

        //THEN
        verify(repoDetailsView).showRepoDetails(Matchers.any(Repo.class));
        verify(repoDetailsView, never()).showError(Matchers.any(String.class));
    }

    @Test
    public void requestRepoDetails_whenUserNameIsEmpty_shouldReturnError() {
        //GIVEN
        //NOTHING

        //WHEN
        repoDetailsPresenter.requestRepoDetails("", PROJECT_ID);

        //THEN
        verify(repoDetailsView, never()).showRepoDetails(Matchers.any(Repo.class));
        verify(repoDetailsView).showError(Matchers.any(String.class));
    }
}
