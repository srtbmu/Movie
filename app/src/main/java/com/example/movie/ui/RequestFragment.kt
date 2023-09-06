package com.example.movie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movie.R
import com.example.movie.databinding.FragmentRequestBinding
import com.example.movie.presenter.RequestPresenter
import com.example.movie.view.RequestView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RequestFragment : Fragment(), RequestView {

    private lateinit var binding: FragmentRequestBinding

    @Inject
    lateinit var presenter: RequestPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRequestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        initClicker()
    }

    private fun initClicker() {
        binding.btnSend.setOnClickListener {
            if (binding.etMovie.length() != 0){
                navigateTo(binding.etMovie.text.toString())
            }else{
                Toast.makeText(requireActivity(), "Null Movie", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateTo(movieTitle: String) {
        val titleMovie = movieTitle
        findNavController().navigate(R.id.resultFragment, bundleOf("key_search" to titleMovie))
    }

}