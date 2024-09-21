package com.sozge.qryzer

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import com.sozge.qryzer.databinding.FragmentQrCodeBinding

class QrCodeFragment : Fragment() {
    private var _binding: FragmentQrCodeBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val CAMERA_PERMİSSİON_REQUEST_CODE = 123
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {_binding = FragmentQrCodeBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkForPermission()
    }

    private fun checkForPermission() {
        if(ActivityCompat.checkSelfPermission(requireContext(),android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED) {
            scanerFragment()
        }else
            requestThePermission()

    }
    private fun requestThePermission(){
        ActivityCompat.requestPermissions(
            requireContext() as Activity, arrayOf(android.Manifest.permission.CAMERA),
            CAMERA_PERMİSSİON_REQUEST_CODE)
    }

    private fun scanerFragment(){

    }
}