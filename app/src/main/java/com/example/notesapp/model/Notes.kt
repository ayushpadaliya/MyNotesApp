package com.example.notesapp.model

import android.os.Parcelable
import java.io.Serializable

data class Notes(
    val id : String,
    var title : String,
    var description : String,
    var date : String
): Serializable
