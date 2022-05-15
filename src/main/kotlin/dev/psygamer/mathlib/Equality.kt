package dev.psygamer.mathlib

import kotlin.math.abs

fun Float.almostEquals(other: Float, epsilon: Float = 0.0001f): Boolean {
	return abs(this - other) <= epsilon
}

fun Float.almostEquals(other: Double, epsilon: Double = 0.0001): Boolean {
	return abs(this - other) <= epsilon
}

fun Double.almostEquals(other: Float, epsilon: Float = 0.0001f): Boolean {
	return abs(this - other) <= epsilon
}

fun Double.almostEquals(other: Double, epsilon: Double = 0.0001): Boolean {
	return abs(this - other) <= epsilon
}