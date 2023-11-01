package com.example.tugas9navigationbottom

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tugas9navigationbottom.databinding.FragmentCheckoutBinding
import com.example.tugas9navigationbottom.databinding.FragmentTicketBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CheckoutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckoutFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentCheckoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //override fun onCreateView(
     //   inflater: LayoutInflater, container: ViewGroup?,
       // savedInstanceState: Bundle?
    //): View? {
      //  _binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        //return binding.root
    //}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        val rootView = binding.root

        // data untuk Spinner
        val ticketOptions = listOf("Jenis Tiket", "First Class Ticket", "Bussines Class Ticket", "Economy Class Ticket")

        // Inisialisasi Spinner
        val spinner: Spinner = binding.spinnerTicket

        // Buat adapter untuk Spinner
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            ticketOptions
        )

        // Menentukan tata letak dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        // penanganan item yang dipilih (opsional)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (position == 0) {
                    Toast.makeText(requireContext(), "Please select a valid option", Toast.LENGTH_SHORT).show()
                } else {
                    val selectedOption: String = ticketOptions[position]
                }
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Tidak ada yang dipilih
            }
        }

        // Setelah menangani Spinner, tambahkan listener untuk tombol "Buy Ticket"
        binding.btnBuyTicket.setOnClickListener {
            Log.d("TicketFragment", "Button Buy Ticket clicked")
            // Navigasikan ke CheckoutFragment saat tombol Buy Ticket ditekan
            findNavController().navigate(R.id.action_checkoutFragment_to_ticketFragment)
        }

        // Kembalikan rootView
        return rootView
    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CheckoutFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CheckoutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}