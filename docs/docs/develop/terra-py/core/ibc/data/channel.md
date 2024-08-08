---
sidebar_label: channel
title: terra_sdk.core.ibc.data.channel
---

ibc channel module data objects.

## Counterparty Objects

```python
@attr.s
class Counterparty(JSONSerializable)
```

Counterparty defines a channel end counterparty

## Channel Objects

```python
@attr.s
class Channel(JSONSerializable)
```

Channel defines pipeline for exactly-once packet delivery between specific
modules on separate blockchains, which has at least one end capable of
sending packets and one end capable of receiving packets.

## Packet Objects

```python
@attr.s
class Packet(JSONSerializable)
```

Packet defines a type that carries data across different chains through IBC

