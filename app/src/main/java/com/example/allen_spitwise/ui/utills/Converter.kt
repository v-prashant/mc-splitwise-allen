package com.example.allen_spitwise.ui.utills

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromStringList(value: String?): ArrayList<String> {
        return Gson().fromJson(value, object : TypeToken<ArrayList<String>>() {}.type)
    }

    @TypeConverter
    fun toStringList(list: ArrayList<String>?): String {
        return Gson().toJson(list)
    }
}