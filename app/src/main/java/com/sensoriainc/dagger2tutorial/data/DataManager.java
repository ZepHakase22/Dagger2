package com.sensoriainc.dagger2tutorial.data;

import android.content.res.Resources;

import com.sensoriainc.dagger2tutorial.data.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by zep on 23/01/18.
 */

@Singleton
public class DataManager {
    private DBHelper mDbHelper;
    private SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(DBHelper dbHelper, SharedPrefsHelper sharedPrefsHelper ) {
        mDbHelper=dbHelper;
        mSharedPrefsHelper=sharedPrefsHelper;
    }
    public void saveAccessToken(String accessToken) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN,accessToken);
    }
    public String getAccessToken() {
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN,null);
    }
    public Long createUser(User user) throws Exception {
        return mDbHelper.insertUser(user);
    }
    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
        return mDbHelper.getUser(userId);
    }
}
