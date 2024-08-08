---
sidebar_label: bank
title: terra_sdk.client.lcd.api.bank
---

## AsyncBankAPI Objects

```python
class AsyncBankAPI(BaseAsyncAPI)
```

#### balance

```python
async def balance(address: AccAddress, params: Optional[APIParams] = None) -> (Coins, dict)
```

Fetches an account&#x27;s current balance.

**Arguments**:

- `address` _AccAddress_ - account address
- `params` _APIParams, optional_ - additional params for the API like pagination
  

**Returns**:

- `Coins` - balance
- `Pagination` - pagination info

#### total

```python
async def total(params: Optional[APIParams] = None) -> (Coins, dict)
```

Fetches the current total supply of all tokens.

**Returns**:

- `Coins` - total supply
- `params` _APIParams, optional_ - additional params for the API like pagination

#### spendable\_balances

```python
async def spendable_balances(address: AccAddress, params: Optional[APIParams] = None) -> (Coins, dict)
```

Queries the spenable balance of all coins for a single account

**Returns**:

- `Coins` - spendable balance
- `params` _APIParams, optional_ - additional params for the API like pagination

