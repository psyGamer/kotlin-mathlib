package dev.psygamer.mathlib.matrix

import dev.psygamer.mathlib.quaternion.QuaternionF

class Matrix4F {
	
	private var m00: Float = 0.0f
	private var m01: Float = 0.0f
	private var m02: Float = 0.0f
	private var m03: Float = 0.0f
	
	private var m10: Float = 0.0f
	private var m11: Float = 0.0f
	private var m12: Float = 0.0f
	private var m13: Float = 0.0f
	
	private var m20: Float = 0.0f
	private var m21: Float = 0.0f
	private var m22: Float = 0.0f
	private var m23: Float = 0.0f
	
	private var m30: Float = 0.0f
	private var m31: Float = 0.0f
	private var m32: Float = 0.0f
	private var m33: Float = 0.0f
	
	constructor()
	
	constructor(other: Matrix4F) {
		this.m00 = other.m00
		this.m01 = other.m01
		this.m02 = other.m02
		this.m03 = other.m03
		
		this.m10 = other.m10
		this.m11 = other.m11
		this.m12 = other.m12
		this.m13 = other.m13
		
		this.m20 = other.m20
		this.m21 = other.m21
		this.m22 = other.m22
		this.m23 = other.m23
		
		this.m30 = other.m30
		this.m31 = other.m31
		this.m32 = other.m32
		this.m33 = other.m33
	}
	
	/** See: [EuclideanSpace - Conversion Quaternion to Matrix](https://www.euclideanspace.com/maths/geometry/rotations/conversions/quaternionToMatrix/index.htm) */
	constructor(quaternion: QuaternionF) {
		val xx = quaternion.x * quaternion.x
		val xy = quaternion.x * quaternion.y
		val xz = quaternion.x * quaternion.z
		val xw = quaternion.x * quaternion.w
		
		val yy = quaternion.y * quaternion.y
		val yz = quaternion.y * quaternion.z
		val yw = quaternion.y * quaternion.w
		
		val zz = quaternion.z * quaternion.z
		val zw = quaternion.z * quaternion.w
		
		this.m00 = 1.0f - 2.0f * (yy + zz)
		this.m01 = 2.0f * (xy - zw)
		this.m02 = 2.0f * (xz + xw)
		this.m03 = 0.0f
		
		this.m10 = 2.0f * (xy + zw)
		this.m11 = 1.0f - 2.0f * (xx + zz)
		this.m12 = 2.0f * (yz - xw)
		this.m13 = 0.0f
		
		this.m20 = 2.0f * (xz - yw)
		this.m21 = 2.0f * (yz + xw)
		this.m22 = 1.0f - 2.0f * (xx + yy)
		this.m23 = 0.0f
		
		this.m30 = 0.0f
		this.m31 = 0.0f
		this.m32 = 0.0f
		this.m33 = 1.0f
	}
}