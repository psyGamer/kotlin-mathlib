package dev.psygamer.mathlib.vector

import kotlin.math.*

open class Vector2D(val x: Double, val y: Double) {

	companion object {

		@JvmStatic
		val ZERO = Vector2D(0.0, 0.0)

		@JvmStatic
		val ONE = Vector2D(1.0, 1.0)
	}

	operator fun plus(other: Vector2I): Vector2D {
		return Vector2D(this.x + other.x, this.y + other.y)
	}

	operator fun plus(other: Vector2F): Vector2D {
		return Vector2D(this.x + other.x, this.y + other.y)
	}

	operator fun plus(other: Vector2D): Vector2D {
		return Vector2D(this.x + other.x, this.y + other.y)
	}

	operator fun minus(other: Vector2I): Vector2D {
		return Vector2D(this.x - other.x, this.y - other.y)
	}

	operator fun minus(other: Vector2F): Vector2D {
		return Vector2D(this.x - other.x, this.y - other.y)
	}

	operator fun minus(other: Vector2D): Vector2D {
		return Vector2D(this.x - other.x, this.y - other.y)
	}

	operator fun times(other: Vector2I): Vector2D {
		return Vector2D(this.x * other.x, this.y * other.y)
	}

	operator fun times(other: Vector2F): Vector2D {
		return Vector2D(this.x * other.x, this.y * other.y)
	}

	operator fun times(other: Vector2D): Vector2D {
		return Vector2D(this.x * other.x, this.y * other.y)
	}

	operator fun times(scalar: Int): Vector2D {
		return Vector2D((this.x * scalar), (this.y * scalar))
	}

	operator fun times(scalar: Float): Vector2D {
		return Vector2D((this.x * scalar), (this.y * scalar))
	}

	operator fun times(scalar: Double): Vector2D {
		return Vector2D((this.x * scalar), (this.y * scalar))
	}

	operator fun div(other: Vector2I): Vector2D {
		if (other.x == 0 || other.y == 0)
			throw ArithmeticException("Division by zero!")
		return Vector2D(this.x / other.x, this.y / other.y)
	}

	operator fun div(other: Vector2F): Vector2D {
		if (other.x == 0.0f || other.y == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector2D(this.x / other.x, this.y / other.y)
	}

	operator fun div(other: Vector2D): Vector2D {
		if (other.x == 0.0 || other.y == 0.0)
			throw ArithmeticException("Division by zero!")
		return Vector2D(this.x / other.x, this.y / other.y)
	}

	operator fun div(scalar: Int): Vector2D {
		if (scalar == 0)
			throw ArithmeticException("Division by zero!")
		return Vector2D((this.x / scalar), (this.y / scalar))
	}

	operator fun div(scalar: Float): Vector2D {
		if (scalar == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector2D((this.x / scalar), (this.y / scalar))
	}

	operator fun div(scalar: Double): Vector2D {
		if (scalar == 0.0)
			throw ArithmeticException("Division by zero!")
		return Vector2D((this.x / scalar), (this.y / scalar))
	}

	infix fun dot(other: Vector2I): Double {
		return (this.x * other.x + this.y * other.y)
	}

	infix fun dot(other: Vector2F): Double {
		return (this.x * other.x + this.y * other.y)
	}

	infix fun dot(other: Vector2D): Double {
		return (this.x * other.x + this.y * other.y)
	}

	infix fun distanceTo(other: Vector2D): Double {
		return (this - other).magnitude
	}

	infix fun distanceToSquared(other: Vector2D): Double {
		return (this - other).magnitudeSquared
	}

	fun angleBetween(other: Vector2D): Double {
		return acos(this dot other / (this.magnitude * other.magnitude))
	}

	val magnitude: Double
		get() = sqrt(this.x * this.x + this.y * this.y)

	val magnitudeSquared: Double
		get() = (this.x * this.x + this.y * this.y)

	val normalized: Vector2D
		get() = this / this.magnitude

	val inverted
		get() = Vector2D(-this.x, -this.y)

	val angle: Double
		get() = atan2(this.x, this.y)

	override fun toString(): String {
		return "Vector2d($x, $y)"
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as Vector2D

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