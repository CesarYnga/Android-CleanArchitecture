package com.cesarynga.cleanarchitecture.data.repository.datasource;

import com.cesarynga.cleanarchitecture.data.entity.UserEntity;
import com.cesarynga.cleanarchitecture.data.net.RestApi;

import java.util.List;

public class NetworkUserDataSource implements UserDataSource {

    private final RestApi restApi;

    public NetworkUserDataSource(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public void userEntityList(final DataSourceCallback<List<UserEntity>> callback) {
        try {
            callback.onSuccess(restApi.getUserList());
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
