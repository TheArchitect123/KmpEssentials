---
sidebar_label: distribution
title: terra_sdk.client.lcd.api.distribution
---

## Rewards Objects

```python
@attr.s
class Rewards()
```

#### rewards

Delegator rewards, indexed by validator operator address.

#### total

Total sum of rewards.

## AsyncDistributionAPI Objects

```python
class AsyncDistributionAPI(BaseAsyncAPI)
```

#### rewards

```python
async def rewards(delegator: AccAddress, params: Optional[APIParams] = None) -> Rewards
```

Fetches the staking reward data for a delegator.

**Arguments**:

- `delegator` _AccAddress_ - delegator account address
- `params` _APIParams_ - optional parameters
  

**Returns**:

- `Rewards` - delegator rewards

#### validator\_commission

```python
async def validator_commission(validator: ValAddress, params: Optional[APIParams] = None) -> Coins
```

Fetches the commission reward data for a validator.

**Arguments**:

- `validator` _ValAddress_ - validator operator address
- `params` _APIParams_ - optional parameters
  

**Returns**:

- `ValidatorCommission` - validator rewards

#### withdraw\_address

```python
async def withdraw_address(delegator: AccAddress, params: Optional[APIParams] = None) -> AccAddress
```

Fetches the withdraw address associated with a delegator.

**Arguments**:

- `delegator` _AccAddress_ - delegator account address
- `params` _APIParams_ - optional parameters
  

**Returns**:

- `AccAddress` - withdraw address

#### community\_pool

```python
async def community_pool(params: Optional[APIParams] = None) -> Coins
```

Fetches the community pool.

**Arguments**:

- `params` _APIParams_ - optional parameters
  

**Returns**:

- `Coins` - community pool

#### parameters

```python
async def parameters(params: Optional[APIParams] = None) -> dict
```

Fetches the Distribution module parameters.

**Arguments**:

- `params` _APIParams_ - optional parameters
  

**Returns**:

- `dict` - Distribution module parameters

