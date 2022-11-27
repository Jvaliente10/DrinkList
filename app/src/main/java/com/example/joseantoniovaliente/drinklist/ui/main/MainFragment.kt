package com.example.joseantoniovaliente.drinklist.ui.main


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.joseantoniovaliente.drinklist.R
import com.example.joseantoniovaliente.drinklist.databinding.FragmentMainBinding
import com.example.joseantoniovaliente.drinklist.model.server.RemoteConnection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainFragment : Fragment(R.layout.fragment_main) {


    private lateinit var binding: FragmentMainBinding
    private val adapter = CocktailAdapter(emptyList()){}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter = adapter

            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                val getDrinks = RemoteConnection.service.drinkList()
                adapter.drinkList= getDrinks.drinks
                adapter.notifyDataSetChanged()
            }

        }
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)



    }
}





