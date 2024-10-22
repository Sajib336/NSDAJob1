package com.example.nsdajob1.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nsdajob1.Product
import com.example.nsdajob1.R

class ProductAdapter (private val product : List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder> (){
    inner class ProductViewHolder (itemView:View) : RecyclerView.ViewHolder(itemView){

        val productImg:ImageView = itemView.findViewById(R.id.productImage)
        val productTitle:TextView = itemView.findViewById(R.id.productTitletv)
        val productId:TextView = itemView.findViewById(R.id.productIdtv)
        val productPrice:TextView = itemView.findViewById(R.id.productPriceTv)
        val productDesc:TextView = itemView.findViewById(R.id.productDescTv)

        fun bind(product: Product){
            Glide.with(itemView)
                .load(product.images[0])
                .into(productImg)
            productTitle.text = product.title
            productId.text = product.Id.toString()
            productPrice.text = "$${product.price}"
            productDesc.text = product.Description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return product.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = product[position]
        holder.bind (product)
    }
}