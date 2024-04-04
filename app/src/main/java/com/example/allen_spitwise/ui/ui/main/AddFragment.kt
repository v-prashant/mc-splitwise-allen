package com.example.allen_spitwise.ui.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.allen_spitwise.databinding.FragmentAddBinding
import com.example.allen_spitwise.ui.data.AddAmountItem


class AddFragment : Fragment() {

    private var binding: FragmentAddBinding? = null
    lateinit var viewModel: SplitWiseViewModel

    private val participateList = ArrayList<EditText>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(SplitWiseViewModel::class.java)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
    }

    private fun onClickListener() {
         binding?.btnAddParticipate?.setOnClickListener{
             addNewEditText()
         }
         binding?.btnAdd?.setOnClickListener {
             if(isValidation()){
                 viewModel.addSplitWiseData(getData())
             }
         }
    }

    private fun isValidation(): Boolean {
        if(binding?.etExpenses?.text.isNullOrBlank()){
            Toast.makeText(requireContext(), "Please add expense", Toast.LENGTH_SHORT).show()
            return false
        }else if(binding?.etTotalAmount?.text.isNullOrBlank()){
            Toast.makeText(requireContext(), "Please add total amount", Toast.LENGTH_SHORT).show()
            return false
        }else if(binding?.etPaidBy?.text.isNullOrBlank()){
            Toast.makeText(requireContext(), "Please add paid By", Toast.LENGTH_SHORT).show()
            return false
        }else if(isNotValidParticipateList()){
            Toast.makeText(requireContext(), "Please add at least one participate", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun isNotValidParticipateList(): Boolean{
        participateList.forEach {
            if(it.text.isNotBlank())
                return false
        }
        return true
    }

    private fun getData(): AddAmountItem {
        return AddAmountItem(
            expenseName = binding?.etExpenses?.text.toString(),
                totalAmount = binding?.etTotalAmount?.text.toString().toInt(),
                paidBy = binding?.etPaidBy?.text.toString(),
                participate = getParticipate())
    }

    private fun getParticipate(): ArrayList<String> {
        val list = ArrayList<String>()
        participateList.forEach {
            if(it.text.isNotBlank()){
                list.add(it.text.toString())
            }
        }

        return list
    }

    private fun addNewEditText() {
        val editText = EditText(requireContext())
        editText.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.FILL_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        binding!!.container.addView(editText)
        participateList.add(editText)
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        @JvmStatic
        fun newInstance(): AddFragment {
            return AddFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}