package com.example.arbuz.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.arbuz.Products
import com.example.arbuz.R
import com.example.arbuz.model.ViewModel

class ViewAdapter(var context: Context, recentlyViewedList: List<ViewModel>) :
    RecyclerView.Adapter<ViewAdapter.RecentlyViewedViewHolder>() {
    var recentlyViewedList: List<ViewModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentlyViewedViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.activity_product_details, parent, false)
        return RecentlyViewedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecentlyViewedViewHolder, position: Int) {
        holder.name.setText(recentlyViewedList[position].name)
        holder.description.setText(recentlyViewedList[position].description)
        holder.bg.setBackgroundResource(recentlyViewedList[position].imageUrl)
        holder.itemView.setOnClickListener {
            val i = Intent(context, Products::class.java)
            i.putExtra("name", recentlyViewedList[position].name)
            i.putExtra("image", recentlyViewedList[position].bigimageurl)
            i.putExtra("desc", recentlyViewedList[position].description)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return recentlyViewedList.size
    }

    class RecentlyViewedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var description: TextView
        var bg: ConstraintLayout

        init {
            name = itemView.findViewById(R.id.productName)
            description = itemView.findViewById(R.id.prodDesc)
            bg = itemView.findViewById(R.id.button)
        }
    }

    init {
        this.recentlyViewedList = recentlyViewedList
    }
}