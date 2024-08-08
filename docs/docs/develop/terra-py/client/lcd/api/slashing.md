---
sidebar_label: slashing
title: terra_sdk.client.lcd.api.slashing
---

## AsyncSlashingAPI Objects

```python
class AsyncSlashingAPI(BaseAsyncAPI)
```

#### signing\_info

```python
async def signing_info(val_cons_pub_key: ValConsPubKey, params: Optional[APIParams] = None) -> Union[List[dict], dict]
```

Fetches signing info for a validator consensus public key.

**Arguments**:

- `val_cons_pub_key` _ValConsPubKey_ - validator consensus public key.
- `params` _APIParams_ - optional parameters
  

**Returns**:

  Union[List[dict], dict]: signing info

#### signing\_infos

```python
async def signing_infos(params: Optional[APIParams] = None) -> (Union[List[dict], dict], dict)
```

Fetches all signing info.

**Arguments**:

- `params` _APIParams_ - optional parameters
  

**Returns**:

  Union[List[dict], dict]: signing infos
- `dict` - pagination info

#### parameters

```python
async def parameters(params: Optional[APIParams] = None) -> dict
```

Fetches Slashing module parameters.

**Arguments**:

- `params` _APIParams_ - optional parameters
  

**Returns**:

- `dict` - Slashing module parameters

