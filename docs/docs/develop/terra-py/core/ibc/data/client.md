---
sidebar_label: client
title: terra_sdk.core.ibc.data.client
---

ibc client module data objects.

## IdentifiedClientState Objects

```python
@attr.s
class IdentifiedClientState(JSONSerializable)
```

IdentifiedClientState defines a client state with an additional client identifier field.

## ConsensusStateWithHeight Objects

```python
@attr.s
class ConsensusStateWithHeight(JSONSerializable)
```

ConsensusStateWithHeight defines a consensus state with an additional height field.

## ClientConsensusStates Objects

```python
@attr.s
class ClientConsensusStates(JSONSerializable)
```

ClientConsensusStates defines all the stored consensus states for a given client.

## Params Objects

```python
@attr.s
class Params(JSONSerializable)
```

Params defines the set of IBC light client parameters.

