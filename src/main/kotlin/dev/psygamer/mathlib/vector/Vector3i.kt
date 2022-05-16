package dev.psygamer.mathlib.vector

import kotlin.math.*

open class Vector3i(val x: Int, val y: Int, val z: Int) {
	
	companion object {
		
		@JvmStatic
		val ZERO = Vector3i(0, 0, 0)
		
		@JvmStatic
		val ONE = Vector3i(1, 1, 1)
	}
	
	operator fun plus(other: Vector3i): Vector3i {
		return Vector3i(this.x + other.x, this.y + other.y, this.z + other.z)
	}
	
	operator fun minus(other: Vector3i): Vector3i {
		return Vector3i(this.x - other.x, this.y - other.y, this.z - other.z)
	}
	
	operator fun times(other: Vector3i): Vector3i {
		return Vector3i(this.x * other.x, this.y * other.y, this.z * other.z)
	}
	
	operator fun times(scalar: Int): Vector3i {
		return Vector3i((this.x * scalar), (this.y * scalar), (this.z * scalar))
	}
	
	operator fun times(scalar: Float): Vector3f {
		return Vector3f((this.x * scalar), (this.y * scalar), (this.z * scalar))
	}
	
	operator fun div(other: Vector3i): Vector3i {
		if (other.x == 0 || other.y == 0 || other.z == 0)
			throw ArithmeticException("Division by zero!")
		return Vector3i(this.x / other.x, this.y / other.y, this.z / other.z)
	}
	
	operator fun div(scalar: Int): Vector3i {
		if (scalar == 0)
			throw ArithmeticException("Division by zero!")
		return Vector3i((this.x / scalar), (this.y / scalar), (this.z / scalar))
	}
	
	operator fun div(scalar: Float): Vector3f {
		if (scalar == 0.0f)
			throw ArithmeticException("Division by zero!")
		return Vector3f((this.x / scalar), (this.y / scalar), (this.z / scalar))
	}
	
	infix fun cross(other: Vector3i): Vector3i {
		return Vector3i(
			this.y * other.z - this.z * other.y,
			this.z * other.x - this.x * other.z,
			this.x * other.y - this.y * other.x
		)
	}
	
	infix fun dot(other: Vector3i): Int {
		return (this.x * other.x + this.y * other.y + this.z * other.z)
	}
	
	infix fun distanceTo(other: Vector3i): Float {
		return (this - other).magnitude
	}
	
	infix fun distanceToSquared(other: Vector3i): Int {
		return (this - other).magnitudeSquared
	}
	
	fun angleBetween(other: Vector3i): Float {
		return acos((this dot other) / (this.magnitude * other.magnitude))
	}
	
	val magnitude: Float
		get() = sqrt((this.x * this.x + this.y * this.y + this.z * this.z).toFloat())
	
	val magnitudeSquared: Int
		get() = (this.x * this.x + this.y * this.y + this.z * this.z)
	
	val normalized: Vector3f
		get() = this / this.magnitude
	
	val angle: Float
		get() = atan2(this.x.toFloat(), this.y.toFloat())
	
	val inverted
		get() = Vector3i(-this.x, -this.y, -this.z)
	
	override fun toString(): String {
		return "Vector3i($x, $y, $z)"
	}
	
	override fun equals(other: Any?): Boolean {
		if (other == null)
			return false
		if (other !is Vector3i)
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
