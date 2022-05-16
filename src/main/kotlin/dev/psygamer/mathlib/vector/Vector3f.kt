package dev.psygamer.mathlib.vector

import kotlin.math.*

open class Vector3f(val x: Float, val y: Float, val z: Float) {
	
	companion object {
		
		@JvmStatic
		val ZERO = Vector3f(0.0f, 0.0f, 0.0f)
		
		@JvmStatic
		val ONE = Vector3f(1.0f, 1.0f, 1.0f)
	}
	
	operator fun plus(other: Vector3i): Vector3f {
		return Vector3f(this.x + other.x, this.y + other.y, this.z + other.z)
	}
	operator fun plus(other: Vector3f): Vector3f {
		return Vector3f(this.x + other.x, this.y + other.y, this.z + other.z)
	}
	
	operator fun minus(other: Vector3i): Vector3f {
		return Vector3f(this.x - other.x, this.y - other.y, this.z - other.z)
	}
	operator fun minus(other: Vector3f): Vector3f {
		return Vector3f(this.x - other.x, this.y - other.y, this.z - other.z)
	}
	
	operator fun times(other: Vector3i): Vector3f {
		return Vector3f(this.x * other.x, this.y * other.y, this.z * other.z)
	}
	operator fun times(other: Vector3f): Vector3f {
		return Vector3f(this.x * other.x, this.y * other.y, this.z * other.z)
	}
	
	operator fun times(scalar: Int): Vector3f {
		return Vector3f((this.x * scalar), (this.y * scalar), (this.z * scalar))
	}
	operator fun times(scalar: Float): Vector3f {
		return Vector3f((this.x * scalar), (this.y * scalar), (this.z * scalar))
	}
	
	operator fun div(other: Vector3i): Vector3f {
		if (other.x == 0 || other.y == 0 || other.z == 0)
			throw ArithmeticException("Division by zero!")
		return Vector3f(this.x / other.x, this.y / other.y, this.z / other.z)
	}
	operator fun div(other: Vector3f): Vector3f {
		if (other.x == 0.0f || other.y == 0.0f || other.z == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector3f(this.x / other.x, this.y / other.y, this.z / other.z)
	}
	
	operator fun div(scalar: Int): Vector3f {
		if (scalar == 0)
			throw ArithmeticException("Division by zero!")
		return Vector3f((this.x / scalar), (this.y / scalar), (this.z / scalar))
	}
	operator fun div(scalar: Float): Vector3f {
		if (scalar == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector3f((this.x / scalar), (this.y / scalar), (this.z / scalar))
	}
	
	infix fun cross(other: Vector3i): Vector3f {
		return Vector3f(
			this.y * other.z - this.z * other.y,
			this.z * other.x - this.x * other.z,
			this.x * other.y - this.y * other.x
		)
	}
	infix fun cross(other: Vector3f): Vector3f {
		return Vector3f(
			this.y * other.z - this.z * other.y,
			this.z * other.x - this.x * other.z,
			this.x * other.y - this.y * other.x
		)
	}
	
	infix fun dot(other: Vector3i): Float {
		return (this.x * other.x + this.y * other.y + this.z * other.z)
	}
	infix fun dot(other: Vector3f): Float {
		return (this.x * other.x + this.y * other.y + this.z * other.z)
	}
	
	infix fun distanceTo(other: Vector3i): Float {
		return (this - other).magnitude
	}
	infix fun distanceTo(other: Vector3f): Float {
		return (this - other).magnitude
	}
	
	infix fun distanceToSquared(other: Vector3i): Float {
		return (this - other).magnitudeSquared
	}
	infix fun distanceToSquared(other: Vector3f): Float {
		return (this - other).magnitudeSquared
	}
	
	fun angleBetween(other: Vector3f): Float {
		return acos(this dot other / (this.magnitude * other.magnitude))
	}
	
	val magnitude: Float
		get() = sqrt(this.x * this.x + this.y * this.y + this.z * this.z)
	
	val magnitudeSquared: Float
		get() = (this.x * this.x + this.y * this.y + this.z * this.z)
	
	val normalized: Vector3f
		get() = this / this.magnitude
	
	val angle: Float
		get() = atan2(this.x, this.y)
	
	val inverted
		get() = Vector3f(-this.x, -this.y, -this.z)
	
	override fun toString(): String {
		return "Vector3f($x, $y, $z)"
	}
	
	override fun equals(other: Any?): Boolean {
		if (other == null)
			return false
		if (other !is Vector3f)
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
