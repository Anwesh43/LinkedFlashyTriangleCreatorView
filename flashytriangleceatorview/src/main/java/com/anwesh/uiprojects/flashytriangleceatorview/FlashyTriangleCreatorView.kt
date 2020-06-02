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
import android.graphics.PointF

val nodes : Int = 5
val parts : Int = 3
val scGap : Float = 0.02f / parts
val rFactor : Float = 2.8f
val sizeFactor : Float = 2.9f
val delay : Long = 20
val foreColor : Int = Color.parseColor("#4CAF50")
val backColor : Int = Color.parseColor("#BDBDBD")
val strokeFactor : Float = 90f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawFlashyTrianglePart(i : Int, scale : Float, size : Float, paint : Paint) {
    var sci : Float = scale.divideScale(i, parts)
    val sfi : Float = sci.sinify()
    val r : Float = size / rFactor
    val rsf : Float = r * sfi
    val verts : Array<Array<Float>> = arrayOf(arrayOf(0f, -size), arrayOf(size, size), arrayOf(-size, size))
    val iNext : Int = (i + 1) % verts.size
    val diffNext : PointF = PointF(verts[iNext][0] - verts[i][0], verts[iNext][1] - verts[i][1])
    save()
    translate(verts[i][0], verts[i][1])
    drawCircle(0f, 0f, rsf, paint)
    drawLine(0f, 0f, diffNext.x * sci, diffNext.y * sci, paint)
    restore()
}

fun Canvas.drawFTPNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(w / 2, gap * (i + 1))
    for (j in 0..(parts - 1)) {
        drawFlashyTrianglePart(j, scale, size, paint)
    }
    restore()
}

class FlashyTriangleCreatorView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}
