package com.zzzmobile.runkeepertest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zzzmobile.runkeepertest.R
import com.zzzmobile.runkeepertest.data.RecordData
import com.zzzmobile.runkeepertest.other.ItemType
import com.zzzmobile.runkeepertest.other.RecordType
import kotlinx.android.synthetic.main.layout_header.view.*
import kotlinx.android.synthetic.main.layout_record_item.view.*

class RecordsAdapter(private val items: List<RecordData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = items[position].itemType.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (ItemType.values()[viewType]) {
            ItemType.RECORD -> RecordViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.layout_record_item, parent, false)
            )
            ItemType.HEADER -> HeaderViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.layout_header, parent, false)
            )
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (val item = items[position]) {
            is RecordData.Record -> (holder as RecordViewHolder).bind(item)
            is RecordData.Header -> (holder as HeaderViewHolder).bind(item)
        }

    class RecordViewHolder(private val recordView: View) : RecyclerView.ViewHolder(recordView) {
        fun  bind(record: RecordData.Record) {
            recordView.imgRecord.setImageResource(record.markImage)
            recordView.textName.text = record.name
            if (record.record.isEmpty())
                recordView.textRecord.text = recordView.context.getString(R.string.not_yet)
            else
                recordView.textRecord.text = record.record

            if (record.record.isEmpty()) {
                recordView.imgRecord.alpha = .2f
            } else {
                recordView.imgRecord.alpha = 1f
            }
        }
    }

    class HeaderViewHolder(private val headerView: View) : RecyclerView.ViewHolder(headerView) {
        fun bind(header: RecordData.Header) {
            if (header.name == RecordType.PERSONAL.name)
                headerView.textHeader.text = headerView.context.getString(R.string.personal_records)
            else
                headerView.textHeader.text = headerView.context.getString(R.string.virtual_races)
        }
    }
}