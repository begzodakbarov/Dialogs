package com.example.dialogs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.dialogs.databinding.FragmentMyDialogBinding


class MyDialogFragment : DialogFragment() {

        private val binding by lazy { FragmentMyDialogBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        binding.cancel.setOnClickListener {
            Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        binding.submit.setOnClickListener {
            val selectedId = binding.radioGrup.checkedRadioButtonId
            val radio = binding.root.findViewById<RadioButton>(selectedId)
            var ratinResult = radio.text.toString()

            Toast.makeText(context, "Kayfiyatingiz: $ratinResult", Toast.LENGTH_SHORT).show()

            dismiss()
        }

        return binding.root
    }


            }
