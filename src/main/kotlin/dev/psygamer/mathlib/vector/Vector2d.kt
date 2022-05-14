package dev.psygamer.mathlib.vector

import kotlin.math.*

open class Vector2d(val x: Double, val y: Double) {
	
	companion object {
		
		@JvmStatic
		val ZERO = Vector2d(0.0, 0.0)
		
		@JvmStatic
		val ONE = Vector2d(1.0, 1.0)
	}
	
	operator fun plus(other: Vector2d): Vector2d {
		return Vector2d(this.x + other.x, this.y + other.y)
	}
	
	operator fun minus(other: Vector2d): Vector2d {
		return Vector2d(this.x - other.x, this.y - other.y)
	}
	
	operator fun times(other: Vector2d): Vector2d {
		return Vector2d(this.x * other.x, this.y * other.y)
	}
	
	operator fun times(scalar: Double): Vector2d {
		return Vector2d((this.x * scalar), (this.y * scalar))
	}
	
	operator fun div(other: Vector2d): Vector2d {
		if (other.x == 0.0 || other.y == 0.0)
			throw ArithmeticException("Division by zero!")
		return Vector2d(this.x / other.x, this.y / other.y)
	}
	
	operator fun div(scalar: Double): Vector2d {
		if (scalar == 0.0)
			throw ArithmeticException("Division by zero!")
		return Vector2d((this.x / scalar), (this.y / scalar))
	}
	
	infix fun dot(other: Vector2d): Double {
		return (this.x * other.x + this.y * other.y)
	}
	
	val magnitude: Double
		get() = sqrt(this.x * this.x + this.y * this.y)
	
	val magnitudeSquared: Double
		get() = (this.x * this.x + this.y * this.y)
	
	infix fun distanceTo(other: Vector2d): Double {
		return (this - other).magnitude
	}
	
	infix fun distanceToSquared(other: Vector2d): Double {
		return (this - other).magnitudeSquared
	}
	
	val normalized: Vector2d
		get() = this / this.magnitude
	
	val angle: Double
		get() = atan2(this.x, this.y)
	
	fun angleBetween(other: Vector2d): Double {
		return acos(this dot other / (this.magnitude * other.magnitude))
	}
	
	val inverted
		get() = Vector2d(-this.x, -this.y)
	
	override fun toString(): String {
		return "Vector2d($x, $y)"
	}
	
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false
		
		other as Vector2d
		
		if (x != other.x) return false
		if (y != other.y) return false
		
		return true
	}
	
	override fun hashCode(): Int {
		var result = x.hashCode()
		result = 31 * result + y.hashCode()
		return result
	}
}