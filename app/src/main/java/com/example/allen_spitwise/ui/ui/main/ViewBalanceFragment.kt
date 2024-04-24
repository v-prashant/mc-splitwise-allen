package com.example.allen_spitwise.ui.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.allen_spitwise.databinding.FragmentViewBalanceBinding


class ViewBalanceFragment : Fragment() {

    private var binding: FragmentViewBalanceBinding? = null
    lateinit var viewModel: SplitWiseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewBalanceBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(SplitWiseViewModel::class.java)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData() {
        viewModel.getAllExpenses().observe(requireActivity()){
            val filterData = viewModel.filterData(data = it)

            binding?.containerName?.removeAllViews()
            binding?.containerBalance?.removeAllViews()
            filterData.forEach {
                addNameLayout(it.key)
                addBalanceLayout(it.value)
            }
        }
    }

    private fun addNameLayout(name: String) {
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(32, 16, 0, 0)

        val nameView = TextView(requireContext()).apply {
            this.layoutParams = layoutParams
            text = name
        }
        binding!!.containerName.addView(nameView)
    }

    private fun addBalanceLayout(balance: Int) {
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(16, 16, 0, 0)

        val balanceView = TextView(requireContext()).apply {
            this.layoutParams = layoutParams
            text = balance.toString()
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