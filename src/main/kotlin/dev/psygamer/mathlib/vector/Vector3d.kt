package dev.psygamer.mathlib.vector

import kotlin.math.*

open class Vector3d(val x: Double, val y: Double, val z: Double) {
	
	companion object {
		
		@JvmStatic
		val ZERO = Vector3d(0.0, 0.0, 0.0)
		
		@JvmStatic
		val ONE = Vector3d(1.0, 1.0, 1.0)
	}
	
	operator fun plus(other: Vector3i): Vector3d {
		return Vector3d(this.x + other.x, this.y + other.y, this.z + other.z)
	}
	
	operator fun plus(other: Vector3f): Vector3d {
		return Vector3d(this.x + other.x, this.y + other.y, this.z + other.z)
	}
	
	operator fun plus(other: Vector3d): Vector3d {
		return Vector3d(this.x + other.x, this.y + other.y, this.z + other.z)
	}
	
	operator fun minus(other: Vector3i): Vector3d {
		return Vector3d(this.x - other.x, this.y - other.y, this.z - other.z)
	}
	
	operator fun minus(other: Vector3f): Vector3d {
		return Vector3d(this.x - other.x, this.y - other.y, this.z - other.z)
	}
	
	operator fun minus(other: Vector3d): Vector3d {
		return Vector3d(this.x - other.x, this.y - other.y, this.z - other.z)
	}
	
	operator fun times(other: Vector3i): Vector3d {
		return Vector3d(this.x * other.x, this.y * other.y, this.z * other.z)
	}
	
	operator fun times(other: Vector3f): Vector3d {
		return Vector3d(this.x * other.x, this.y * other.y, this.z * other.z)
	}
	
	operator fun times(other: Vector3d): Vector3d {
		return Vector3d(this.x * other.x, this.y * other.y, this.z * other.z)
	}
	
	operator fun times(scalar: Int): Vector3d {
		return Vector3d((this.x * scalar), (this.y * scalar), (this.z * scalar))
	}
	
	operator fun times(scalar: Float): Vector3d {
		return Vector3d((this.x * scalar), (this.y * scalar), (this.z * scalar))
	}
	
	operator fun times(scalar: Double): Vector3d {
		return Vector3d((this.x * scalar), (this.y * scalar), (this.z * scalar))
	}
	
	operator fun div(other: Vector3i): Vector3d {
		if (other.x == 0 || other.y == 0 || other.z == 0)
			throw ArithmeticException("Division by zero!")
		return Vector3d(this.x / other.x, this.y / other.y, this.z / other.z)
	}
	
	operator fun div(other: Vector3f): Vector3d {
		if (other.x == 0.0f || other.y == 0.0f || other.z == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector3d(this.x / other.x, this.y / other.y, this.z / other.z)
	}
	
	operator fun div(other: Vector3d): Vector3d {
		if (other.x == 0.0 || other.y == 0.0 || other.z == 0.0)
			throw ArithmeticException("Division by zero!")
		return Vector3d(this.x / other.x, this.y / other.y, this.z / other.z)
	}
	
	operator fun div(scalar: Int): Vector3d {
		if (scalar == 0)
			throw ArithmeticException("Division by zero!")
		return Vector3d((this.x / scalar), (this.y / scalar), (this.z / scalar))
	}
	
	operator fun div(scalar: Float): Vector3d {
		if (scalar == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector3d((this.x / scalar), (this.y / scalar), (this.z / scalar))
	}
	
	operator fun div(scalar: Double): Vector3d {
		if (scalar == 0.0)
			throw ArithmeticException("Division by zero!")
		return Vector3d((this.x / scalar), (this.y / scalar), (this.z / scalar))
	}
	
	infix fun cross(other: Vector3i): Vector3d {
		return Vector3d(
			this.y * other.z - this.z * other.y,
			this.z * other.x - this.x * other.z,
			this.x * other.y - this.y * other.x
		)
	}
	
	infix fun cross(other: Vector3f): Vector3d {
		return Vector3d(
			this.y * other.z - this.z * other.y,
			this.z * other.x - this.x * other.z,
			this.x * other.y - this.y * other.x
		)
	}
	
	infix fun cross(other: Vector3d): Vector3d {
		return Vector3d(
			this.y * other.z - this.z * other.y,
			this.z * other.x - this.x * other.z,
			this.x * other.y - this.y * other.x
		)
	}
	
	infix fun dot(other: Vector3i): Double {
		return (this.x * other.x + this.y * other.y + this.z * other.z)
	}
	
	infix fun dot(other: Vector3f): Double {
		return (this.x * other.x + this.y * other.y + this.z * other.z)
	}
	
	infix fun dot(other: Vector3d): Double {
		return (this.x * other.x + this.y * other.y + this.z * other.z)
	}
	
	infix fun distanceTo(other: Vector3i): Double {
		return (this - other).magnitude
	}
	
	infix fun distanceTo(other: Vector3f): Double {
		return (this - other).magnitude
	}
	
	infix fun distanceTo(other: Vector3d): Double {
		return (this - other).magnitude
	}
	
	infix fun distanceToSquared(other: Vector3i): Double {
		return (this - other).magnitudeSquared
	}
	
	infix fun distanceToSquared(other: Vector3f): Double {
		return (this - other).magnitudeSquared
	}
	
	infix fun distanceToSquared(other: Vector3d): Double {
		return (this - other).magnitudeSquared
	}
	
	fun angleBetween(other: Vector3d): Double {
		return acos(this dot other / (this.magnitude * other.magnitude))
	}
	
	val magnitude: Double
		get() = sqrt(this.x * this.x + this.y * this.y + this.z * this.z)
	
	val magnitudeSquared: Double
		get() = (this.x * this.x + this.y * this.y + this.z * this.z)
	
	val normalized: Vector3d
		get() = this / this.magnitude
	
	val angle: Double
		get() = atan2(this.x, this.y)
	
	val inverted
		get() = Vector3d(-this.x, -this.y, -this.z)
	
	override fun toString(): String {
		return "Vector3i($x, $y, $z)"
	}
	
	override fun equals(other: Any?): Boolean {
		if (other == null)
			return false
		if (other !is Vector3d)
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
