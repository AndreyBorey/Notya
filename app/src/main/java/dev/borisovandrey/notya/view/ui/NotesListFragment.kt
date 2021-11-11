package dev.borisovandrey.notya.view.ui

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import dev.borisovandrey.notya.DataSource
import dev.borisovandrey.notya.R
import dev.borisovandrey.notya.databinding.FragmentNotesListBinding
import dev.borisovandrey.notya.view.adapter.NotesListAdapter


class NotesListFragment : Fragment() {
    private var _binding: FragmentNotesListBinding? = null
    private val binding get() = _binding!!

    private lateinit var notesListAdapter: NotesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotesListBinding.inflate(inflater, container, false)
        val view = binding.root
        initRecyclerView()
        addDataSet()
        return view
    }

    private fun addDataSet(){
        val data = DataSource.createDataSet()
        notesListAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        val recyclerView = binding.rvNotes
        notesListAdapter = NotesListAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = notesListAdapter
        }
//        recyclerView.layoutManager = LinearLayoutManager(context)
//        notesListAdapter = NotesListAdapter()
//        recyclerView.adapter = notesListAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}