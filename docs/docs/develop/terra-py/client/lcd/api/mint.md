---
sidebar_label: mint
title: terra_sdk.client.lcd.api.mint
---

## AsyncMintAPI Objects

```python
class AsyncMintAPI(BaseAsyncAPI)
```

#### inflation

```python
async def inflation(params: Optional[APIParams] = None) -> Dec
```

Fetches the current inflation.

**Arguments**:

- `params` _APIParams_ - optional parameters
  

**Returns**:

- `Dec` - inflation

#### annual\_provisions

```python
async def annual_provisions(params: Optional[APIParams] = None) -> Dec
```

Fetches the annual provisions.

**Arguments**:

- `params` _APIParams_ - optional parameters
  

**Returns**:

- `Dec` - annual provisions

#### parameters

```python
async def parameters(params: Optional[APIParams] = None) -> dict
```

Fetches the Mint module&#x27;s parameters.

**Arguments**:

- `params` _APIParams_ - optional parameters
  

**Returns**:

- `dict` - Mint module parameters

