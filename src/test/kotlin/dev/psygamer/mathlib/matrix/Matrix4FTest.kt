package dev.psygamer.mathlib.matrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Matrix4FTest {

	@Test
	fun plus() {
		assertEquals(
			Matrix4F(
				02.0f, 04.0f, 06.0f, 08.0f,
				10.0f, 12.0f, 14.0f, 16.0f,
				18.0f, 20.0f, 22.0f, 24.0f,
				26.0f, 28.0f, 30.0f, 32.0f,
			),
			Matrix4F(
				01.0f, 02.0f, 03.0f, 04.0f,
				05.0f, 06.0f, 07.0f, 08.0f,
				09.0f, 10.0f, 11.0f, 12.0f,
				13.0f, 14.0f, 15.0f, 16.0f,
			)
			+ Matrix4F(
				01.0f, 02.0f, 03.0f, 04.0f,
				05.0f, 06.0f, 07.0f, 08.0f,
				09.0f, 10.0f, 11.0f, 12.0f,
				13.0f, 14.0f, 15.0f, 16.0f,
			)
		)
	}

	@Test
	fun minus() {
		assertEquals(
			Matrix4F(
				0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 0.0f,
			),
			Matrix4F(
				01.0f, 02.0f, 03.0f, 04.0f,
				05.0f, 06.0f, 07.0f, 08.0f,
				09.0f, 10.0f, 11.0f, 12.0f,
				13.0f, 14.0f, 15.0f, 16.0f,
			)
			- Matrix4F(
				01.0f, 02.0f, 03.0f, 04.0f,
				05.0f, 06.0f, 07.0f, 08.0f,
				09.0f, 10.0f, 11.0f, 12.0f,
				13.0f, 14.0f, 15.0f, 16.0f,
			)
		)
	}

	@Test
	fun timesScalar() {
		assertEquals(
			Matrix4F(
				01.0f * 2.5f, 02.0f * 2.5f, 03.0f * 2.5f, 04.0f * 2.5f,
				05.0f * 2.5f, 06.0f * 2.5f, 07.0f * 2.5f, 08.0f * 2.5f,
				09.0f * 2.5f, 10.0f * 2.5f, 11.0f * 2.5f, 12.0f * 2.5f,
				13.0f * 2.5f, 14.0f * 2.5f, 15.0f * 2.5f, 16.0f * 2.5f,
			),
			Matrix4F(
				01.0f, 02.0f, 03.0f, 04.0f,
				05.0f, 06.0f, 07.0f, 08.0f,
				09.0f, 10.0f, 11.0f, 12.0f,
				13.0f, 14.0f, 15.0f, 16.0f,
			) * 2.5f
		)
	}

	@Test
	fun timesMatrix() {
		assertEquals(
			Matrix4F(
				90.0f, 100.0f, 110.0f, 120.0f,
				202.0f, 228.0f, 254.0f, 280.0f,
				314.0f, 356.0f, 398.0f, 440.0f,
				426.0f, 484.0f, 542.0f, 600.0f,
			),
			Matrix4F(
				01.0f, 02.0f, 03.0f, 04.0f,
				05.0f, 06.0f, 07.0f, 08.0f,
				09.0f, 10.0f, 11.0f, 12.0f,
				13.0f, 14.0f, 15.0f, 16.0f,
			)
			* Matrix4F(
				01.0f, 02.0f, 03.0f, 04.0f,
				05.0f, 06.0f, 07.0f, 08.0f,
				09.0f, 10.0f, 11.0f, 12.0f,
				13.0f, 14.0f, 15.0f, 16.0f,
			)
		)
	}

	@Test
	fun div() {
		assertEquals(
			Matrix4F(
				7.0f, 6.0f, 6.0f, 5.0f,
				6.0f, 7.0f, 6.0f, 5.0f,
				5.0f, 5.0f, 5.0f, 4.0f,
				6.0f, 6.0f, 6.0f, 5.0f,
			),
			Matrix4F(
				1.0f, 1.0f, 2.0f, 1.0f,
				1.0f, 2.0f, 1.0f, 1.0f,
				2.0f, 1.0f, 1.0f, 1.0f,
				1.0f, 1.0f, 1.0f, 1.0f,
			)
			/ Matrix4F(
				0.0f, 1.0f, -1.0f, 0.0f,
				1.0f, 0.0f, -1.0f, 0.0f,
				0.0f, 0.0f, -1.0f, 1.0f,
				-1.0f, -1.0f, 4.0f, -1.0f,
			)
		)
	}

	@Test
	fun determinant() {
		assertEquals(
			-1.0f,
			Matrix4F(
				1.0f, 1.0f, 2.0f, 1.0f,
				1.0f, 2.0f, 1.0f, 1.0f,
				2.0f, 1.0f, 1.0f, 1.0f,
				1.0f, 1.0f, 1.0f, 1.0f,
			).determinant
		)
		assertEquals(
			-5.0f,
			Matrix4F(
				1.0f, 1.0f, 2.0f, 1.0f,
				1.0f, 2.0f, 1.0f, 1.0f,
				2.0f, 1.0f, 1.0f, 1.0f,
				1.0f, 1.0f, 1.0f, 2.0f,
			).determinant
		)
	}

	@Test
	fun inverse() {
		assertEquals(
			Matrix4F(
				0.0f, 1.0f, -1.0f, 0.0f,
				1.0f, 0.0f, -1.0f, 0.0f,
				-1.0f, -1.0f, 4.0f, -1.0f,
				0.0f, 0.0f, -1.0f, 1.0f,
			),
			Matrix4F(
				1.0f, 1.0f, 2.0f, 1.0f,
				1.0f, 2.0f, 1.0f, 1.0f,
				2.0f, 1.0f, 1.0f, 1.0f,
				1.0f, 1.0f, 1.0f, 1.0f,
			).inverse
		)

		val q = Matrix4F(
			1.0f, 2.0f, 1.0f, 1.0f,
			2.0f, 1.0f, 1.0f, 1.0f,
			1.0f, 1.0f, 1.0f, 1.0f,
			1.0f, 1.0f, 1.0f, 2.0f,
		)

		assertEquals(
			Matrix4F.IDENTITY,
			q * q.inverse
		)
	}
}