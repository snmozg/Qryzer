package com.sozge.qryzer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sozge.qryzer.databinding.FragmentQrCodeBinding

class QrCodeFragment : Fragment() {
    private var _binding: FragmentQrCodeBinding? = null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {_binding = FragmentQrCodeBinding.inflate(inflater,container, false)
        val view = binding.root
        return view }


}