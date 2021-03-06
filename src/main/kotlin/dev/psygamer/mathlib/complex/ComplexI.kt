package dev.psygamer.mathlib.complex

import kotlin.math.*

class ComplexI(val r: Int, val i: Int) {

	operator fun plus(other: ComplexI): ComplexI {
		return ComplexI(this.r + other.r, this.i + other.i)
	}

	operator fun minus(other: ComplexI): ComplexI {
		return ComplexI(this.r - other.r, this.i - other.i)
	}

	operator fun times(scalar: Int): ComplexI {
		return ComplexI(this.r * scalar, this.i * scalar)
	}

	operator fun times(other: ComplexI): ComplexI {
		return ComplexI(
			this.r * other.r - this.i * other.i,
			this.r * other.i + this.i * other.r
		)
	}

	operator fun div(other: ComplexI): ComplexF {
		return ComplexF(
			(this.r * other.r + this.i * other.i).toFloat() / (other.r * other.r + other.i * other.i),
			(this.i * other.r - this.r * other.i).toFloat() / (other.r * other.r + other.i * other.i)
		)
	}

	val rotatedLeft90Degrees: ComplexI
		// See: https://www.3dgep.com/understanding-quaternions/#rotors
		get() = ComplexI(
			/*			 cos(90°) = 0		 sin(90°) = 1
				this.r * cos(90°) - this.i * sin(90°),
				this.r * sin(90°) + this.i * cos(90°)	*/
			-this.i, this.r
		)
	val rotatedRight90Degrees: ComplexI
		// See: https://www.3dgep.com/understanding-quaternions/#rotors
		get() = ComplexI(
			/*			 cos(-90°) = -0		  sin(-90°) = -1
				this.r * cos(-90°) - this.i * sin(-90°),
				this.r * sin(-90°) + this.i * cos(-90°)	*/
			this.i, -this.r
		)
	val rotated180Degrees: ComplexI
		// See: https://www.3dgep.com/understanding-quaternions/#rotors
		get() = ComplexI(
			/*			 cos(180°) = -1		  sin(180°) = -0
				this.r * cos(180°) - this.i * sin(180°),
				this.r * sin(180°) + this.i * cos(180°)	*/
			-this.r, -this.i
		)

	val conjugate
		get() = ComplexI(this.r, -this.i)

	val angle
		get() = atan2(this.r.toFloat(), this.i.toFloat())

	val abs
		get() = sqrt((this.r * this.r + this.i * this.i).toFloat())

	override fun toString(): String {
		return "(${r} + ${i}i)"
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as ComplexI

		if (r != other.r) return false
		if (i != other.i) return false

		return true
	}

	override fun hashCode(): Int {
		var result = r
		result = 31 * result + i
		return result
	}
}