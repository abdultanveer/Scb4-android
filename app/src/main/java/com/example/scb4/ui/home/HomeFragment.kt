package com.example.scb4.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.scb4.InventoryApplication
import com.example.scb4.data.Item
import com.example.scb4.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels<HomeViewModel> {
        InventoryViewModelFactory(
            (activity?.application as InventoryApplication).database
                .itemDao()
        )
    }

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       /* val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
*/
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        /*homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
*/
        binding.btnInsert.setOnClickListener{
            addItem()
        }

        binding.btnGet.setOnClickListener {
            findItem()
        }

        return root
    }

    private fun findItem() {
        viewModel.retrieveItem(binding.etId.text.toString().toInt()).observe(this.viewLifecycleOwner) {
            foundItem -> binding.tvItem.text = foundItem.toString()
        }
    }

    private fun addItem() {

        var name = binding.etItemName.text.toString()
        var price = binding.etItemPrice.text.toString().toDouble()
        var quantity = binding.etQuantity.text.toString().toInt()
        viewModel.insertItem(Item(itemName = name, itemPrice = price, quantityInStock = quantity))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}