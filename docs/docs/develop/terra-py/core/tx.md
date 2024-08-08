---
sidebar_label: tx
title: terra_sdk.core.tx
---

Data objects pertaining to building, signing, and parsing Transactions.

## Tx Objects

```python
@attr.s
class Tx(JSONSerializable)
```

Data structure for a transaction which can be broadcasted.

**Arguments**:

- `body` _TxBody_ - the processable content of the transaction
- `auth_info` _AuthInfo_ - the authorization related content of the transaction
- `signatures` _List[bytes]_ - signatures is a list of signatures that matches the length and order of body and auth_info

## TxBody Objects

```python
@attr.s
class TxBody(JSONSerializable)
```

Body of a transaction.

**Arguments**:

- `messages` - list of messages to include in transaction
- `memo` - transaction memo
  timeout_height:

## AuthInfo Objects

```python
@attr.s
class AuthInfo(JSONSerializable)
```

AuthInfo

**Arguments**:

- `signer_infos` - information of the signers
- `fee` - Fee

## SignerInfo Objects

```python
@attr.s
class SignerInfo(JSONSerializable)
```

SignerInfo

**Arguments**:

  public_key (PublicKey)
  mode_info (ModeInfo)
  sequence (int)

## TxLog Objects

```python
@attr.s
class TxLog(JSONSerializable)
```

Object containing the events of a transaction that is automatically generated when
:class:`TxInfo` or :class:`BlockTxBroadcastResult` objects are read.

#### msg\_index

Number of the message inside the transaction that it was included in.

#### log

This field may be populated with details of the message&#x27;s error, if any.

#### events

Raw event log data

#### events\_by\_type

Event log data, re-indexed by event type name and attribute type.

For instance, the event type may be: ``store_code`` and an attribute key could be
``code_id``.

&gt;&gt;&gt; logs[0].events_by_type[&quot;&lt;event-type&gt;&quot;][&quot;&lt;attribute-key&gt;&quot;]
[&#x27;&lt;attribute-value&gt;&#x27;, &#x27;&lt;attribute-value2&gt;&#x27;]

## TxInfo Objects

```python
@attr.s
class TxInfo(JSONSerializable)
```

Holds information pertaining to a transaction which has been included in a block
on the blockchain.

.. note::
    Users are not expected to create this object directly. It is returned by
    :meth:`TxAPI.tx_info()&lt;terra_sdk.client.lcd.api.tx.TxAPI.tx_info&gt;`

#### height

Block height at which transaction was included.

#### txhash

Transaction hash.

#### rawlog

Event log information as a raw JSON-string.

#### logs

Event log information.

#### gas\_wanted

Gas requested by transaction.

#### gas\_used

Actual gas amount used.

#### tx

Transaction object.

#### timestamp

Time at which transaction was included.

#### code

If this field is not ``None``, the transaction failed at ``DeliverTx`` stage.

#### codespace

Error subspace (used alongside ``code``).

