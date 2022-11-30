package com.example.joseantoniovaliente.drinklist.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.joseantoniovaliente.drinklist.R
import com.example.joseantoniovaliente.drinklist.databinding.FragmentDetailBinding
import com.example.joseantoniovaliente.drinklist.loadUrl
import com.example.joseantoniovaliente.drinklist.model.Drink
import com.example.joseantoniovaliente.drinklist.model.server.RemoteConnection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DetailFragment() : Fragment(R.layout.fragment_detail) {


    companion object{
        const val EXTRA_DRINK = "DetailFragment:DrinkDetail"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)

        val drinksDetail = arguments?.getParcelable<Drink>(EXTRA_DRINK)
        val drinkId = drinksDetail?.idDrink

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {

            if (drinksDetail != null) {
                val drinkDetail = RemoteConnection.service.getCocktailById(drinkId)
                (requireActivity() as AppCompatActivity).supportActionBar?.title = drinkDetail.drinks[0].strDrink
               binding.imagen.loadUrl(drinksDetail.strDrinkThumb)
                binding.textView.text=drinkDetail.drinks[0].strDrink
            }
        }
    }




}