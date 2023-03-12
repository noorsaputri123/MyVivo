package com.rie.myvivo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
//Noor Saputri
@Parcelize
data class Vivo (
    var name: String,
    var description: String,
    var photo: Int,
    var penyimpanan : String,
    var ram : String,
    var harga : String
) : Parcelable
