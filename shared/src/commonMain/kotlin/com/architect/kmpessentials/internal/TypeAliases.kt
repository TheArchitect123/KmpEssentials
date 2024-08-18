package com.architect.kmpessentials.internal

internal typealias ActionNoParams = () -> Unit
internal typealias ActionStringParams = (String) -> Unit
internal typealias ActionDoubleParams = (Double) -> Unit
internal typealias ActionTripleDoubleParams = (Triple<Double, Double, Double>) -> Unit
internal typealias ActionTripleFloatParams = (Triple<Float, Float, Float>) -> Unit
internal typealias ActionIntParams = (Int) -> Unit
internal typealias ActionLongParams = (Long) -> Unit
internal typealias ActionBoolParams = (Boolean) -> Unit