package com.example.joseantoniovaliente.drinklist.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.joseantoniovaliente.drinklist.R
import com.example.joseantoniovaliente.drinklist.databinding.ViewCocktailBinding
import com.example.joseantoniovaliente.drinklist.inflate
import com.example.joseantoniovaliente.drinklist.loadUrl
import com.example.joseantoniovaliente.drinklist.model.Drink

class CocktailAdapter(var drinkList : List<Drink>, val listener: (Drink) -> Unit):
    RecyclerView.Adapter<CocktailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_cocktail, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(drinkList[position])
        holder.itemView.setOnClickListener{
            listener(drinkList[position])
        }
    }

    override fun getItemCount(): Int = drinkList.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ViewCocktailBinding.bind(view)
        fun bind(drink: Drink){
            binding.title.text = drink.strDrink
            binding.imagen.loadUrl(drink.strDrinkThumb)
        }
    }
}