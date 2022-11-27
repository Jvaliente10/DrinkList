package com.example.joseantoniovaliente.drinklist.ui.main


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.joseantoniovaliente.drinklist.R
import com.example.joseantoniovaliente.drinklist.databinding.FragmentMainBinding
import com.example.joseantoniovaliente.drinklist.model.Drink
import com.example.joseantoniovaliente.drinklist.model.server.RemoteConnection
import com.example.joseantoniovaliente.drinklist.ui.detail.DetailFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainFragment : Fragment(R.layout.fragment_main) {


    private lateinit var binding: FragmentMainBinding
    private val adapter = CocktailAdapter(emptyList()){drink -> navigateTo(drink)  }

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

    private fun navigateTo(drink: Drink) {
        findNavController().navigate(
            R.id.action_mainFragment_to_detailFragment,
            bundleOf(DetailFragment.EXTRA_DRINK to drink)
        )

    }
}





