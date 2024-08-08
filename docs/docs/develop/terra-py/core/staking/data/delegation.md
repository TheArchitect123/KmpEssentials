---
sidebar_label: delegation
title: terra_sdk.core.staking.data.delegation
---

## Delegation Objects

```python
@attr.s
class Delegation(JSONSerializable)
```

Contains information about a current delegation pair (``delegator_address``, ``validator_address``)

## UnbondingDelegationEntry Objects

```python
@attr.s
class UnbondingDelegationEntry(JSONSerializable)
```

Contains information about an active unbonding lot of Luna.

## UnbondingDelegation Objects

```python
@attr.s
class UnbondingDelegation(JSONSerializable)
```

Contains information about undelegations for a delegation pair (``delegator_address``, ``validator_address``)

## RedelegationEntry Objects

```python
@attr.s
class RedelegationEntry(JSONSerializable)
```

Contains information about an active redelegated lot of Luna.

## Redelegation Objects

```python
@attr.s
class Redelegation(JSONSerializable)
```

Contains informations about a redelgation for delegation tuple (``delegator_address``, ``validator_src_address``, ``validator_dst_address``)

