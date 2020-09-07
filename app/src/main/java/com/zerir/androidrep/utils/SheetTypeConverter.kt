package com.zerir.androidrep.utils

import androidx.room.TypeConverter
import com.zerir.androidrep.modules.repository.models.CharacterSheet
import java.util.*

class SheetTypeConverter {

    @TypeConverter
    fun fromSheet(sheet: CharacterSheet?): String? {
        if (sheet != null) {
            return String.format(Locale.US, "%d,%d,%d", sheet.round1, sheet.round1, sheet.round1)
        }
        return null
    }

    @TypeConverter
    fun toSheet(value: String?): CharacterSheet? {
        if (value != null) {
            val rounds = value.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            return CharacterSheet(
                round1 = rounds[0].toInt(),
                round2 = rounds[1].toInt(),
                round3 = rounds[2].toInt()
            )
        }
        return null
    }

}