---
sidebar_label: msgs
title: terra_sdk.core.bank.msgs
---

Bank module message types.

## MsgSend Objects

```python
@attr.s
class MsgSend(Msg)
```

Sends native Terra assets (Luna or Terra stablecoins) from ``from_address`` to ``to_address``.

**Arguments**:

- `from_address` _AccAddress_ - sender
- `to_address` _AccAddress_ - recipient
- `amount` _Coins_ - coins to send

## MultiSendInput Objects

```python
@attr.s
class MultiSendInput(JSONSerializable)
```

Organizes data for MsgMultiSend input/outputs. Expects data to be provided in the
format:

**Arguments**:

- `address` _AccAddress_ - from_address
- `coins` _Coins_ - amount to send from the address

#### address

Input / output address.

#### coins

Coins to be sent.

## MultiSendOutput Objects

```python
@attr.s
class MultiSendOutput(JSONSerializable)
```

Organizes data for MsgMultiSend input/outputs. Expects data to be provided in the
format:

**Arguments**:

- `address` _AccAddress_ - to_address
- `coins` _Coins_ - amount to receive

#### address

Input / output address.

#### coins

Coins to be received.

## MsgMultiSend Objects

```python
@attr.s
class MsgMultiSend(Msg)
```

Allows batch-sending between multiple source and destination addresses.
The total amount of coins in ``inputs`` must match ``outputs``. The transaction
containing ``MsgMultiSend`` must contain signatures from all addresses used as inputs.

**Arguments**:

- `inputs` _List[MultiSendInput]_ - senders and amounts
- `outputs` _List[MultiSendOutput]_ - recipients and amounts

