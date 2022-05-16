package dev.psygamer.mathlib.vector

import kotlin.math.*

open class Vector3D(val x: Double, val y: Double, val z: Double) {
	
	companion object {
		
		@JvmStatic
		val ZERO = Vector3D(0.0, 0.0, 0.0)
		
		@JvmStatic
		val ONE = Vector3D(1.0, 1.0, 1.0)
	}
	
	operator fun plus(other: Vector3I): Vector3D {
		return Vector3D(this.x + other.x, this.y + other.y, this.z + other.z)
	}
	
	operator fun plus(other: Vector3F): Vector3D {
		return Vector3D(this.x + other.x, this.y + other.y, this.z + other.z)
	}
	
	operator fun plus(other: Vector3D): Vector3D {
		return Vector3D(this.x + other.x, this.y + other.y, this.z + other.z)
	}
	
	operator fun minus(other: Vector3I): Vector3D {
		return Vector3D(this.x - other.x, this.y - other.y, this.z - other.z)
	}
	
	operator fun minus(other: Vector3F): Vector3D {
		return Vector3D(this.x - other.x, this.y - other.y, this.z - other.z)
	}
	
	operator fun minus(other: Vector3D): Vector3D {
		return Vector3D(this.x - other.x, this.y - other.y, this.z - other.z)
	}
	
	operator fun times(other: Vector3I): Vector3D {
		return Vector3D(this.x * other.x, this.y * other.y, this.z * other.z)
	}
	
	operator fun times(other: Vector3F): Vector3D {
		return Vector3D(this.x * other.x, this.y * other.y, this.z * other.z)
	}
	
	operator fun times(other: Vector3D): Vector3D {
		return Vector3D(this.x * other.x, this.y * other.y, this.z * other.z)
	}
	
	operator fun times(scalar: Int): Vector3D {
		return Vector3D((this.x * scalar), (this.y * scalar), (this.z * scalar))
	}
	
	operator fun times(scalar: Float): Vector3D {
		return Vector3D((this.x * scalar), (this.y * scalar), (this.z * scalar))
	}
	
	operator fun times(scalar: Double): Vector3D {
		return Vector3D((this.x * scalar), (this.y * scalar), (this.z * scalar))
	}
	
	operator fun div(other: Vector3I): Vector3D {
		if (other.x == 0 || other.y == 0 || other.z == 0)
			throw ArithmeticException("Division by zero!")
		return Vector3D(this.x / other.x, this.y / other.y, this.z / other.z)
	}
	
	operator fun div(other: Vector3F): Vector3D {
		if (other.x == 0.0f || other.y == 0.0f || other.z == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector3D(this.x / other.x, this.y / other.y, this.z / other.z)
	}
	
	operator fun div(other: Vector3D): Vector3D {
		if (other.x == 0.0 || other.y == 0.0 || other.z == 0.0)
			throw ArithmeticException("Division by zero!")
		return Vector3D(this.x / other.x, this.y / other.y, this.z / other.z)
	}
	
	operator fun div(scalar: Int): Vector3D {
		if (scalar == 0)
			throw ArithmeticException("Division by zero!")
		return Vector3D((this.x / scalar), (this.y / scalar), (this.z / scalar))
	}
	
	operator fun div(scalar: Float): Vector3D {
		if (scalar == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector3D((this.x / scalar), (this.y / scalar), (this.z / scalar))
	}
	
	operator fun div(scalar: Double): Vector3D {
		if (scalar == 0.0)
			throw ArithmeticException("Division by zero!")
		return Vector3D((this.x / scalar), (this.y / scalar), (this.z / scalar))
	}
	
	infix fun cross(other: Vector3I): Vector3D {
		return Vector3D(
			this.y * other.z - this.z * other.y,
			this.z * other.x - this.x * other.z,
			this.x * other.y - this.y * other.x
		)
	}
	
	infix fun cross(other: Vector3F): Vector3D {
		return Vector3D(
			this.y * other.z - this.z * other.y,
			this.z * other.x - this.x * other.z,
			this.x * other.y - this.y * other.x
		)
	}
	
	infix fun cross(other: Vector3D): Vector3D {
		return Vector3D(
			this.y * other.z - this.z * other.y,
			this.z * other.x - this.x * other.z,
			this.x * other.y - this.y * other.x
		)
	}
	
	infix fun dot(other: Vector3I): Double {
		return (this.x * other.x + this.y * other.y + this.z * other.z)
	}
	
	infix fun dot(other: Vector3F): Double {
		return (this.x * other.x + this.y * other.y + this.z * other.z)
	}
	
	infix fun dot(other: Vector3D): Double {
		return (this.x * other.x + this.y * other.y + this.z * other.z)
	}
	
	infix fun distanceTo(other: Vector3I): Double {
		return (this - other).magnitude
	}
	
	infix fun distanceTo(other: Vector3F): Double {
		return (this - other).magnitude
	}
	
	infix fun distanceTo(other: Vector3D): Double {
		return (this - other).magnitude
	}
	
	infix fun distanceToSquared(other: Vector3I): Double {
		return (this - other).magnitudeSquared
	}
	
	infix fun distanceToSquared(other: Vector3F): Double {
		return (this - other).magnitudeSquared
	}
	
	infix fun distanceToSquared(other: Vector3D): Double {
		return (this - other).magnitudeSquared
	}
	
	fun angleBetween(other: Vector3D): Double {
		return acos(this dot other / (this.magnitude * other.magnitude))
	}
	
	val magnitude: Double
		get() = sqrt(this.x * this.x + this.y * this.y + this.z * this.z)
	
	val magnitudeSquared: Double
		get() = (this.x * this.x + this.y * this.y + this.z * this.z)
	
	val normalized: Vector3D
		get() = this / this.magnitude
	
	val angle: Double
		get() = atan2(this.x, this.y)
	
	val inverted
		get() = Vector3D(-this.x, -this.y, -this.z)
	
	override fun toString(): String {
		return "Vector3i($x, $y, $z)"
	}
	
	override fun equals(other: Any?): Boolean {
		if (other == null)
			return false
		if (other !is Vector3D)
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
