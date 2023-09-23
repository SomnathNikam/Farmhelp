package com.example.farmhelp1.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.farmhelp1.databinding.FragmentInfoBinding

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [info.newInstance] factory method to
 * create an instance of this fragment.
 */
class info : Fragment() {
    //

    private var _binding:FragmentInfoBinding? =null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentInfoBinding.inflate(inflater,container,false)
      val list = listOf("Abhay","Joseph","Haria","Avni","Apoorva","Chris","Dravid","Kaira","Dwayne","Christoper",
          "Jim","Russel","Donald","Brack","Vladimir")

        val listAdapter:ArrayAdapter<*>

        listAdapter=ArrayAdapter(requireContext(),
            android.R.layout.simple_list_item_1,
            list)
        binding.listview1.adapter=listAdapter;

        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                binding.searchBar.clearFocus()
                if (list.contains(p0)) {
                    listAdapter.filter.filter(p0)
                }
                return false
            }


            override fun onQueryTextChange(p0: String?): Boolean {

                listAdapter.filter.filter(p0)
                return false
            }
        })




    return binding.root
    }

//    private fun ArrayAdapter(info: info, simpleListItem1: Int, list: Array<String>): ArrayAdapter<*> {
//
//    }


}