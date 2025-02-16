package com.github.vipulasri.timelineview.sample.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Vipul Asri on 05-12-2015.
 */
@Parcelize
class TimelineModel(
        var message: String,
        var date: String,
        var status: OrderStatus
) : Parcelable
