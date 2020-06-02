package com.anwesh.uiprojects.flashytriangleceatorview

/**
 * Created by anweshmishra on 02/06/20.
 */

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.app.Activity
import android.content.Context

val nodes : Int = 5
val parts : Int = 3
val scGap : Float = 0.02f / parts
val rFactor : Float = 2.8f
val sizeFactor : Float = 2.9f
val delay : Long = 20
val foreColor : Int = Color.parseColor("#4CAF50")
val backColor : Int = Color.parseColor("#BDBDBD")
