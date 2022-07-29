package com.zzzmobile.runkeepertest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.zzzmobile.runkeepertest.R
import com.zzzmobile.runkeepertest.adapter.RecordsAdapter
import com.zzzmobile.runkeepertest.data.RecordData
import com.zzzmobile.runkeepertest.di.Injection
import com.zzzmobile.runkeepertest.other.ItemType
import com.zzzmobile.runkeepertest.viewmodel.RecordsViewModel
import kotlinx.android.synthetic.main.fragment_records.*


class RecordsFragment : Fragment() {

    private lateinit var viewModel: RecordsViewModel
    private var adapter: RecordsAdapter? = null

    private val recordList = mutableListOf<RecordData>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_records, container, false)
        loadRecords()
        return view
    }

    private fun loadRecords() {
        viewModel = ViewModelProvider(this, Injection.provideViewModelFactory()).get(RecordsViewModel::class.java)

        // observes
        viewModel.records.observe(viewLifecycleOwner) { list ->
            // make grouped list from data
            val records = list.groupBy { it.recordType }.flatMap {
                listOf(RecordData.Header(it.key.name), *(it.value.map { r ->
                    (RecordData.Record(
                        name = r.name,
                        markImage = r.markImage,
                        record = r.record,
                        recordType = r.recordType
                    ))
                }).toTypedArray())
            }

            recordList.addAll(records)

            adapter = RecordsAdapter(recordList)
            rvRecords.setHasFixedSize(true)
            val layoutManager = GridLayoutManager(requireContext(), 2)
            layoutManager.spanSizeLookup = object : SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    val recordData = recordList[position]
                    return if (recordData.itemType == ItemType.RECORD)
                        1
                    else
                        2
                }
            }
            rvRecords.layoutManager = layoutManager
            rvRecords.adapter = adapter
        }

        viewModel.loadRecords()
    }

    companion object {
        @JvmStatic
        fun newInstance() = RecordsFragment()
    }
}