package dev.psygamer.mathlib.quaternion

import kotlin.math.*
import dev.psygamer.mathlib.*
import dev.psygamer.mathlib.vector.*

class QuaternionF {

	companion object {

		fun fromVector(w: Int = 0, v: Vector3I): QuaternionF =
			QuaternionF(w.toFloat(), v.x.toFloat(), v.y.toFloat(), v.z.toFloat())

		fun fromVector(w: Float = 0.0f, v: Vector3F): QuaternionF =
			QuaternionF(w, v.x, v.y, v.z)
	}

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

	constructor(degrees: Float, v: Vector3I) {
		val rad = Math.toRadians(degrees / 2.0)
		val sin = sin(rad).toFloat()
		val vn = v.normalized
		this.w = cos(rad).toFloat()
		this.x = sin * vn.x
		this.y = sin * vn.y
		this.z = sin * vn.z
	}

	constructor(degrees: Float, v: Vector3F) {
		val rad = Math.toRadians(degrees / 2.0)
		val sin = sin(rad).toFloat()
		val vn = v.normalized
		this.w = cos(rad).toFloat()
		this.x = sin * vn.x
		this.y = sin * vn.y
		this.z = sin * vn.z
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

	operator fun div(scalar: Float): QuaternionF {
		return this * (1.0f / scalar)
	}

	operator fun div(other: QuaternionF): QuaternionF {
		val nw = -this.x * -other.x - this.y * -other.y - this.z * -other.z + this.w * +other.w
		val nx = +this.x * +other.w + this.y * -other.z - this.z * -other.y + this.w * -other.x
		val ny = -this.x * -other.z + this.y * +other.w + this.z * -other.x + this.w * -other.y
		val nz = +this.x * -other.y - this.y * -other.x + this.z * +other.w + this.w * -other.z

		return QuaternionF(nw, nx, ny, nz)
	}

	infix fun dot(other: QuaternionF): QuaternionF {
		return QuaternionF(
			this.w * other.w,
			this.x * other.x,
			this.y * other.y,
			this.z * other.z
		)
	}

	val normalized: QuaternionF
		// See: https://www.3dgep.com/understanding-quaternions/#quaternion-normalization
		get() {
			return if (this.normSquared > 1.0E-4f) {
				val norm = this.norm
				QuaternionF(
					w / norm,
					x / norm,
					y / norm,
					z / norm,
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
		// See: https://www.3dgep.com/understanding-quaternions/#quaternion-conjugate
		get() = QuaternionF(w, -x, -y, -z)
	val inverse
		// See: https://www.3dgep.com/understanding-quaternions/#quaternion-normalization
		get() = this.conjugate / this.normSquared

	val norm: Float
		// See: https://www.3dgep.com/understanding-quaternions/#quaternion-norm
		get() = sqrt(this.w.squared + this.x.squared + this.y.squared + this.z.squared)
	val normSquared: Float
		get() = this.w.squared + this.x.squared + this.y.squared + this.z.squared

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