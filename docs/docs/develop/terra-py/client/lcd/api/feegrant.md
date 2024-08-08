---
sidebar_label: feegrant
title: terra_sdk.client.lcd.api.feegrant
---

## AsyncFeeGrantAPI Objects

```python
class AsyncFeeGrantAPI(BaseAsyncAPI)
```

#### allowances

```python
async def allowances(address: AccAddress, params: Optional[APIParams] = None) -> (Allowance, dict)
```

fetch fee allowances

**Arguments**:

- `address` _AccAddress_ - grantee address
- `params` _APIParams, optional_ - additional params for the API like pagination
  

**Returns**:

- `Allowances[]` - granted allowances
- `pagination[]` - pagination info

#### allowance

```python
async def allowance(granter: AccAddress, grantee: AccAddress, params: Optional[APIParams] = None) -> Allowance
```

fetch granter&#x27;s allowance for the grantee

**Arguments**:

- `granter` _AccAddress_ - granter is the address of the user granting an allowance of their funds.
- `grantee` _AccAddress_ - grantee is the address of the user being granted an allowance of another user’s funds.
- `params` _APIParams, optional_ - additional params for the API like pagination
  

**Returns**:

- `Allowance` - granted allowance

#### allowances\_by\_granter

```python
async def allowances_by_granter(granter: AccAddress, params: Optional[APIParams] = None) -> Allowance
```

all the grants given by an granter

**Arguments**:

- `granter` _AccAddress_ - granter is the address of the user granting an allowance of their funds.
- `params` _APIParams, optional_ - additional params for the API like pagination
  

**Returns**:

- `Allowance` - granted allowance

