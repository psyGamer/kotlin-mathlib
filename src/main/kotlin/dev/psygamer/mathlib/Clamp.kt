package dev.psygamer.mathlib

import kotlin.math.*

fun Int.clamp(min: Int = 1, max: Int): Int {
	return min(max, max(min, this))
}

fun UInt.clamp(min: UInt = 1u, max: UInt): UInt {
	return min(max, max(min, this))
}

fun Long.clamp(min: Long = 1, max: Long): Long {
	return min(max, max(min, this))
}

fun ULong.clamp(min: ULong = 1u, max: ULong): ULong {
	return min(max, max(min, this))
}

fun Float.clamp(min: Float = 1.0f, max: Float): Float {
	return min(max, max(min, this))
}

fun Double.clamp(min: Double = 1.0, max: Double): Double {
	return min(max, max(min, this))
}

fun Float.clampToIntIfNear(epsilon: Float = 0.001f): Float {
	if (abs(this - this.roundToInt()) <= epsilon)
		return this.roundToInt().toFloat()
	return this
}

fun Double.clampToIntIfNear(epsilon: Double = 0.001): Double {
	if (abs(this - this.roundToInt()) <= epsilon)
		return this.roundToInt().toDouble()
	return this
}