package com.example.week2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week2.databinding.RestaurantBinding
import com.example.week2.RestauranViewModel

class RestaurantActivity : AppCompatActivity()  {
    lateinit var binding: RestaurantBinding
    lateinit var adapter: ResAdapter
    lateinit var viewModel: RestauranViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.restaurant)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[RestauranViewModel::class.java]

        setUpRecyclerView()
        setUpViewModelObservers()
    }

    private fun setUpViewModelObservers() {
        viewModel.menuLayoutType.observe(this){
            binding.rvRestaurant.layoutManager = viewModel.getLayout(this)
        }
    }

    private fun setUpRecyclerView() {
        binding.rvRestaurant.layoutManager = viewModel.getLayout(this)
        adapter = ResAdapter()
        binding.rvRestaurant.adapter = adapter

        run {
            adapter.submitList(DataStore.restaurantData.value)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.setLayout(item.itemId)
        return super.onOptionsItemSelected(item)
    }
}