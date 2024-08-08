---
sidebar_label: broadcast
title: terra_sdk.core.broadcast
---

Transaction broadcast result data types.

## BlockTxBroadcastResult Objects

```python
@attr.s
class BlockTxBroadcastResult(JSONSerializable)
```

Data object that contains the response result from node after transaction
has been broadcasted with the ``block`` broadcast mode.

#### height

Height at which transaction was included.

#### txhash

Transaction hash.

#### raw\_log

Raw JSON of transaction events.

#### gas\_wanted

Gas requested by the transaction.

#### gas\_used

Actual amount of gas consumed by transaction.

#### logs

List of transaction logs.

#### code

If this is present, the transaction failed.

#### codespace

Error subspace name: used alongside ``code``.

#### timestamp

timestamp

#### is\_tx\_error

```python
def is_tx_error() -> bool
```

Returns whether the transaction failed.

## SyncTxBroadcastResult Objects

```python
@attr.s
class SyncTxBroadcastResult(JSONSerializable)
```

Data object that contains the response result from node after transactionco
has been broadcasted with the ``sync`` broadcast mode.

#### txhash

Transaction hash.

#### raw\_log

Raw JSON of transaction events.

#### code

If this is present, the transaction failed.

#### codespace

Error subspace name: used alongside ``code``.

#### is\_tx\_error

```python
def is_tx_error() -> bool
```

Returns whether the transaction failed.

## AsyncTxBroadcastResult Objects

```python
@attr.s
class AsyncTxBroadcastResult(JSONSerializable)
```

Data object that contains the response result from node after transaction
has been broadcasted with the ``sync`` broadcast mode.

#### txhash

Transaction hash.

#### is\_tx\_error

```python
def is_tx_error(result: Union[BlockTxBroadcastResult, SyncTxBroadcastResult])
```

Returns whether the transaction failed.

