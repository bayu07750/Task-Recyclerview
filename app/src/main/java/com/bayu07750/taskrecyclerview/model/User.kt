package com.bayu07750.taskrecyclerview.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    @DrawableRes val avatar: Int
) : Parcelable