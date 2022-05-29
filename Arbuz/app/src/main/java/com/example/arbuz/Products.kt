package com.example.arbuz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Products : AppCompatActivity() {
    var img: ImageView? = null
    var back: ImageView? = null
    var proName: TextView? = null
    var proDesc: TextView? = null
    var name: String? = null
    var desc: String? = null
    var image = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        val i = intent
        name = i.getStringExtra("name")
        desc = i.getStringExtra("desc")
        proName = findViewById(R.id.productName)
        proDesc = findViewById(R.id.prodDesc)
        img = findViewById(R.id.big_image)
        back = findViewById(R.id.back2)
        proName?.text=name
        proDesc?.text=desc
        img?.setImageResource(image)
        back?.setOnClickListener(View.OnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        })
    }
}