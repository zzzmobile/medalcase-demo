package com.zzzmobile.runkeepertest.data

import com.zzzmobile.runkeepertest.other.ItemType
import com.zzzmobile.runkeepertest.other.RecordType

sealed class RecordData(val itemType: ItemType) {
    // record datamodel
    data class Record(val name: String,
                      val markImage: Int,
                      val record: String,
                      val recordType: RecordType
    ) : RecordData(ItemType.RECORD)

    // header datamodel
    data class Header(val name: String) : RecordData(ItemType.HEADER)
}