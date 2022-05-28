package dev.psygamer.mathlib.complex

import kotlin.math.*
import dev.psygamer.mathlib.almostEquals

class ComplexD(val r: Double, val i: Double) {

	operator fun plus(other: ComplexD): ComplexD {
		return ComplexD(this.r + other.r, this.i + other.i)
	}

	operator fun minus(other: ComplexD): ComplexD {
		return ComplexD(this.r - other.r, this.i - other.i)
	}

	operator fun times(scalar: Int): ComplexD {
		return ComplexD(this.r * scalar, this.i * scalar)
	}

	operator fun times(scalar: Float): ComplexD {
		return ComplexD(this.r * scalar, this.i * scalar)
	}

	operator fun times(scalar: Double): ComplexD {
		return ComplexD(this.r * scalar, this.i * scalar)
	}

	operator fun times(other: ComplexD): ComplexD {
		return ComplexD(
			this.r * other.r - this.i * other.i,
			this.r * other.i + this.i * other.r
		)
	}

	operator fun div(other: ComplexD): ComplexD {
		return ComplexD(
			(this.r * other.r + this.i * other.i) / (other.r * other.r + other.i * other.i),
			(this.i * other.r - this.r * other.i) / (other.r * other.r + other.i * other.i)
		)
	}

	fun rotate(degrees: Double): ComplexD {
		// See: https://www.3dgep.com/understanding-quaternions/#rotors
		val rad = Math.toRadians(degrees)
		val cos = cos(rad)
		val sin = sin(rad)

		return ComplexD(
			this.r * cos - this.i * sin,
			this.r * sin + this.i * cos
		)
	}

	val conjugate
		get() = ComplexD(this.r, -this.i)

	val angle
		get() = atan2(this.r, this.i)

	val abs
		get() = sqrt((this.r * this.r + this.i * this.i))

	override fun toString(): String {
		return "(${r} + ${i}i)"
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as ComplexD

		if (!r.almostEquals(other.r)) return false
		if (!i.almostEquals(other.i)) return false

		return true
	}

	override fun hashCode(): Int {
		var result = r.hashCode()
		result = 31 * result + i.hashCode()
		return result
	}
}