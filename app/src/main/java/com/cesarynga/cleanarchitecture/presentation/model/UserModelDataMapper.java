package com.cesarynga.cleanarchitecture.presentation.model;

import com.cesarynga.cleanarchitecture.domain.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserModelDataMapper {

    public UserModelDataMapper() {
    }

    public UserModel transform(User user) {
        UserModel userModel = new UserModel(user.getId());
        userModel.setUsername(user.getUsername());
        return userModel;
    }

    public List<UserModel> transform(List<User> userList) {
        List<UserModel> userModelList = new ArrayList<>();
        for(User user : userList) {
            userModelList.add(transform(user));
        }
        return userModelList;
    }
}
