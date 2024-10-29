package com.inforcap.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val id:Int,
    val name: String,
    val address: String,
    val officeHours: String,
    val photo: String,
    val history: String
) : Parcelable