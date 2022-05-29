package dev.psygamer.mathlib.matrix

import dev.psygamer.mathlib.almostEquals

class Matrix4F(
	val m00: Float,
	val m01: Float,
	val m02: Float,
	val m03: Float,

	val m10: Float,
	val m11: Float,
	val m12: Float,
	val m13: Float,

	val m20: Float,
	val m21: Float,
	val m22: Float,
	val m23: Float,

	val m30: Float,
	val m31: Float,
	val m32: Float,
	val m33: Float,
) {

	companion object {

		val IDENTITY: Matrix4F = Matrix4F()
	}

	constructor() : this(
		1.0f, 0.0f, 0.0f, 0.0f,
		0.0f, 1.0f, 0.0f, 0.0f,
		0.0f, 0.0f, 1.0f, 0.0f,
		0.0f, 0.0f, 0.0f, 1.0f
	)

	constructor(other: Matrix4F) : this(
		other.m00, other.m01, other.m02, other.m03,
		other.m10, other.m11, other.m12, other.m13,
		other.m20, other.m21, other.m22, other.m23,
		other.m30, other.m31, other.m32, other.m33,
	)

//	/** See: [EuclideanSpace - Conversion Quaternion to Matrix](https://www.euclideanspace.com/maths/geometry/rotations/conversions/quaternionToMatrix/index.htm) */
//	constructor(quaternion: QuaternionF) {
//		val xx = quaternion.x * quaternion.x
//		val xy = quaternion.x * quaternion.y
//		val xz = quaternion.x * quaternion.z
//		val xw = quaternion.x * quaternion.w
//
//		val yy = quaternion.y * quaternion.y
//		val yz = quaternion.y * quaternion.z
//		val yw = quaternion.y * quaternion.w
//
//		val zz = quaternion.z * quaternion.z
//		val zw = quaternion.z * quaternion.w
//
//		this.m00 = 1.0f - 2.0f * (yy + zz)
//		this.m01 = 2.0f * (xy - zw)
//		this.m02 = 2.0f * (xz + xw)
//		this.m03 = 0.0f
//
//		this.m10 = 2.0f * (xy + zw)
//		this.m11 = 1.0f - 2.0f * (xx + zz)
//		this.m12 = 2.0f * (yz - xw)
//		this.m13 = 0.0f
//
//		this.m20 = 2.0f * (xz - yw)
//		this.m21 = 2.0f * (yz + xw)
//		this.m22 = 1.0f - 2.0f * (xx + yy)
//		this.m23 = 0.0f
//
//		this.m30 = 0.0f
//		this.m31 = 0.0f
//		this.m32 = 0.0f
//		this.m33 = 1.0f
//	}

//	operator fun plus(other: MatrixF): Matrix4F {
//		if (other.rows != 4 || other.columns != 4)
//			throw IllegalArgumentException("Matrices must be same size! Expected: 4x4, found: ${other.rows}x${other.columns}")
//		return Matrix4F(
//			m00 + other.m[0][0], m01 + other.m[0][1], m02 + other.m[0][2], m03 + other.m[0][3],
//			m10 + other.m[1][0], m11 + other.m[1][1], m12 + other.m[1][2], m13 + other.m[1][3],
//			m20 + other.m[2][0], m21 + other.m[2][1], m22 + other.m[2][2], m23 + other.m[2][3],
//			m30 + other.m[3][0], m31 + other.m[3][1], m32 + other.m[3][2], m33 + other.m[3][3],
//		)
//	}

	operator fun plus(other: Matrix4F): Matrix4F {
		// See: https://www.mathsisfun.com/algebra/matrix-introduction.html Section: "Adding"
		return Matrix4F(
			m00 + other.m00, m01 + other.m01, m02 + other.m02, m03 + other.m03,
			m10 + other.m10, m11 + other.m11, m12 + other.m12, m13 + other.m13,
			m20 + other.m20, m21 + other.m21, m22 + other.m22, m23 + other.m23,
			m30 + other.m30, m31 + other.m31, m32 + other.m32, m33 + other.m33,
		)
	}

//	operator fun minus(other: MatrixF): Matrix4F {
//		if (other.rows != 4 || other.columns != 4)
//			throw IllegalArgumentException("Matrices must be same size! Expected: 4x4, found: ${other.rows}x${other.columns}")
//		return Matrix4F(
//			m00 - other.m[0][0], m01 - other.m[0][1], m02 - other.m[0][2], m03 - other.m[0][3],
//			m10 - other.m[1][0], m11 - other.m[1][1], m12 - other.m[1][2], m13 - other.m[1][3],
//			m20 - other.m[2][0], m21 - other.m[2][1], m22 - other.m[2][2], m23 - other.m[2][3],
//			m30 - other.m[3][0], m31 - other.m[3][1], m32 - other.m[3][2], m33 - other.m[3][3],
//		)
//	}

	operator fun minus(other: Matrix4F): Matrix4F {
		// See: https://www.mathsisfun.com/algebra/matrix-introduction.html Section: "Subtracting"
		return Matrix4F(
			m00 - other.m00, m01 - other.m01, m02 - other.m02, m03 - other.m03,
			m10 - other.m10, m11 - other.m11, m12 - other.m12, m13 - other.m13,
			m20 - other.m20, m21 - other.m21, m22 - other.m22, m23 - other.m23,
			m30 - other.m30, m31 - other.m31, m32 - other.m32, m33 - other.m33,
		)
	}

	operator fun times(scalar: Float): Matrix4F {
		// See: https://www.mathsisfun.com/algebra/matrix-introduction.html Section: "Multiply by a Constant"
		return Matrix4F(
			m00 * scalar, m01 * scalar, m02 * scalar, m03 * scalar,
			m10 * scalar, m11 * scalar, m12 * scalar, m13 * scalar,
			m20 * scalar, m21 * scalar, m22 * scalar, m23 * scalar,
			m30 * scalar, m31 * scalar, m32 * scalar, m33 * scalar,
		)
	}

//	operator fun times(other: MatrixF): MatrixF {
//		if (other.rows != 4)
//			throw IllegalArgumentException("Unexpected matrix row count! Expected: 4, found: ${other.rows}")
//		return MatrixF(4, other.columns) { row, column ->
//			when (row) {
//				0 -> m00 * other.m[0][column] + m01 * other.m[1][column] + m02 * other.m[2][column] + m03 * other.m[3][column]
//				1 -> m10 * other.m[0][column] + m11 * other.m[1][column] + m12 * other.m[2][column] + m13 * other.m[3][column]
//				2 -> m20 * other.m[0][column] + m21 * other.m[1][column] + m22 * other.m[2][column] + m23 * other.m[3][column]
//				3 -> m30 * other.m[0][column] + m31 * other.m[1][column] + m32 * other.m[2][column] + m33 * other.m[3][column]
//				else -> throw RuntimeException("Matrix multiplication exceeded expected row count!") // Should never happen
//			}
//		}
//	}

	operator fun times(other: Matrix4F): Matrix4F {
		// See: https://www.mathsisfun.com/algebra/matrix-introduction.html Section: "Multiplying by Another Matrix"
		return Matrix4F(
			m00 * other.m00 + m01 * other.m10 + m02 * other.m20 + m03 * other.m30,
			m00 * other.m01 + m01 * other.m11 + m02 * other.m21 + m03 * other.m31,
			m00 * other.m02 + m01 * other.m12 + m02 * other.m22 + m03 * other.m32,
			m00 * other.m03 + m01 * other.m13 + m02 * other.m23 + m03 * other.m33,

			m10 * other.m00 + m11 * other.m10 + m12 * other.m20 + m13 * other.m30,
			m10 * other.m01 + m11 * other.m11 + m12 * other.m21 + m13 * other.m31,
			m10 * other.m02 + m11 * other.m12 + m12 * other.m22 + m13 * other.m32,
			m10 * other.m03 + m11 * other.m13 + m12 * other.m23 + m13 * other.m33,

			m20 * other.m00 + m21 * other.m10 + m22 * other.m20 + m23 * other.m30,
			m20 * other.m01 + m21 * other.m11 + m22 * other.m21 + m23 * other.m31,
			m20 * other.m02 + m21 * other.m12 + m22 * other.m22 + m23 * other.m32,
			m20 * other.m03 + m21 * other.m13 + m22 * other.m23 + m23 * other.m33,

			m30 * other.m00 + m31 * other.m10 + m32 * other.m20 + m33 * other.m30,
			m30 * other.m01 + m31 * other.m11 + m32 * other.m21 + m33 * other.m31,
			m30 * other.m02 + m31 * other.m12 + m32 * other.m22 + m33 * other.m32,
			m30 * other.m03 + m31 * other.m13 + m32 * other.m23 + m33 * other.m33,
		)
	}

//	operator fun div(other: MatrixF): MatrixF {
//		if (other.rows != other.columns)
//			throw IllegalArgumentException("Matrix must be square! Found: ${other.rows}x${other.columns}")
//		val scalar = 1.0f / other.determinant
//		return this * Matrix4F(
//			other.m00 * scalar, other.m01 * scalar, other.m02 * scalar, -other.m03 * scalar,
//			other.m10 * scalar, other.m11 * scalar, -other.m12 * scalar, other.m13 * scalar,
//			other.m20 * scalar, -other.m21 * scalar, other.m22 * scalar, other.m23 * scalar,
//			-other.m30 * scalar, other.m31 * scalar, other.m32 * scalar, other.m33 * scalar,
//		)
//	}

	operator fun div(other: Matrix4F): Matrix4F {
		// See: https://www.mathsisfun.com/algebra/matrix-introduction.html Section: "Dividing"
		return this * inverse
	}

	val determinant: Float
		// See: https://www.mathsisfun.com/algebra/matrix-determinant.html
		get() = run {
			+m00 * (m11 * (m22 * m33 - m23 * m32) - m12 * (m21 * m33 - m23 * m31) + m13 * (m21 * m32 - m22 * m31))
			-m01 * (m10 * (m22 * m33 - m23 * m32) - m12 * (m20 * m33 - m23 * m30) + m13 * (m20 * m32 - m22 * m30))
			+m02 * (m10 * (m21 * m33 - m23 * m31) - m11 * (m20 * m33 - m23 * m30) + m13 * (m20 * m31 - m21 * m30))
			-m03 * (m10 * (m21 * m32 - m22 * m31) - m11 * (m20 * m32 - m22 * m30) + m12 * (m20 * m31 - m21 * m30))
		}

	val inverse: Matrix4F
		// See: https://www.mathsisfun.com/algebra/matrix-inverse.html
		get() = run {
			val invDet = 1.0f / determinant
			Matrix4F(
				m00 * invDet, m01 * invDet, m02 * invDet, -m03 * invDet,
				m10 * invDet, m11 * invDet, -m12 * invDet, m13 * invDet,
				m20 * invDet, -m21 * invDet, m22 * invDet, m23 * invDet,
				-m30 * invDet, m31 * invDet, m32 * invDet, m33 * invDet,
			)
		}

	val transpose: Matrix4F
		get() = Matrix4F(
			m00, m10, m20, m30,
			m01, m11, m21, m31,
			m02, m12, m22, m32,
			m03, m13, m23, m33,
		)

	override fun toString(): String =
		"""Matrix4F [[$m00, $m01, $m02, $m03],
			   		 [$m10, $m11, $m12, $m13],
			    	 [$m20, $m21, $m22, $m23],
					 [$m30, $m31, $m32, $m33]]
		"""

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as Matrix4F

		if (!m00.almostEquals(other.m00)) return false
		if (!m01.almostEquals(other.m01)) return false
		if (!m02.almostEquals(other.m02)) return false
		if (!m03.almostEquals(other.m03)) return false
		if (!m10.almostEquals(other.m10)) return false
		if (!m11.almostEquals(other.m11)) return false
		if (!m12.almostEquals(other.m12)) return false
		if (!m13.almostEquals(other.m13)) return false
		if (!m20.almostEquals(other.m20)) return false
		if (!m21.almostEquals(other.m21)) return false
		if (!m22.almostEquals(other.m22)) return false
		if (!m23.almostEquals(other.m23)) return false
		if (!m30.almostEquals(other.m30)) return false
		if (!m31.almostEquals(other.m31)) return false
		if (!m32.almostEquals(other.m32)) return false
		if (!m33.almostEquals(other.m33)) return false

		return true
	}

	override fun hashCode(): Int {
		var result = m00.hashCode()
		result = 31 * result + m01.hashCode()
		result = 31 * result + m02.hashCode()
		result = 31 * result + m03.hashCode()
		result = 31 * result + m10.hashCode()
		result = 31 * result + m11.hashCode()
		result = 31 * result + m12.hashCode()
		result = 31 * result + m13.hashCode()
		result = 31 * result + m20.hashCode()
		result = 31 * result + m21.hashCode()
		result = 31 * result + m22.hashCode()
		result = 31 * result + m23.hashCode()
		result = 31 * result + m30.hashCode()
		result = 31 * result + m31.hashCode()
		result = 31 * result + m32.hashCode()
		result = 31 * result + m33.hashCode()
		return result
	}
}