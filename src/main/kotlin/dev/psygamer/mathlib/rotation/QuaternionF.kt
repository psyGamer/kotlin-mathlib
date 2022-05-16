package dev.psygamer.mathlib.rotation

import kotlin.math.sqrt
import dev.psygamer.mathlib.almostEquals

class QuaternionF {
	
	val x: Float
	val y: Float
	val z: Float
	val w: Float
	
	val r get() = this.w
	val i get() = this.x
	val j get() = this.y
	val k get() = this.z
	
	val real get() = this.r
	
	constructor(x: Float, y: Float, z: Float, w: Float) {
		this.x = x
		this.y = y
		this.z = z
		this.w = w
	}
	
	operator fun plus(other: QuaternionF): QuaternionF {
		return QuaternionF(
			this.x + other.x,
			this.y + other.y,
			this.z + other.z,
			this.w + other.w,
		)
	}
	
	operator fun minus(other: QuaternionF): QuaternionF {
		return QuaternionF(
			this.x - other.x,
			this.y - other.y,
			this.z - other.z,
			this.w - other.w,
		)
	}
	
	/** See: [EuclideanSpace - Quaternion Multiplication](https://www.euclideanspace.com/maths/algebra/realNormedAlgebra/quaternions/code/index.htm#mul) */
	operator fun times(other: QuaternionF): QuaternionF {
		val nx = +this.x * other.w + this.y * other.z - this.z * other.y + this.w * other.x
		val ny = -this.x * other.z + this.y * other.w + this.z * other.x + this.w * other.y
		val nz = +this.x * other.y - this.y * other.x + this.z * other.w + this.w * other.z
		val nw = -this.x * other.x - this.y * other.y - this.z * other.z + this.w * other.w
		
		return QuaternionF(nx, ny, nz, nw)
	}
	
	operator fun div(other: QuaternionF): QuaternionF {
		val nx = +this.x * +other.w + this.y * -other.z - this.z * -other.y + this.w * -other.x
		val ny = -this.x * -other.z + this.y * +other.w + this.z * -other.x + this.w * -other.y
		val nz = +this.x * -other.y - this.y * -other.x + this.z * +other.w + this.w * -other.z
		val nw = -this.x * -other.x - this.y * -other.y - this.z * -other.z + this.w * +other.w
		
		return QuaternionF(nx, ny, nz, nw)
	}
	
	val normalized: QuaternionF
		get() {
			val magnitudeSquared = x * x + y * y + z * z + w * w
			
			return if (magnitudeSquared > 1.0E-4f) {
				val magnitude = sqrt(magnitudeSquared)
				QuaternionF(
					x / magnitude,
					y / magnitude,
					z / magnitude,
					w / magnitude,
				)
			} else {
				// Set to 0 if the values are basically 0
				QuaternionF(0.0f, 0.0f, 0.0f, 0.0f)
			}
		}
	
	val conjugate
		get() = QuaternionF(-x, -y, -z, w)
	val inverted
		get() = QuaternionF(-x, -y, -z, w)
	
	override fun toString(): String {
		return "Quaternion(x=$x, y=$y, z=$z, w=$w)"
	}
	
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false
		
		other as QuaternionF
		
		if (!x.almostEquals(other.x)) return false
		if (!y.almostEquals(other.y)) return false
		if (!z.almostEquals(other.z)) return false
		if (!w.almostEquals(other.w)) return false
		
		return true
	}
	
	override fun hashCode(): Int {
		var result = x.hashCode()
		result = 31 * result + y.hashCode()
		result = 31 * result + z.hashCode()
		result = 31 * result + w.hashCode()
		return result
	}
}