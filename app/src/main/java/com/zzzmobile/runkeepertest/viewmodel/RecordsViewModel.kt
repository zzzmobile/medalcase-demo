package com.zzzmobile.runkeepertest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zzzmobile.runkeepertest.R
import com.zzzmobile.runkeepertest.data.RecordData
import com.zzzmobile.runkeepertest.other.RecordType

class RecordsViewModel(): ViewModel() {
    private val _records = MutableLiveData<List<RecordData.Record>>()
    val records: LiveData<List<RecordData.Record>> = _records

    fun loadRecords() {
        val data = mutableListOf<RecordData.Record>()

        // personal records
        data.add(RecordData.Record("Longest Run", R.drawable.longest_run, "00:00", RecordType.PERSONAL))
        data.add(RecordData.Record("Highest Elevation", R.drawable.highest_elevation, "2095 ft", RecordType.PERSONAL))
        data.add(RecordData.Record("Fastest 5K", R.drawable.fastest_5k, "00:00", RecordType.PERSONAL))
        data.add(RecordData.Record("10K", R.drawable.fastest_10k, "00:00:00", RecordType.PERSONAL))
        data.add(RecordData.Record("Half Marathon", R.drawable.fastest_half_marathon, "00:00", RecordType.PERSONAL))
        data.add(RecordData.Record("Marathon", R.drawable.fastest_marathon, "", RecordType.PERSONAL))

        // virtual races
        data.add(RecordData.Record("Virtual Half Marathon Race", R.drawable.virtual_half_marathon_race, "00:00", RecordType.VIRTUAL_RACES))
        data.add(RecordData.Record("Tokyo-Hakone Ekiden 2020", R.drawable.tokyo_kakone_ekiden, "00:00:00", RecordType.VIRTUAL_RACES))
        data.add(RecordData.Record("Virtual 10K Race", R.drawable.virtual_10k_race, "00:00:00", RecordType.VIRTUAL_RACES))
        data.add(RecordData.Record("Hakone Ekiden", R.drawable.hakone_ekiden, "00:00:00", RecordType.VIRTUAL_RACES))
        data.add(RecordData.Record("Mizuno Singapore Ekiden 2015", R.drawable.mizuno_singapore_ekiden, "00:00:00", RecordType.VIRTUAL_RACES))
        data.add(RecordData.Record("Virtual 5K Race", R.drawable.virtual_5k_race, "23:07", RecordType.VIRTUAL_RACES))

        _records.postValue(data)
    }
}