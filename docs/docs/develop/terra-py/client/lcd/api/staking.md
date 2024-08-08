---
sidebar_label: staking
title: terra_sdk.client.lcd.api.staking
---

## RedelegationsOptions Objects

```python
class RedelegationsOptions(PaginationOptions)
```

just internal class for relegation option

## AsyncStakingAPI Objects

```python
class AsyncStakingAPI(BaseAsyncAPI)
```

#### delegations

```python
async def delegations(delegator: Optional[AccAddress] = None, validator: Optional[ValAddress] = None, params: Optional[APIParams] = None) -> (List[Delegation], dict)
```

Fetches current delegations, filtering by delegator, validator, or both.

**Arguments**:

- `delegator` _Optional[AccAddress], optional_ - delegator account address.
- `validator` _Optional[ValAddress], optional_ - validator operator address.
- `params` _APIParams, optional_ - additional params for the API like pagination
  

**Raises**:

- `TypeError` - if both ``delegator`` and ``validator`` are ``None``.
  

**Returns**:

- `List[Delegation]` - delegations
- `dict` - pagination info

#### delegation

```python
async def delegation(delegator: AccAddress, validator: ValAddress) -> Delegation
```

Fetch a single delegation via a delegator, validator pair.

**Arguments**:

  delegator (Optional[AccAddress), optional: delegator account address
- `validator` _Optional[ValAddress], optional_ - validator operator address
  

**Returns**:

- `Delegation` - delegation

#### unbonding\_delegations

```python
async def unbonding_delegations(delegator: Optional[AccAddress] = None, validator: Optional[ValAddress] = None, params: Optional[APIParams] = None) -> (List[UnbondingDelegation], dict)
```

Fetches current undelegations, filtering by delegator, validator, or both.

**Arguments**:

- `delegator` _Optional[AccAddress], optional_ - delegator account address.
- `validator` _Optional[ValAddress], optional_ - validator operator address.
- `params` _APIParams, optional_ - additional params for the API like pagination
  

**Raises**:

- `TypeError` - if both ``delegator`` and ``validator`` are ``None``.
  

**Returns**:

- `List[UnbondingDelegation]` - undelegations
- `dict` - pagination info

#### unbonding\_delegation

```python
async def unbonding_delegation(delegator: AccAddress, validator: ValAddress) -> UnbondingDelegation
```

Fetch a single undelegation via a delegator, validator pair.

**Arguments**:

- `delegator` _AccAddress_ - delegator account address
- `validator` _ValAddress_ - validator operator address
  

**Returns**:

- `UnbondingDelegation` - undelegation

#### redelegations

```python
async def redelegations(delegator: Optional[AccAddress] = None, validator_src: Optional[ValAddress] = None, validator_dst: Optional[ValAddress] = None, params: Optional[APIParams] = None) -> (List[Redelegation], dict)
```

Fetch redelgations.

**Arguments**:

- `delegator` _Optional[AccAddress], optional_ - delegator account address.
- `validator_src` _Optional[ValAddress], optional_ - source validator operator address (from).
- `validator_dst` _Optional[ValAddress], optional_ - dest. validator operator address (to).
- `params` _APIParams, optional_ - additional params for the API like pagination
  

**Returns**:

- `List[Redelegation]` - redelegations
- `dict` - pagination info

#### bonded\_validators

```python
async def bonded_validators(delegator: AccAddress, params: Optional[PaginationOptions]) -> (List[Validator], dict)
```

Fetches the list of validators a delegator is currently delegating to.

**Arguments**:

- `delegator` _AccAddress_ - delegator account address
- `params` _APIParams, optional_ - additional params for the API like pagination
  

**Returns**:

- `List[Validator]` - currently bonded validators
- `dict` - pagination info

#### validators

```python
async def validators(params: Optional[APIParams] = None) -> (List[Validator], dict)
```

Fetch information of all validators.

**Arguments**:

- `params` _APIParams, optional_ - additional params for the API like pagination
  

**Returns**:

- `List[Validator]` - validator informations
- `dict` - pagination info

#### validator

```python
async def validator(validator: ValAddress) -> Validator
```

Fetch information about a single validator.

**Arguments**:

- `validator` _ValAddress_ - validator operator address
  

**Returns**:

- `Validator` - validator information

#### pool

```python
async def pool() -> StakingPool
```

Fetch current staking pool information.

**Returns**:

- `StakingPool` - information about current staking pool

#### parameters

```python
async def parameters() -> dict
```

Fetch Staking module parameters.

**Returns**:

- `dict` - Staking module parameters

