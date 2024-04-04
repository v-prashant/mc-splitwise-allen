package com.example.allen_spitwise.ui.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.allen_spitwise.R
import com.example.allen_spitwise.databinding.FragmentViewBalanceBinding


class ViewBalanceFragment : Fragment() {

    private var binding: FragmentViewBalanceBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewBalanceBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for(i in 0..5){
            addNameLayout()
            addBalanceLayout()
        }
    }

    private fun addNameLayout() {
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(32, 16, 0, 0)

        val nameView = TextView(requireContext()).apply {
            this.layoutParams = layoutParams
            text = "Prashant"
        }
        binding!!.containerName.addView(nameView)
    }

    private fun addBalanceLayout() {
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(16, 16, 0, 0)

        val balanceView = TextView(requireContext()).apply {
            this.layoutParams = layoutParams
            text = "500"
        }
        binding!!.containerBalance.addView(balanceView)
    }


    companion object {

        @JvmStatic
        fun newInstance( ): ViewBalanceFragment {
            return ViewBalanceFragment()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}