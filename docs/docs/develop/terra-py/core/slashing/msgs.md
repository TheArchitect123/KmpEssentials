---
sidebar_label: msgs
title: terra_sdk.core.slashing.msgs
---

Slashing module messages types.

## MsgUnjail Objects

```python
@attr.s
class MsgUnjail(Msg)
```

Attempt to unjail a jailed validator (must be submitted by same validator).

**Arguments**:

- `address` - validator address to unjail

