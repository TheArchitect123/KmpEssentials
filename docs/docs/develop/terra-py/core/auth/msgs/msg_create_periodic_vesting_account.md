---
sidebar_label: msg_create_periodic_vesting_account
title: terra_sdk.core.auth.msgs.msg_create_periodic_vesting_account
---

Auth mdoule message types.

## MsgCreatePeriodicVestingAccount Objects

```python
@attr.s
class MsgCreatePeriodicVestingAccount(Msg)
```

MsgCreatePeriodicVestingAccount defines a message that enables creating a periodic vesting.

**Arguments**:

- `from_address` _AccAddress_ - account to create a vesting account
- `to_address` _AccAddress_ - vesting account
- `start_time` _int_ - vesting start time
- `vesting_periods` _List[Period]_ - list of periods

