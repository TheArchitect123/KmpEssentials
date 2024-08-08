---
sidebar_label: data
title: terra_sdk.core.feegrant.data
---

feegrant module data objects.

## BasicAllowance Objects

```python
@attr.s
class BasicAllowance(JSONSerializable)
```

BasicAllowance implements Allowance with a one-time grant of tokens
that optionally expires. The grantee can use up to SpendLimit to cover fees.

## PeriodicAllowance Objects

```python
@attr.s
class PeriodicAllowance(JSONSerializable)
```

PeriodicAllowance extends Allowance to allow for both a maximum cap,
 as well as a limit per time period.

## AllowedMsgAllowance Objects

```python
@attr.s
class AllowedMsgAllowance(JSONSerializable)
```

AllowedMsgAllowance creates allowance only for specified message types.

