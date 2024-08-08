---
sidebar_label: msg_create_vesting_account
title: terra_sdk.core.auth.msgs.msg_create_vesting_account
---

Auth mdoule message types.

## MsgCreateVestingAccount Objects

```python
@attr.s
class MsgCreateVestingAccount(Msg)
```

MsgCreateVestingAccount defines a message that enables creating a vesting.

**Arguments**:

- `from_address` _AccAddress_ - account to create a vesting account
- `to_address` _AccAddress_ - vesting account
- `amount` _Coins_ - vesting amount
- `end_time` _int_ - vesting end time
- `delayed` _bool_ - all coins are vested once end time is reached

