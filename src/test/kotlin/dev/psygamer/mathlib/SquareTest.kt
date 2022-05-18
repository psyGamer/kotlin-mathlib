package dev.psygamer.mathlib

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SquareTest {
	
	@Test
	fun intSquared() {
		assertEquals(8.squared, 8.pow2)
		assertEquals(64, 8.squared)
		assertEquals(64, (-8).squared)
	}
	
	@Test
	fun uintSquared() {
		assertEquals(8u.squared, 8u.pow2)
		assertEquals(64u, 8u.squared)
	}
	
	@Test
	fun longSquared() {
		assertEquals(8L.squared, 8L.pow2)
		assertEquals(64L, 8L.squared)
		assertEquals(64L, (-8L).squared)
	}
	
	@Test
	fun ulongSquared() {
		assertEquals(8uL.squared, 8uL.pow2)
		assertEquals(64uL, 8uL.squared)
	}
	
	@Test
	fun floatSquared() {
		assertEquals(8.0f.squared, 8.0f.pow2)
		assertEquals(64.0f, 8.0f.squared)
		assertEquals(6.25f, 2.5f.squared)
	}
	
	@Test
	fun doubleSquared() {
		assertEquals(8.0.squared, 8.0.pow2)
		assertEquals(64.0, 8.0.squared)
		assertEquals(6.25, 2.5.squared)
	}
}