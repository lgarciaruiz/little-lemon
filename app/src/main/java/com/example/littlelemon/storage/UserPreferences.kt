package com.example.littlelemon.storage

import android.content.Context
import android.content.SharedPreferences
import com.example.littlelemon.model.User
import com.google.gson.Gson

object UserPreferences {
    private const val PREFS_NAME = "ll_user_prefs";
    private const val USER_KEY = "user"

    private fun getPrefs(context: Context): SharedPreferences{
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveUser(context: Context, user: User) {
        val userJson = Gson().toJson(user)
        getPrefs(context).edit().putString(USER_KEY, userJson).apply()
    }

    fun getUser(context: Context): User? {
        val userJson = getPrefs(context).getString(USER_KEY, null)
        return if (userJson != null) Gson().fromJson(userJson, User::class.java) else null
    }

    fun clearUser(context: Context) {
        getPrefs(context).edit().remove(USER_KEY).apply()
    }
}