package com.example.joseantoniovaliente.drinklist.ui.detail

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.joseantoniovaliente.drinklist.loadUrl
import com.example.joseantoniovaliente.drinklist.model.Drink
import com.example.joseantoniovaliente.drinklist.model.server.RemoteConnection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {
    private val _drink = MutableLiveData(drink)
    val drink: LiveData<Drink> get() = _drink

    init {
        val drinksDetail = arguments?.getParcelable<Drink>(DetailFragment.EXTRA_DRINK)
        val drinkId = drinksDetail?.idDrink

        viewModelScope.launch(Dispatchers.Main) {

            if (drinksDetail != null) {
                val drinkDetail = RemoteConnection.service.getCocktailById(drinkId)
                (requireActivity() as AppCompatActivity).supportActionBar?.title = drinkDetail.drinks[0].strDrink

            }
        }
    }


}