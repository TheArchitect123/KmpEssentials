---
sidebar_label: msgs
title: terra_sdk.core.crisis.msgs
---

Crisis module message types.

## MsgVerifyInvariant Objects

```python
@attr.s
class MsgVerifyInvariant(Msg)
```

MsgVerifyInvariant represents a message to verify a particular invariance.

**Arguments**:

- `sender` - address of the sender
- `invariant_module_name` - module name to verify invariant
- `invariant_route` - route to veriryf

