package dev.psygamer.mathlib.quaternion

import org.junit.jupiter.api.*

internal class QuaternionFTest {
	
	@Test
	fun alternativeAccessors() {
		val q = QuaternionF(1.0f, 2.0f, 1.25f, 0.2f)
		Assertions.assertEquals(q.r, q.w)
		Assertions.assertEquals(q.i, q.x)
		Assertions.assertEquals(q.j, q.y)
		Assertions.assertEquals(q.k, q.z)
		
		Assertions.assertEquals(q.real, q.r)
	}
	
	@Test
	fun plus() {
		Assertions.assertEquals(
			QuaternionF(4.2f + 6.9f, 2.0f + 3.0f, 3.5f + 1.5f, 1.2f + 0.7f),
			QuaternionF(4.2f, 2.0f, 3.5f, 1.2f) + QuaternionF(6.9f, 3.0f, 1.5f, 0.7f)
		)
	}
	
	@Test
	fun minus() {
		Assertions.assertEquals(
			QuaternionF(4.2f - 6.9f, 2.0f - 3.0f, 3.5f - 1.5f, 1.2f - 0.7f),
			QuaternionF(4.2f, 2.0f, 3.5f, 1.2f) - QuaternionF(6.9f, 3.0f, 1.5f, 0.7f)
		)
	}
	
	@Test
	fun times() {
		Assertions.assertEquals(
			QuaternionF(
				-2.0f * 3.0f - 3.5f * 1.5f - 1.2f * 0.7f + 4.2f * 6.9f,
				+2.0f * 6.9f + 3.5f * 0.7f - 1.2f * 1.5f + 4.2f * 3.0f,
				-2.0f * 0.7f + 3.5f * 6.9f + 1.2f * 3.0f + 4.2f * 1.5f,
				+2.0f * 1.5f - 3.5f * 3.0f + 1.2f * 6.9f + 4.2f * 0.7f,
			),
			QuaternionF(4.2f, 2.0f, 3.5f, 1.2f) * QuaternionF(6.9f, 3.0f, 1.5f, 0.7f)
		)
	}
	
	@Test
	fun realQuatTimesRealQuatIsRealQuat() {
		Assertions.assertTrue(
			(QuaternionF(1.0f, 0.0f, 0.0f, 0.0f) *
			 QuaternionF(2.0f, 0.0f, 0.0f, 0.0f)).isReal
		)
		Assertions.assertFalse(
			(QuaternionF(1.0f, 0.0f, 0.0f, 0.0f) *
			 QuaternionF(2.0f, 0.0f, 0.0f, 0.1f)).isReal
		)
	}
	
	@Test
	fun div() {
		Assertions.assertEquals(
			QuaternionF(
				-2.0f * -3.0f - 3.5f * -1.5f - 1.2f * -0.7f + 4.2f * +6.9f,
				+2.0f * +6.9f + 3.5f * -0.7f - 1.2f * -1.5f + 4.2f * -3.0f,
				-2.0f * -0.7f + 3.5f * +6.9f + 1.2f * -3.0f + 4.2f * -1.5f,
				+2.0f * -1.5f - 3.5f * -3.0f + 1.2f * +6.9f + 4.2f * -0.7f,
			),
			QuaternionF(4.2f, 2.0f, 3.5f, 1.2f) / QuaternionF(6.9f, 3.0f, 1.5f, 0.7f)
		)
	}
	
	@Test
	fun dot() {
		Assertions.assertEquals(
			QuaternionF(1.0f * 5.0f, 2.0f * 6.0f, 3.0f * 7.0f, 4.0f * 8.0f),
			QuaternionF(1.0f, 2.0f, 3.0f, 4.0f) dot QuaternionF(5.0f, 6.0f, 7.0f, 8.0f),
		)
	}
	
	@Test
	fun conjugate() {
		Assertions.assertEquals(
			QuaternionF(4.2f, -2.0f, -3.5f, -1.2f),
			QuaternionF(4.2f, 2.0f, 3.5f, 1.2f).conjugate
		)
	}
	
	@Test
	fun inverse() {
		Assertions.assertEquals(
			QuaternionF(1.0f, 0.0f, 0.0f, 0.0f),
			QuaternionF(1.0f, 2.0f, 3.0f, 4.0f) *
			QuaternionF(1.0f, 2.0f, 3.0f, 4.0f).inverse
		)
	}
	
	@Test
	fun qTimesConjEqualsOne() {
		val q = (
				QuaternionF(4.2f, 2.0f, 3.5f, 1.2f) *
				QuaternionF(4.2f, 2.0f, 3.5f, 1.2f).conjugate).normalized
		Assertions.assertEquals(1.0f, q.w, 0.001f)
		Assertions.assertEquals(0.0f, q.x, 0.001f)
		Assertions.assertEquals(0.0f, q.y, 0.001f)
		Assertions.assertEquals(0.0f, q.z, 0.001f)
	}
	
	@Test
	fun norm() {
		Assertions.assertEquals(7.0f, QuaternionF(1.0f, 4.0f, 4.0f, -4.0f).norm)
		Assertions.assertEquals(49.0f, QuaternionF(1.0f, 4.0f, 4.0f, -4.0f).normSquared)
	}
}