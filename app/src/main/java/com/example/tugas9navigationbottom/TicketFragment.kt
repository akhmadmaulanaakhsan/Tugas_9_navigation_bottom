package com.example.tugas9navigationbottom

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.tugas9navigationbottom.databinding.FragmentTicketBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TicketFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TicketFragment : Fragment() {
    private var _binding: FragmentTicketBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("CheckoutFragment", "CheckoutFragment created")
        _binding = FragmentTicketBinding.inflate(inflater, container, false)

        binding.btnBuyTicket.setOnClickListener {
            Log.d("TicketFragment", "Button Buy Ticket clicked")
            // Navigasikan ke CheckoutFragment saat tombol Buy Ticket ditekan
            findNavController().navigate(R.id.action_ticketFragment_to_checkoutFragment)
        }

        return binding.root
    }

    //override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      //  super.onViewCreated(view, savedInstanceState)
        //with(binding) {
          ///  val action = HomeFragmentDirections.actionTicketFragmentToCheckoutFragment()
            //btnBuyTicket.setOnClickListener {
              //  findNavController().navigate(action)
           // }
        //}
    //}

    //override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    //    super.onViewCreated(view, savedInstanceState)
    //    with(binding) {
    //        val action = TicketFragmentDirections.actionHomeFragmentToCheckoutFragment(txtProductName.text.toString())
    //        btnBuy.setOnClickListener {
    //            findNavController().navigate(action)
    //        }
    //    }
    //}

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
         * @return A new instance of fragment TicketFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TicketFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}