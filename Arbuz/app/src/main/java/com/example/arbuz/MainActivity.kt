package com.example.arbuz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arbuz.adapter.ViewAdapter
import com.example.arbuz.model.CategoryModel
import com.example.arbuz.model.ProductModel
import com.example.arbuz.model.ViewModel

class MainActivity : AppCompatActivity() {
    var discountRecyclerView: RecyclerView? = null
    var categoryRecyclerView: RecyclerView? = null
    var recentlyViewedRecycler: RecyclerView? = null
    var discountedProductsList: MutableList<ProductModel>? = null
    var categoryList: MutableList<CategoryModel>? = null
    var recentlyViewedAdapter: ViewAdapter? = null
    var recentlyViewedList: MutableList<ViewModel>? = null
    var allCategory: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recentlyViewedRecycler = findViewById(R.id.recently_item)
        allCategory?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@MainActivity, AllCategory::class.java)
            startActivity(i)
        })

        // adding data to model
        recentlyViewedList = ArrayList<ViewModel>()
        recentlyViewedList!!.add(
            ViewModel(
                "Спелый арбуз",
                "1.1 кг",
                R.drawable.card4,
                R.drawable.card4
            )
        )
        recentlyViewedList!!.add(
            ViewModel(
                "Неспелый арбуз",
                "1.1 кг",
                R.drawable.unride,
                R.drawable.unride
            )
        )
        recentlyViewedList!!.add(
            ViewModel(
                "Уже сорван",
                "0 кг",
                R.drawable.thwarted,
                R.drawable.thwarted
            )
        )
        setDiscountedRecycler(discountedProductsList)
        setCategoryRecycler(categoryList)
        setRecentlyViewedRecycler(recentlyViewedList)
    }

    private fun setDiscountedRecycler(dataList: List<ProductModel>?) {
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        discountRecyclerView!!.layoutManager = layoutManager
    }

    private fun setCategoryRecycler(categoryDataList: List<CategoryModel>?) {
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView!!.layoutManager = layoutManager
    }

    private fun setRecentlyViewedRecycler(recentlyViewedDataList: List<ViewModel>?) {
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recentlyViewedRecycler!!.layoutManager = layoutManager
        recentlyViewedAdapter = ViewAdapter(this, recentlyViewedDataList!!)
        recentlyViewedRecycler!!.adapter = recentlyViewedAdapter
    }
}
