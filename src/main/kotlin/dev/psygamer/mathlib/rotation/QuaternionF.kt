package dev.psygamer.mathlib.rotation

import kotlin.math.sqrt
import dev.psygamer.mathlib.almostEquals
import dev.psygamer.mathlib.vector.*

class QuaternionF {
	
	val w: Float
	val x: Float
	val y: Float
	val z: Float
	
	val r get() = this.w
	val i get() = this.x
	val j get() = this.y
	val k get() = this.z
	
	val real get() = this.r
	
	constructor(w: Float, x: Float, y: Float, z: Float) {
		this.w = w
		this.x = x
		this.y = y
		this.z = z
	}
	
	constructor(w: Float, v: Vector3I) {
		this.w = w
		this.x = v.x.toFloat()
		this.y = v.y.toFloat()
		this.z = v.z.toFloat()
	}
	
	constructor(w: Float, v: Vector3F) {
		this.w = w
		this.x = v.x
		this.y = v.y
		this.z = v.z
	}
	
	constructor(real: QuaternionF, pure: QuaternionF) {
		if (!real.isReal) throw IllegalArgumentException("Real quaternion wasn't real!")
		if (!pure.isPure) throw IllegalArgumentException("Pure quaternion wasn't pure!")
		this.w = real.w
		this.x = pure.x
		this.z = pure.y
		this.y = pure.z
	}
	
	operator fun plus(other: QuaternionF): QuaternionF {
		// See: https://www.3dgep.com/understanding-quaternions/#adding-and-subtracting-quaternions
		return QuaternionF(
			this.w + other.w,
			this.x + other.x,
			this.y + other.y,
			this.z + other.z,
		)
	}
	
	operator fun minus(other: QuaternionF): QuaternionF {
		// See: https://www.3dgep.com/understanding-quaternions/#adding-and-subtracting-quaternions
		return QuaternionF(
			this.w - other.w,
			this.x - other.x,
			this.y - other.y,
			this.z - other.z,
		)
	}
	
	operator fun times(scalar: Float): QuaternionF {
		// See: https://www.3dgep.com/understanding-quaternions/#multiplying-a-quaternion-by-a-scalar
		return QuaternionF(
			this.w * scalar,
			this.x * scalar,
			this.y * scalar,
			this.z * scalar,
		)
	}
	
	operator fun times(other: QuaternionF): QuaternionF {
		// See: https://www.3dgep.com/understanding-quaternions/#quaternion-products
		return QuaternionF(
			this.w * other.w - this.x * other.x - this.y * other.y - this.z * other.z,
			this.w * other.x + other.w * this.x + this.y * other.z - other.y * this.z,
			this.w * other.y + other.w * this.y + this.z * other.x - other.z * this.x,
			this.w * other.z + other.w * this.z + this.x * other.y - other.x * this.y,
		)
	}
	
	operator fun div(other: QuaternionF): QuaternionF {
		val nw = -this.x * -other.x - this.y * -other.y - this.z * -other.z + this.w * +other.w
		val nx = +this.x * +other.w + this.y * -other.z - this.z * -other.y + this.w * -other.x
		val ny = -this.x * -other.z + this.y * +other.w + this.z * -other.x + this.w * -other.y
		val nz = +this.x * -other.y - this.y * -other.x + this.z * +other.w + this.w * -other.z
		
		return QuaternionF(nw, nx, ny, nz)
	}
	
	val normalized: QuaternionF
		get() {
			val magnitudeSquared = w * w + x * x + y * y + z * z
			
			return if (magnitudeSquared > 1.0E-4f) {
				val magnitude = sqrt(magnitudeSquared)
				QuaternionF(
					w / magnitude,
					x / magnitude,
					y / magnitude,
					z / magnitude,
				)
			} else {
				// Set to 0 if the values are basically 0
				QuaternionF(0.0f, 0.0f, 0.0f, 0.0f)
			}
		}
	
	val isReal
		// See: https://www.3dgep.com/understanding-quaternions/#a-real-quaternion
		get() = this.x == 0.0f && this.y == 0.0f && this.z == 0.0f
	val isPure
		// See: https://www.3dgep.com/understanding-quaternions/#pure-quaternions
		get() = this.w == 0.0f
	
	val conjugate
		get() = QuaternionF(w, -x, -y, -z)
	val inverted
		get() = QuaternionF(w, -x, -y, -z)
	
	val norm: Float
		get() = sqrt(this.w * this.w + this.x * this.x + this.y * this.y + this.z * this.z)
	val normSquared: Float
		get() = this.w * this.w + this.x * this.x + this.y * this.y + this.z * this.z
	
	override fun toString(): String {
		return "Quaternion(w=$w, x=$x, y=$y, z=$z)"
	}
	
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false
		
		other as QuaternionF
		
		if (!w.almostEquals(other.w)) return false
		if (!x.almostEquals(other.x)) return false
		if (!y.almostEquals(other.y)) return false
		if (!z.almostEquals(other.z)) return false
		
		return true
	}
	
	override fun hashCode(): Int {
		var result = w.hashCode()
		result = 31 * result + x.hashCode()
		result = 31 * result + y.hashCode()
		result = 31 * result + z.hashCode()
		return result
	}
}