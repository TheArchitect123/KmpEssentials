---
sidebar_label: auth
title: terra_sdk.client.lcd.api.auth
---

## AsyncAuthAPI Objects

```python
class AsyncAuthAPI(BaseAsyncAPI)
```

#### account\_info

```python
async def account_info(address: AccAddress, params: Optional[APIParams] = None) -> Union[
        BaseAccount,
        ContinuousVestingAccount,
        DelayedVestingAccount,
        PeriodicVestingAccount,
    ]
```

Fetches the account information.

**Arguments**:

- `address` _AccAddress_ - account address
- `params` _APIParams_ - optional parameters
  

**Returns**:

  Union[BaseAccount, ContinuousVestingAccount, DelayedVestingAccount, PeriodicVestingAccount]: account information

