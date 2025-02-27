package com.architect.kmpessentials.internal

import com.architect.kmpessentials.battery.enums.BatteryChargeState
import com.architect.kmpessentials.battery.enums.BatteryPowerSource
import com.architect.kmpessentials.permissions.PermissionStatus

internal typealias ActionNoParams = () -> Unit
internal typealias ActionStringParams = (String) -> Unit
internal typealias ActionListStringParams = (List<String>) -> Unit
internal typealias ActionDoubleParams = (Double) -> Unit
internal typealias ActionTripleDoubleParams = (Triple<Double, Double, Double>) -> Unit
internal typealias ActionTripleFloatParams = (Triple<Float, Float, Float>) -> Unit
internal typealias ActionIntParams = (Int) -> Unit
internal typealias ActionLongParams = (Long) -> Unit
internal typealias ActionBoolParams = (Boolean) -> Unit
internal typealias ActionPermissionStatusParams = (PermissionStatus) -> Unit


internal typealias ActionFloatNullParams = (Float?) -> Unit
internal typealias ActionIntNullParams = (Int?) -> Unit
internal typealias ActionLongNullParams = (Long?) -> Unit
internal typealias ActionBoolNullParams = (Boolean?) -> Unit
internal typealias ActionStringNullParams = (String?) -> Unit
internal typealias ActionDoubleNullParams = (Double?) -> Unit

// battery
internal typealias ActionChargeStatusParams = (BatteryChargeState) -> Unit
internal typealias ActionBatteryPowerStatusParams = (BatteryPowerSource) -> Unit