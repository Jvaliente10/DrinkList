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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)


        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
           val response = drinkDetail?.let { RemoteConnection.service.getDetails(it.idDrink) }
            response

        }



    }




}