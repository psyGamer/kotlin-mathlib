package dev.psygamer.mathlib.vector

import kotlin.math.*

open class Vector2f(val x: Float, val y: Float) {
	
	companion object {
		
		@JvmStatic
		val ZERO = Vector2f(0.0f, 0.0f)
		
		@JvmStatic
		val ONE = Vector2f(1.0f, 1.0f)
	}
	
	operator fun plus(other: Vector2i): Vector2f {
		return Vector2f(this.x + other.x, this.y + other.y)
	}
	
	operator fun plus(other: Vector2f): Vector2f {
		return Vector2f(this.x + other.x, this.y + other.y)
	}
	
	operator fun minus(other: Vector2i): Vector2f {
		return Vector2f(this.x - other.x, this.y - other.y)
	}
	
	operator fun minus(other: Vector2f): Vector2f {
		return Vector2f(this.x - other.x, this.y - other.y)
	}
	
	operator fun times(other: Vector2i): Vector2f {
		return Vector2f(this.x * other.x, this.y * other.y)
	}
	
	operator fun times(other: Vector2f): Vector2f {
		return Vector2f(this.x * other.x, this.y * other.y)
	}
	
	operator fun times(scalar: Int): Vector2f {
		return Vector2f((this.x * scalar), (this.y * scalar))
	}
	
	operator fun times(scalar: Float): Vector2f {
		return Vector2f((this.x * scalar), (this.y * scalar))
	}
	
	operator fun div(other: Vector2i): Vector2f {
		if (other.x == 0 || other.y == 0)
			throw ArithmeticException("Division by zero!")
		return Vector2f(this.x / other.x, y / other.y)
	}
	
	operator fun div(other: Vector2f): Vector2f {
		if (other.x == 0.0f || other.y == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector2f(this.x / other.x, y / other.y)
	}
	
	operator fun div(scalar: Int): Vector2f {
		if (scalar == 0)
			throw ArithmeticException("Division by zero!")
		return Vector2f((this.x / scalar), (this.y / scalar))
	}
	
	operator fun div(scalar: Float): Vector2f {
		if (scalar == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector2f((this.x / scalar), (this.y / scalar))
	}
	
	infix fun dot(other: Vector2i): Float {
		return (this.x * other.x + this.y * other.y)
	}
	
	infix fun dot(other: Vector2f): Float {
		return (this.x * other.x + this.y * other.y)
	}
	
	infix fun distanceTo(other: Vector2i): Float {
		return (this - other).magnitude
	}
	
	infix fun distanceTo(other: Vector2f): Float {
		return (this - other).magnitude
	}
	
	infix fun distanceToSquared(other: Vector2i): Float {
		return (this - other).magnitudeSquared
	}
	
	infix fun distanceToSquared(other: Vector2f): Float {
		return (this - other).magnitudeSquared
	}
	
	fun angleBetween(other: Vector2f): Float {
		return acos(this dot other / (this.magnitude * other.magnitude))
	}
	
	val magnitude: Float
		get() = sqrt(this.x * this.x + this.y * this.y)
	
	val magnitudeSquared: Float
		get() = this.x * this.x + this.y * this.y
	
	val normalized: Vector2f
		get() = this / this.magnitude
	
	val angle: Float
		get() = atan2(this.x, this.y)
	
	val inverted
		get() = Vector2f(-this.x, -this.y)
	
	override fun toString(): String {
		return "Vector2f($x, $y)"
	}
	
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false
		
		other as Vector2f
		
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
