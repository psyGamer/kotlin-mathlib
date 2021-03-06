package dev.psygamer.mathlib.quaternion

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.sin
import dev.psygamer.mathlib.vector.Vector3F

internal class QuaternionFTest {

	@Test
	fun rotatorConstructor() {
		assertEquals(
			QuaternionF(1.0f, 0.0f, 0.0f, 0.0f),
			QuaternionF(0.0f, Vector3F(1.0f, 0.0f, 0.0f))
		)

		assertEquals(
			QuaternionF(0.0f, 0.0f, 1.0f, 0.0f),
			QuaternionF(180.0f, Vector3F(0.0f, 1.0f, 0.0f))
		)

		assertEquals(
			QuaternionF(sin(Math.toRadians(45.0)).toFloat(), 0.0f, 0.0f, sin(Math.toRadians(45.0)).toFloat()),
			QuaternionF(90.0f, Vector3F(0.0f, 0.0f, 1.0f))
		)
	}

	@Test
	fun alternativeAccessors() {
		val q = QuaternionF(1.0f, 2.0f, 1.25f, 0.2f)
		assertEquals(q.r, q.w)
		assertEquals(q.i, q.x)
		assertEquals(q.j, q.y)
		assertEquals(q.k, q.z)

		assertEquals(q.real, q.r)
	}

	@Test
	fun plus() {
		assertEquals(
			QuaternionF(4.2f + 6.9f, 2.0f + 3.0f, 3.5f + 1.5f, 1.2f + 0.7f),
			QuaternionF(4.2f, 2.0f, 3.5f, 1.2f) + QuaternionF(6.9f, 3.0f, 1.5f, 0.7f)
		)
	}

	@Test
	fun minus() {
		assertEquals(
			QuaternionF(4.2f - 6.9f, 2.0f - 3.0f, 3.5f - 1.5f, 1.2f - 0.7f),
			QuaternionF(4.2f, 2.0f, 3.5f, 1.2f) - QuaternionF(6.9f, 3.0f, 1.5f, 0.7f)
		)
	}

	@Test
	fun times() {
		assertEquals(
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
		assertTrue(
			(QuaternionF(1.0f, 0.0f, 0.0f, 0.0f) *
			 QuaternionF(2.0f, 0.0f, 0.0f, 0.0f)).isReal
		)
		assertFalse(
			(QuaternionF(1.0f, 0.0f, 0.0f, 0.0f) *
			 QuaternionF(2.0f, 0.0f, 0.0f, 0.1f)).isReal
		)
	}

	@Test
	fun div() {
		assertEquals(
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
		assertEquals(
			QuaternionF(1.0f * 5.0f, 2.0f * 6.0f, 3.0f * 7.0f, 4.0f * 8.0f),
			QuaternionF(1.0f, 2.0f, 3.0f, 4.0f) dot QuaternionF(5.0f, 6.0f, 7.0f, 8.0f),
		)
	}

	@Test
	fun conjugate() {
		assertEquals(
			QuaternionF(4.2f, -2.0f, -3.5f, -1.2f),
			QuaternionF(4.2f, 2.0f, 3.5f, 1.2f).conjugate
		)
	}

	@Test
	fun inverse() {
		assertEquals(
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
		assertEquals(1.0f, q.w, 0.001f)
		assertEquals(0.0f, q.x, 0.001f)
		assertEquals(0.0f, q.y, 0.001f)
		assertEquals(0.0f, q.z, 0.001f)
	}

	@Test
	fun norm() {
		assertEquals(7.0f, QuaternionF(1.0f, 4.0f, 4.0f, -4.0f).norm)
		assertEquals(49.0f, QuaternionF(1.0f, 4.0f, 4.0f, -4.0f).normSquared)
	}
}