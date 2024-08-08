---
sidebar_label: msgs
title: terra_sdk.core.staking.msgs
---

Staking module message types.

## MsgBeginRedelegate Objects

```python
@attr.s
class MsgBeginRedelegate(Msg)
```

Redelegate staked Luna from ``validator_src_address`` to ``valdiator_dst_address``.

**Arguments**:

- `delegator_address` - delegator
- `validator_src_address` - validator to remove delegation FROM
- `validator_dst_address` - validator to transfer delegate TO
- `amount` _Union[str, dict, Coin]_ - coin (LUNA) to redelegate

## MsgDelegate Objects

```python
@attr.s
class MsgDelegate(Msg)
```

Delegate Luna to validator at ``validator_address``.

**Arguments**:

- `delegator_address` - delegator
- `validator_address` - validator to delegate to
- `amount` _Union[str, dict, Coin]_ - coin (LUNA) to delegate

## MsgUndelegate Objects

```python
@attr.s
class MsgUndelegate(Msg)
```

Undelegate Luna from staking position with ``validator_address``.

**Arguments**:

- `delegator_address` - delegator
- `validator_address` - validator to undelegate from
- `amount` _Union[str, dict, Coin]_ - coin (LUNA) to undelegate

## MsgEditValidator Objects

```python
@attr.s
class MsgEditValidator(Msg)
```

Revise validator description and configuration.

**Arguments**:

- `description` - updated validator description
- `validator_address` - validator operator address
- `commission_rates` - new validator commission rate,
- `min_self_delegation` - new minimum self delegation,

## MsgCreateValidator Objects

```python
@attr.s
class MsgCreateValidator(Msg)
```

Register a new validator with the Terra protocol.

**Arguments**:

- `description` - validator description
- `commission` - validator commission rates
- `min_self_delegation` - minimum self-delegation policy
- `delegator_address` - validator&#x27;s account address
- `validator_address` - validator&#x27;s operator address
- `pubkey` - validator consensus (Tendermint) public key
- `value` _Coin.Input_ - initial amount of Luna toi self-delegate

