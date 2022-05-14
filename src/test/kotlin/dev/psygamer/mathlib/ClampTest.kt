package dev.psygamer.mathlib

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ClampTest {
	
	@Test
	fun intClamp() {
		assertEquals(2, 2.clamp(min = 1, max = 3))
		assertEquals(1, 0.clamp(min = 1, max = 3))
		assertEquals(3, 4.clamp(min = 1, max = 3))
		assertEquals(2, (-5).clamp(min = 2, max = 9))
		assertEquals(69, 420.clamp(max = 69))
	}
	
	@Test
	fun uintClamp() {
		assertEquals(2u, 2u.clamp(min = 1u, max = 3u))
		assertEquals(1u, 0u.clamp(min = 1u, max = 3u))
		assertEquals(3u, 4u.clamp(min = 1u, max = 3u))
		assertEquals(5u, 5u.clamp(min = 2u, max = 9u))
		assertEquals(69u, 420u.clamp(max = 69u))
	}
	
	@Test
	fun longClamp() {
		assertEquals(2L, 2L.clamp(min = 1L, max = 3L))
		assertEquals(1L, 0L.clamp(min = 1L, max = 3L))
		assertEquals(3L, 4L.clamp(min = 1L, max = 3L))
		assertEquals(2L, (-5L).clamp(min = 2L, max = 9L))
		assertEquals(6969696969L, 420420420420420420L.clamp(max = 6969696969L))
	}
	
	@Test
	fun ulongClamp() {
		assertEquals(2uL, 2uL.clamp(min = 1uL, max = 3uL))
		assertEquals(1uL, 0uL.clamp(min = 1uL, max = 3uL))
		assertEquals(3uL, 4uL.clamp(min = 1uL, max = 3uL))
		assertEquals(5uL, 5uL.clamp(min = 2uL, max = 9uL))
		assertEquals(6969696969uL, 420420420420420420uL.clamp(max = 6969696969uL))
	}
	
	@Test
	fun floatClamp() {
		assertEquals(2.0f, 2.0f.clamp(min = 1.0f, max = 3.0f))
		assertEquals(1.0f, 0.0f.clamp(min = 1.0f, max = 3.0f))
		assertEquals(3.0f, 4.0f.clamp(min = 1.0f, max = 3.0f))
		assertEquals(5.0f, 5.0f.clamp(min = 2.0f, max = 9.0f))
		assertEquals(19.30f, 42.29f.clamp(min = 3.21f, max = 19.30f))
		assertEquals(3.21f, 1.3432f.clamp(min = 3.21f, max = 19.30f))
		assertEquals(13.37f, 13.37f.clamp(min = 3.21f, max = 19.30f))
	}
	
	@Test
	fun doubleClamp() {
		assertEquals(2.0f, 2.0f.clamp(min = 1.0f, max = 3.0f))
		assertEquals(1.0f, 0.0f.clamp(min = 1.0f, max = 3.0f))
		assertEquals(3.0f, 4.0f.clamp(min = 1.0f, max = 3.0f))
		assertEquals(5.0f, 5.0f.clamp(min = 2.0f, max = 9.0f))
		assertEquals(19.33838319321, 42.232919318.clamp(min = 3.21283183821, max = 19.33838319321))
		assertEquals(3.21283183821, 1.34391837822.clamp(min = 3.21283183821, max = 19.33838319321))
		assertEquals(13.3739812378, 13.3739812378.clamp(min = 3.21283183821, max = 19.33838319321))
	}
}