package com.cesarynga.cleanarchitecture.presentation.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cesarynga.cleanarchitecture.R;
import com.cesarynga.cleanarchitecture.data.entity.mapper.UserEntityDataMapper;
import com.cesarynga.cleanarchitecture.data.repository.UserDataRepository;
import com.cesarynga.cleanarchitecture.data.repository.datasource.UserDataSourceFactory;
import com.cesarynga.cleanarchitecture.domain.executor.JobExecutor;
import com.cesarynga.cleanarchitecture.domain.executor.UIThread;
import com.cesarynga.cleanarchitecture.domain.repository.UserRepository;
import com.cesarynga.cleanarchitecture.domain.usecase.GetUserList;
import com.cesarynga.cleanarchitecture.presentation.model.UserModel;
import com.cesarynga.cleanarchitecture.presentation.model.UserModelDataMapper;
import com.cesarynga.cleanarchitecture.presentation.presenter.UserListPresenter;
import com.cesarynga.cleanarchitecture.presentation.view.UserListView;
import com.cesarynga.cleanarchitecture.presentation.view.adapter.UsersAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class UserListFragment extends Fragment implements UserListView {

    private static final String TAG = "UserListFragment";

    private UserListPresenter userListPresenter;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private UsersAdapter usersAdapter;

    private Unbinder unbinder;

    public UserListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        unbinder = ButterKnife.bind(this, view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        usersAdapter = new UsersAdapter();
        recyclerView.setAdapter(usersAdapter);

        userListPresenter = new UserListPresenter(this);

        if (savedInstanceState == null) {
            userListPresenter.getUserList();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getContext();
    }

    @Override
    public void renderUserList(List<UserModel> userModelList) {
        usersAdapter.setUserList(userModelList);
    }
}
