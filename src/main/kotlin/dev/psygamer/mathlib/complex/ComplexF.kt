package dev.psygamer.mathlib.complex

import kotlin.math.*

class ComplexF(val r: Float, val i: Float) {
	
	operator fun plus(other: ComplexF): ComplexF {
		return ComplexF(this.r + other.r, this.i + other.i)
	}
	
	operator fun minus(other: ComplexF): ComplexF {
		return ComplexF(this.r - other.r, this.i - other.i)
	}
	
	operator fun times(scalar: Int): ComplexF {
		return ComplexF(this.r * scalar, this.i * scalar)
	}
	
	operator fun times(scalar: Float): ComplexF {
		return ComplexF(this.r * scalar, this.i * scalar)
	}
	
	operator fun times(other: ComplexF): ComplexF {
		return ComplexF(
			this.r * other.r - this.i * other.i,
			this.r * other.i + this.i * other.r
		)
	}
	
	operator fun div(other: ComplexF): ComplexF {
		return ComplexF(
			(this.r * other.r + this.i * other.i) / (other.r * other.r + other.i * other.i),
			(this.i * other.r - this.r * other.i) / (other.r * other.r + other.i * other.i)
		)
	}
	
	val conjugate
		get() = ComplexF(this.r, -this.i)
	
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
		
		other as ComplexF
		
		if (r != other.r) return false
		if (i != other.i) return false
		
		return true
	}
	
	override fun hashCode(): Int {
		var result = r.hashCode()
		result = 31 * result + i.hashCode()
		return result
	}
}