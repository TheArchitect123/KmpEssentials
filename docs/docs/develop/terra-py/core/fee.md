---
sidebar_label: fee
title: terra_sdk.core.fee
---

Data objects about Fee.

## Fee Objects

```python
@attr.s
class Fee(JSONSerializable)
```

Data structure holding information for a transaction fee.

**Arguments**:

- `gas` _int_ - gas to use (&quot;gas requested&quot;)
- `amount` _Coins.Input_ - fee amount
- `payer` _AccAddress, optional_ - address of fee payer
- `granter` _AccAddress, optional_ - address of fee granter

