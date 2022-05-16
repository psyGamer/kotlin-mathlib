package dev.psygamer.mathlib.vector

import kotlin.math.*

open class Vector2F(val x: Float, val y: Float) {
	
	companion object {
		
		@JvmStatic
		val ZERO = Vector2F(0.0f, 0.0f)
		
		@JvmStatic
		val ONE = Vector2F(1.0f, 1.0f)
	}
	
	operator fun plus(other: Vector2I): Vector2F {
		return Vector2F(this.x + other.x, this.y + other.y)
	}
	
	operator fun plus(other: Vector2F): Vector2F {
		return Vector2F(this.x + other.x, this.y + other.y)
	}
	
	operator fun minus(other: Vector2I): Vector2F {
		return Vector2F(this.x - other.x, this.y - other.y)
	}
	
	operator fun minus(other: Vector2F): Vector2F {
		return Vector2F(this.x - other.x, this.y - other.y)
	}
	
	operator fun times(other: Vector2I): Vector2F {
		return Vector2F(this.x * other.x, this.y * other.y)
	}
	
	operator fun times(other: Vector2F): Vector2F {
		return Vector2F(this.x * other.x, this.y * other.y)
	}
	
	operator fun times(scalar: Int): Vector2F {
		return Vector2F((this.x * scalar), (this.y * scalar))
	}
	
	operator fun times(scalar: Float): Vector2F {
		return Vector2F((this.x * scalar), (this.y * scalar))
	}
	
	operator fun div(other: Vector2I): Vector2F {
		if (other.x == 0 || other.y == 0)
			throw ArithmeticException("Division by zero!")
		return Vector2F(this.x / other.x, y / other.y)
	}
	
	operator fun div(other: Vector2F): Vector2F {
		if (other.x == 0.0f || other.y == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector2F(this.x / other.x, y / other.y)
	}
	
	operator fun div(scalar: Int): Vector2F {
		if (scalar == 0)
			throw ArithmeticException("Division by zero!")
		return Vector2F((this.x / scalar), (this.y / scalar))
	}
	
	operator fun div(scalar: Float): Vector2F {
		if (scalar == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector2F((this.x / scalar), (this.y / scalar))
	}
	
	infix fun dot(other: Vector2I): Float {
		return (this.x * other.x + this.y * other.y)
	}
	
	infix fun dot(other: Vector2F): Float {
		return (this.x * other.x + this.y * other.y)
	}
	
	infix fun distanceTo(other: Vector2I): Float {
		return (this - other).magnitude
	}
	
	infix fun distanceTo(other: Vector2F): Float {
		return (this - other).magnitude
	}
	
	infix fun distanceToSquared(other: Vector2I): Float {
		return (this - other).magnitudeSquared
	}
	
	infix fun distanceToSquared(other: Vector2F): Float {
		return (this - other).magnitudeSquared
	}
	
	fun angleBetween(other: Vector2F): Float {
		return acos(this dot other / (this.magnitude * other.magnitude))
	}
	
	val magnitude: Float
		get() = sqrt(this.x * this.x + this.y * this.y)
	
	val magnitudeSquared: Float
		get() = this.x * this.x + this.y * this.y
	
	val normalized: Vector2F
		get() = this / this.magnitude
	
	val angle: Float
		get() = atan2(this.x, this.y)
	
	val inverted
		get() = Vector2F(-this.x, -this.y)
	
	override fun toString(): String {
		return "Vector2f($x, $y)"
	}
	
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false
		
		other as Vector2F
		
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
