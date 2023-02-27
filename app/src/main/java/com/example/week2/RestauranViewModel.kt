package com.example.week2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RestauranViewModel: ViewModel() {

    private val _menuLayoutType: MutableLiveData<Int> = MutableLiveData(R.id.menu_linear)
    val menuLayoutType: LiveData<Int>
        get() = _menuLayoutType

    fun getLayout(restaurantActivity: RestaurantActivity): RecyclerView.LayoutManager {
        return when (_menuLayoutType.value) {
            R.id.menu_linear -> LinearLayoutManager(restaurantActivity)
            else -> {
                GridLayoutManager(restaurantActivity, 2)
            }
        }
    }

    fun setLayout(itemId: Int) {
        _menuLayoutType.postValue(itemId)
    }
}