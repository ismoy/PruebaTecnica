package com.ismoyb.pruebatecnica.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ismoyb.pruebatecnica.data.OnItemClickListener
import com.ismoyb.pruebatecnica.databinding.FragmentBooksBinding
import com.ismoyb.pruebatecnica.presentation.BooksViewModel
import com.ismoyb.pruebatecnica.ui.adapters.BooksAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BooksFragment : Fragment(), OnItemClickListener {
    private lateinit var binding: FragmentBooksBinding
    private val viewModel:BooksViewModel by viewModels()
    private lateinit var booksAdapter: BooksAdapter
    private  lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBooksBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        booksAdapter = BooksAdapter(this)
        navController = Navigation.findNavController(view)
        initializeComponent()
        searchBooks()
    }

    private fun initializeComponent() {
        with(binding){
            booksRecyclerview.apply {
                adapter = booksAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }
    }

    private fun searchBooks() {
        with(binding){
            namebook.doOnTextChanged { books, _, _, _ ->
                searchBooks.isEnabled = books!!.isNotEmpty()
            }
            searchBooks.setOnClickListener(requestSearchBook())
        }

    }

    private fun requestSearchBook(): View.OnClickListener {
      return View.OnClickListener {
          viewModel.searchBooks(binding.namebook.text.toString())
          viewModel.books.observe(viewLifecycleOwner){response->
              booksAdapter.submitList(response)
          }
      }
    }

    override fun onItemClicked(itemImage: String) {
        val action =  BooksFragmentDirections.actionBooksFragmentToDetailsFragment (itemImage)
        navController.navigate(action)

    }

}