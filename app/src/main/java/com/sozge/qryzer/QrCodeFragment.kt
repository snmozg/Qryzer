package com.sozge.qryzer

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
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
        return view
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView.setOnClickListener{appIconClicked(it)}


    }

    private fun appIconClicked(view: View){

        if(ContextCompat.checkSelfPermission(requireContext(),android.Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {

            requestCameraPermission()

        } else {

            val action =  QrCodeFragmentDirections.actionQrCodeFragmentToScanerFragment()
            Navigation.findNavController(requireView()).navigate(action)

        }
    }


    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->


        if (isGranted) {
            Toast.makeText(requireContext(), "Permission granted!", Toast.LENGTH_LONG).show()
            val action = QrCodeFragmentDirections.actionQrCodeFragmentToScanerFragment()
            Navigation.findNavController(requireView()).navigate(action)

        } else {

            Snackbar.make(View(requireContext()), "permission denied!", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun requestCameraPermission(){

        if(ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),android.Manifest.permission.CAMERA)){

            requestPermissionLauncher.launch(android.Manifest.permission.CAMERA)
        } else{

            requestPermissionLauncher.launch(android.Manifest.permission.CAMERA)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }






}