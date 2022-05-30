package dev.psygamer.mathlib.matrix

import dev.psygamer.mathlib.almostEquals

class Matrix2F(
	private val m00: Float,
	private val m01: Float,

	private val m10: Float,
	private val m11: Float,
) {

	companion object {

		val IDENTITY = Matrix2F()
	}

	constructor() : this(
		1.0f, 0.0f,
		0.0f, 1.0f,
	)

	constructor(other: Matrix2F) : this(
		other.m00, other.m01,
		other.m10, other.m11,
	)

	operator fun plus(other: Matrix2F): Matrix2F {
		return Matrix2F(
			m00 + other.m00, m01 + other.m01,
			m10 + other.m10, m11 + other.m11,
		)
	}

	operator fun minus(other: Matrix2F): Matrix2F {
		return Matrix2F(
			m00 - other.m00, m01 - other.m01,
			m10 - other.m10, m11 - other.m11,
		)
	}

	operator fun times(scalar: Float): Matrix2F {
		return Matrix2F(
			m00 * scalar, m01 * scalar,
			m10 * scalar, m11 * scalar,
		)
	}

	operator fun times(other: Matrix2F): Matrix2F {
		return Matrix2F(
			m00 * other.m00 + m01 * other.m10,
			m00 * other.m01 + m01 * other.m11,

			m10 * other.m00 + m11 * other.m10,
			m10 * other.m01 + m11 * other.m11,
		)
	}

	operator fun div(other: Matrix2F): Matrix2F {
		return this * other.inverse
	}

	val determinant
		get() = m00 * m11 - m01 * m10

	val transpose
		get() = Matrix2F(
			m00, m10,
			m01, m11,
		)

	val inverse
		get() = 1.0f / this.determinant * Matrix2F(
			m11, -m01,
			-m10, m00
		)

	override fun toString(): String =
		"""Matrix2F [[$m00, $m01],
			   		 [$m10, $m11]]"""

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as Matrix2F

		if (!m00.almostEquals(other.m00)) return false
		if (!m01.almostEquals(other.m01)) return false
		if (!m10.almostEquals(other.m10)) return false
		if (!m11.almostEquals(other.m11)) return false

		return true
	}

	override fun hashCode(): Int {
		var result = m00.hashCode()
		result = 31 * result + m01.hashCode()
		result = 31 * result + m10.hashCode()
		result = 31 * result + m11.hashCode()
		return result
	}
}

operator fun Float.times(other: Matrix2F): Matrix2F =
	other * this