---
sidebar_label: validator
title: terra_sdk.core.staking.data.validator
---

## CommissionRates Objects

```python
@attr.s
class CommissionRates(JSONSerializable)
```

Data structure for validator&#x27;s commission rates &amp; policy.

#### rate

Current % commission rate.

#### max\_rate

Maximum % commission rate permitted by policy.

#### max\_change\_rate

Maximum % change of commission per day.

## Commission Objects

```python
@attr.s
class Commission(JSONSerializable)
```

Contains information about validator&#x27;s commission rates.

#### commission\_rates

Validator commission rates.

#### update\_time

Last time commission rates were updated.

## Description Objects

```python
@attr.s
class Description(JSONSerializable)
```

Validator description entry.

**Arguments**:

- `moniker` - validator name, aka: \&quot;Terran One\&quot;
- `identity` - keybase.io identifier (used for setting logo)
- `website` - validator website
- `details` - longer description of validator
- `security_contact` - contact information for validator

## Validator Objects

```python
@attr.s
class Validator(JSONSerializable)
```

Contains information about a registered validator.

