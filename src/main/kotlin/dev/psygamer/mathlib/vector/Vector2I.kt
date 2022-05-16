package dev.psygamer.mathlib.vector

import kotlin.math.*

open class Vector2I(val x: Int, val y: Int) {
	
	companion object {
		
		@JvmStatic
		val ZERO = Vector2I(0, 0)
		
		@JvmStatic
		val ONE = Vector2I(1, 1)
	}
	
	operator fun plus(other: Vector2I): Vector2I {
		return Vector2I(this.x + other.x, this.y + other.y)
	}
	
	operator fun minus(other: Vector2I): Vector2I {
		return Vector2I(this.x - other.x, this.y - other.y)
	}
	
	operator fun times(scalar: Float): Vector2I {
		return Vector2I((this.x * scalar).toInt(), (this.y * scalar).toInt())
	}
	
	operator fun times(scalar: Int): Vector2I {
		return Vector2I((this.x * scalar), (this.y * scalar))
	}
	
	operator fun times(other: Vector2I): Vector2I {
		return Vector2I(this.x * other.x, this.y * other.y)
	}
	
	operator fun div(other: Vector2I): Vector2I {
		if (other.x == 0 || other.y == 0)
			throw ArithmeticException("Division by zero!")
		return Vector2I(this.x / other.x, this.y / other.y)
	}
	
	operator fun div(scalar: Int): Vector2I {
		if (scalar == 0)
			throw ArithmeticException("Division by zero!")
		return Vector2I(this.x / scalar, this.y / scalar)
	}
	
	operator fun div(scalar: Float): Vector2F {
		if (scalar == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector2F(this.x / scalar, this.y / scalar)
	}
	
	infix fun dot(other: Vector2I): Int {
		return (this.x * other.x + this.y * other.y)
	}
	
	infix fun distanceTo(other: Vector2I): Float {
		return (this - other).magnitude
	}
	
	infix fun distanceToSquared(other: Vector2I): Int {
		return (this - other).magnitudeSquared
	}
	
	fun angleBetween(other: Vector2I): Float {
		return acos((this dot other) / (this.magnitude * other.magnitude))
	}
	
	val magnitude: Float
		get() = sqrt((this.x * this.x + this.y * this.y).toFloat())
	
	val magnitudeSquared: Int
		get() = (this.x * this.x + this.y * this.y)
	
	val normalized: Vector2F
		get() = this / this.magnitude
	
	val angle: Float
		get() = atan2(this.x.toFloat(), this.y.toFloat())
	
	val inverted
		get() = Vector2I(-this.x, -this.y)
	
	override fun toString(): String {
		return "Vector2i($x, $y)"
	}
	
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false
		
		other as Vector2I
		
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