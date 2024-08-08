---
sidebar_label: tendermint
title: terra_sdk.client.lcd.api.tendermint
---

## AsyncTendermintAPI Objects

```python
class AsyncTendermintAPI(BaseAsyncAPI)
```

#### node\_info

```python
async def node_info(params: Optional[APIParams] = None) -> dict
```

Fetches the curent connected node&#x27;s information.

**Arguments**:

- `params` _APIParams_ - optional parameters
  

**Returns**:

- `dict` - node information

#### syncing

```python
async def syncing(params: Optional[APIParams] = None) -> bool
```

Fetches whether the curent connect node is syncing with the network.

**Arguments**:

- `params` _APIParams_ - optional parameters
  

**Returns**:

- `bool` - syncing status

#### validator\_set

```python
async def validator_set(height: Optional[int] = None, params: Optional[APIParams] = None) -> dict
```

Fetches the validator set for a height. If no height is given, defaults to latest.

**Arguments**:

- `height` _int, optional_ - block height.
- `params` _APIParams_ - optional parameters
  

**Returns**:

- `dict` - validator set

#### block\_info

```python
async def block_info(height: Optional[int] = None, params: Optional[APIParams] = None) -> dict
```

Fetches the block information for a given height. If no height is given, defaults to latest block.

**Arguments**:

- `height` _int, optional_ - block height.
- `params` _APIParams_ - optional parameters
  

**Returns**:

- `dict` - block info

