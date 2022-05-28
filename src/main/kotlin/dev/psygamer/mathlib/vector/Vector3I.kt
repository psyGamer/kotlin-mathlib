package dev.psygamer.mathlib.vector

import kotlin.math.*

open class Vector3I(val x: Int, val y: Int, val z: Int) {

	companion object {

		@JvmStatic
		val ZERO = Vector3I(0, 0, 0)

		@JvmStatic
		val ONE = Vector3I(1, 1, 1)
	}

	operator fun plus(other: Vector3I): Vector3I {
		return Vector3I(this.x + other.x, this.y + other.y, this.z + other.z)
	}

	operator fun minus(other: Vector3I): Vector3I {
		return Vector3I(this.x - other.x, this.y - other.y, this.z - other.z)
	}

	operator fun times(other: Vector3I): Vector3I {
		return Vector3I(this.x * other.x, this.y * other.y, this.z * other.z)
	}

	operator fun times(scalar: Int): Vector3I {
		return Vector3I((this.x * scalar), (this.y * scalar), (this.z * scalar))
	}

	operator fun times(scalar: Float): Vector3F {
		return Vector3F((this.x * scalar), (this.y * scalar), (this.z * scalar))
	}

	operator fun div(other: Vector3I): Vector3I {
		if (other.x == 0 || other.y == 0 || other.z == 0)
			throw ArithmeticException("Division by zero!")
		return Vector3I(this.x / other.x, this.y / other.y, this.z / other.z)
	}

	operator fun div(scalar: Int): Vector3I {
		if (scalar == 0)
			throw ArithmeticException("Division by zero!")
		return Vector3I((this.x / scalar), (this.y / scalar), (this.z / scalar))
	}

	operator fun div(scalar: Float): Vector3F {
		if (scalar == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector3F((this.x / scalar), (this.y / scalar), (this.z / scalar))
	}

	infix fun cross(other: Vector3I): Vector3I {
		return Vector3I(
			this.y * other.z - this.z * other.y,
			this.z * other.x - this.x * other.z,
			this.x * other.y - this.y * other.x
		)
	}

	infix fun dot(other: Vector3I): Int {
		return (this.x * other.x + this.y * other.y + this.z * other.z)
	}

	infix fun distanceTo(other: Vector3I): Float {
		return (this - other).magnitude
	}

	infix fun distanceToSquared(other: Vector3I): Int {
		return (this - other).magnitudeSquared
	}

	fun angleBetween(other: Vector3I): Float {
		return acos((this dot other) / (this.magnitude * other.magnitude))
	}

	val magnitude: Float
		get() = sqrt((this.x * this.x + this.y * this.y + this.z * this.z).toFloat())

	val magnitudeSquared: Int
		get() = (this.x * this.x + this.y * this.y + this.z * this.z)

	val normalized: Vector3F
		get() = this / this.magnitude

	val angle: Float
		get() = atan2(this.x.toFloat(), this.y.toFloat())

	val inverted
		get() = Vector3I(-this.x, -this.y, -this.z)

	override fun toString(): String {
		return "Vector3i($x, $y, $z)"
	}

	override fun equals(other: Any?): Boolean {
		if (other == null)
			return false
		if (other !is Vector3I)
			return false
		if (this === other)
			return true

		return this.x == other.x && this.y == other.y && this.z == other.z
	}

	override fun hashCode(): Int {
		var result = x.hashCode()
		result = 31 * result + y.hashCode()
		result = 31 * result + z.hashCode()
		return result
	}
}
