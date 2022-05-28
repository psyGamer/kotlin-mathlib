package dev.psygamer.mathlib.vector

import kotlin.math.*
import dev.psygamer.mathlib.almostEquals
import dev.psygamer.mathlib.quaternion.QuaternionF

open class Vector3F(val x: Float, val y: Float, val z: Float) {

	companion object {

		@JvmStatic
		val ZERO = Vector3F(0.0f, 0.0f, 0.0f)

		@JvmStatic
		val ONE = Vector3F(1.0f, 1.0f, 1.0f)
	}

	operator fun plus(other: Vector3I): Vector3F {
		return Vector3F(this.x + other.x, this.y + other.y, this.z + other.z)
	}

	operator fun plus(other: Vector3F): Vector3F {
		return Vector3F(this.x + other.x, this.y + other.y, this.z + other.z)
	}

	operator fun minus(other: Vector3I): Vector3F {
		return Vector3F(this.x - other.x, this.y - other.y, this.z - other.z)
	}

	operator fun minus(other: Vector3F): Vector3F {
		return Vector3F(this.x - other.x, this.y - other.y, this.z - other.z)
	}

	operator fun times(other: Vector3I): Vector3F {
		return Vector3F(this.x * other.x, this.y * other.y, this.z * other.z)
	}

	operator fun times(other: Vector3F): Vector3F {
		return Vector3F(this.x * other.x, this.y * other.y, this.z * other.z)
	}

	operator fun times(scalar: Int): Vector3F {
		return Vector3F((this.x * scalar), (this.y * scalar), (this.z * scalar))
	}

	operator fun times(scalar: Float): Vector3F {
		return Vector3F((this.x * scalar), (this.y * scalar), (this.z * scalar))
	}

	operator fun div(other: Vector3I): Vector3F {
		if (other.x == 0 || other.y == 0 || other.z == 0)
			throw ArithmeticException("Division by zero!")
		return Vector3F(this.x / other.x, this.y / other.y, this.z / other.z)
	}

	operator fun div(other: Vector3F): Vector3F {
		if (other.x == 0.0f || other.y == 0.0f || other.z == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector3F(this.x / other.x, this.y / other.y, this.z / other.z)
	}

	operator fun div(scalar: Int): Vector3F {
		if (scalar == 0)
			throw ArithmeticException("Division by zero!")
		return Vector3F((this.x / scalar), (this.y / scalar), (this.z / scalar))
	}

	operator fun div(scalar: Float): Vector3F {
		if (scalar == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector3F((this.x / scalar), (this.y / scalar), (this.z / scalar))
	}

	infix fun cross(other: Vector3I): Vector3F {
		return Vector3F(
			this.y * other.z - this.z * other.y,
			this.z * other.x - this.x * other.z,
			this.x * other.y - this.y * other.x
		)
	}

	infix fun cross(other: Vector3F): Vector3F {
		return Vector3F(
			this.y * other.z - this.z * other.y,
			this.z * other.x - this.x * other.z,
			this.x * other.y - this.y * other.x
		)
	}

	infix fun dot(other: Vector3I): Float {
		return (this.x * other.x + this.y * other.y + this.z * other.z)
	}

	infix fun dot(other: Vector3F): Float {
		return (this.x * other.x + this.y * other.y + this.z * other.z)
	}

	fun rotate(q: QuaternionF): Vector3F {
		val v = q * QuaternionF.fromVector(0.0f, this) * q.inverse
		return Vector3F(v.x, v.y, v.z)
	}

	infix fun distanceTo(other: Vector3I): Float {
		return (this - other).magnitude
	}

	infix fun distanceTo(other: Vector3F): Float {
		return (this - other).magnitude
	}

	infix fun distanceToSquared(other: Vector3I): Float {
		return (this - other).magnitudeSquared
	}

	infix fun distanceToSquared(other: Vector3F): Float {
		return (this - other).magnitudeSquared
	}

	fun angleBetween(other: Vector3F): Float {
		return acos(this dot other / (this.magnitude * other.magnitude))
	}

	val magnitude: Float
		get() = sqrt(this.x * this.x + this.y * this.y + this.z * this.z)

	val magnitudeSquared: Float
		get() = (this.x * this.x + this.y * this.y + this.z * this.z)

	val normalized: Vector3F
		get() = this / this.magnitude

	val angle: Float
		get() = atan2(this.x, this.y)

	val inverted
		get() = Vector3F(-this.x, -this.y, -this.z)

	override fun toString(): String {
		return "Vector3f($x, $y, $z)"
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as Vector3F

		if (!x.almostEquals(other.x)) return false
		if (!y.almostEquals(other.y)) return false
		if (!z.almostEquals(other.z)) return false

		return true
	}

	override fun hashCode(): Int {
		var result = x.hashCode()
		result = 31 * result + y.hashCode()
		result = 31 * result + z.hashCode()
		return result
	}
}
