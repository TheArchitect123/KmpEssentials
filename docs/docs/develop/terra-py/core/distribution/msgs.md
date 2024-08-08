---
sidebar_label: msgs
title: terra_sdk.core.distribution.msgs
---

Distribution module message types.

## MsgSetWithdrawAddress Objects

```python
@attr.s
class MsgSetWithdrawAddress(Msg)
```

Modify Withdraw Address of a delegator.

**Arguments**:

- `delegator_address` - delegator
- `withdraw_address` - new withdraw address

## MsgWithdrawDelegatorReward Objects

```python
@attr.s
class MsgWithdrawDelegatorReward(Msg)
```

Withdraw rewards for a delegation specified by a (delegator, validator) pair.

**Arguments**:

- `delegator_address` - delegator
- `validator_address` - validator

## MsgWithdrawValidatorCommission Objects

```python
@attr.s
class MsgWithdrawValidatorCommission(Msg)
```

Withdraw rewards accrued for a validator gained through commissions.

**Arguments**:

- `validator_address` - validator operator address

## MsgFundCommunityPool Objects

```python
@attr.s
class MsgFundCommunityPool(Msg)
```

Deposit assets to the Community Pool.

**Arguments**:

- `depositor` _AccAddress_ - sender
- `amount` _Coins_ - amount to fund community pool with

