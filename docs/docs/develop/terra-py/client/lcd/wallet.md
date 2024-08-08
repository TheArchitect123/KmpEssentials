---
sidebar_label: wallet
title: terra_sdk.client.lcd.wallet
---

## Wallet Objects

```python
class Wallet()
```

Wraps around a :class:`Key` implementation and provides transaction building and
signing functionality. It is recommended to create this object through
:meth:`LCDClient.wallet()&lt;terra_sdk.client.lcd.LCDClient.wallet&gt;`.

#### account\_number

```python
def account_number() -> int
```

Fetches account number for the account associated with the Key.

#### sequence

```python
def sequence() -> int
```

Fetches the sequence number for the account associated with the Key.

#### account\_number\_and\_sequence

```python
def account_number_and_sequence() -> dict
```

Fetches both account and sequence number associated with the Key.

#### create\_tx

```python
def create_tx(options: CreateTxOptions) -> Tx
```

Builds an unsigned transaction object. The ``Wallet`` will first
query the blockchain to fetch the latest ``account`` and ``sequence`` values for the
account corresponding to its Key, unless the they are both provided. If no ``fee``
parameter is set, automatic fee estimation will be used (see `fee_estimation`).

**Arguments**:

- `options` _CreateTxOptions_ - Options to create a tx
  

**Returns**:

- `Tx` - unsigned transaction

#### create\_and\_sign\_tx

```python
def create_and_sign_tx(options: CreateTxOptions) -> Tx
```

Creates and signs a :class:`Tx` object in a single step. This is the recommended
method for preparing transaction for immediate signing and broadcastring. The transaction
is generated exactly as :meth:`create_tx`.

**Arguments**:

- `options` _CreateTxOptions_ - Options to create a tx
  

**Returns**:

- `Tx` - signed transaction

