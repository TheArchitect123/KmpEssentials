---
sidebar_label: msgs
title: terra_sdk.core.feegrant.msgs
---

feegrant module message types.

## MsgGrantAllowance Objects

```python
@attr.s
class MsgGrantAllowance(Msg)
```

MsgGrantAllowance adds permission for Grantee to spend up to Allowance
of fees from the account of Granter.

## MsgRevokeAllowance Objects

```python
@attr.s
class MsgRevokeAllowance(Msg)
```

MsgRevokeAllowance remove permission any existing Allowance from Granter to Grantee.

