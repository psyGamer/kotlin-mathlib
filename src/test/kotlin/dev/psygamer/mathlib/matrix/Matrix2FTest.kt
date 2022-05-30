package dev.psygamer.mathlib.matrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Matrix2FTest {

	@Test
	fun plus() {
		assertEquals(
			Matrix2F(
				02.0f, 04.0f,
				10.0f, 12.0f,
			),
			Matrix2F(
				01.0f, 02.0f,
				05.0f, 06.0f,
			)
			+ Matrix2F(
				01.0f, 02.0f,
				05.0f, 06.0f,
			)
		)
	}

	@Test
	fun minus() {
		assertEquals(
			Matrix2F(
				0.0f, 0.0f,
				0.0f, 0.0f,
			),
			Matrix2F(
				01.0f, 02.0f,
				05.0f, 06.0f,
			)
			- Matrix2F(
				01.0f, 02.0f,
				05.0f, 06.0f,
			)
		)
	}

	@Test
	fun timesScalar() {
		assertEquals(
			Matrix2F(
				01.0f * 2.5f, 02.0f * 2.5f,
				05.0f * 2.5f, 06.0f * 2.5f,
			),
			Matrix2F(
				01.0f, 02.0f,
				05.0f, 06.0f,
			) * 2.5f
		)
	}

	@Test
	fun timesMatrix() {
		assertEquals(
			Matrix2F(
				11.0f, 14.0f,
				35.0f, 46.0f,
			),
			Matrix2F(
				01.0f, 02.0f,
				05.0f, 06.0f,
			)
			* Matrix2F(
				01.0f, 02.0f,
				05.0f, 06.0f,
			)
		)
	}

	@Test
	fun div() {
		assertEquals(
			Matrix2F(
				0.2f, 0.1f,
				-0.2f, 0.4f,
			),
			Matrix2F(
				1.0f, 1.0f,
				1.0f, 2.0f,
			)
			/ Matrix2F(
				3.0f, 2.0f,
				4.0f, 6.0f,
			)
		)
	}

	@Test
	fun determinant() {
		assertEquals(
			10.0f,
			Matrix2F(
				3.0f, 2.0f,
				4.0f, 6.0f
			).determinant
		)

		assertEquals(
			1.0f,
			Matrix2F(
				1.0f, 1.0f,
				1.0f, 2.0f
			).determinant
		)
	}

	@Test
	fun determinantOfTranspose() {
		val m = Matrix2F(
			1.0f, 2.0f,
			3.0f, 6.0f,
		)
		assertEquals(m.determinant, m.transpose.determinant)
	}

	@Test
	fun determinantWithColumnOfZeros() {
		assertEquals(
			0.0f,
			Matrix2F(
				1.0f, 0.0f,
				3.0f, 0.0f,
			).determinant
		)
	}

	@Test
	fun determinantWithIdenticalRows() {
		assertEquals(
			0.0f,
			Matrix2F(
				1.0f, 1.0f,
				3.0f, 3.0f,
			).determinant
		)
	}

	@Test
	fun determinantWithChangedRows() {
		assertEquals(
			Matrix2F(
				1.0f, 2.0f,
				3.0f, 6.0f,
			).determinant,
			Matrix2F(
				3.0f, 6.0f,
				1.0f, 2.0f,
			).determinant
		)
	}

	@Test
	fun multiplyingRowOrColumnOfDeterminantByScalar() {
		assertEquals(
			1.25f * Matrix2F(
				1.0f, 2.0f,
				3.0f, 6.0f,
			).determinant,
			Matrix2F(
				1.0f, 1.25f * 2.0f,
				3.0f, 1.25f * 6.0f,
			).determinant
		)
	}

	@Test
	fun determinantOfMatrixProduct() {
		val m1 = Matrix2F(
			1.0f, 2.0f,
			3.0f, 6.0f,
		)
		val m2 = Matrix2F(
			1.0f, 1.0f,
			1.0f, 2.0f,
		)
		assertEquals(m1.determinant * m2.determinant, (m1 * m2).determinant)
	}

	@Test
	fun determinantOfInverseMatrix() {
		val m = Matrix2F(
			1.0f, 2.0f,
			3.0f, 4.0f
		)
		assertEquals(m.inverse.determinant, 1.0f / m.determinant)
	}

	@Test
	fun inverse() {
		assertEquals(
			Matrix2F(
				-0.1f, -0.2f,
				-0.4f, -0.3f,
			),
			Matrix2F(
				6.0f, -4.0f,
				-8.0f, 2.0f,
			).inverse
		)

		val m = Matrix2F(
			1.0f, 2.0f,
			2.0f, 1.0f,
		)

		assertEquals(
			Matrix2F.IDENTITY,
			m * m.inverse
		)
	}

	@Test
	fun transposition() {
		assertEquals(
			Matrix2F(
				6.0f, -8.0f,
				-4.0f, 2.0f
			),
			Matrix2F(
				6.0f, -4.0f,
				-8.0f, 2.0f,
			).transpose
		)
	}

}