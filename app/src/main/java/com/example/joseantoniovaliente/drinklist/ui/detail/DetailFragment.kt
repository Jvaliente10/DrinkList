package com.example.joseantoniovaliente.drinklist.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.joseantoniovaliente.drinklist.R
import com.example.joseantoniovaliente.drinklist.databinding.FragmentDetailBinding
import com.example.joseantoniovaliente.drinklist.model.DrinkDetails
import com.example.joseantoniovaliente.drinklist.model.server.RemoteConnection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DetailFragment() : Fragment(R.layout.fragment_detail) {


    companion object{
        const val EXTRA_DRINK = "DetailFragment:DrinkDetail"
    }

    val drinkDetail = arguments?.getParcelable<DrinkDetails>(EXTRA_DRINK)

    val idDrink = drinkDetail?.idDrink

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Default) {

            if (idDrink != null) {
                val listaDetalles= RemoteConnection.service.getDetails(idDrink)
                val detallesId=listaDetalles.drinks
                binding.textView.text=detallesId[0].strDrink
            }
        }
    }




}