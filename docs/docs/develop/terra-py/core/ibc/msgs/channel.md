---
sidebar_label: channel
title: terra_sdk.core.ibc.msgs.channel
---

ibc connection module message types.

## MsgChannelOpenInit Objects

```python
@attr.s
class MsgChannelOpenInit(Msg)
```

MsgChannelOpenInit defines an sdk.Msg to initialize a channel handshake. It
is called by a relayer on Chain A.

## MsgChannelOpenTry Objects

```python
@attr.s
class MsgChannelOpenTry(Msg)
```

MsgChannelOpenInit defines a msg sent by a Relayer to try to open a channel
on Chain B.

## MsgChannelOpenAck Objects

```python
class MsgChannelOpenAck(Msg)
```

MsgChannelOpenAck defines a msg sent by a Relayer to Chain A to acknowledge
the change of channel state to TRYOPEN on Chain B.

## MsgChannelOpenConfirm Objects

```python
@attr.s
class MsgChannelOpenConfirm(Msg)
```

MsgChannelOpenConfirm defines a msg sent by a Relayer to Chain B to
acknowledge the change of channel state to OPEN on Chain A.

## MsgChannelCloseConfirm Objects

```python
@attr.s
class MsgChannelCloseConfirm(Msg)
```

MsgChannelCloseConfirm defines a msg sent by a Relayer to Chain B to
acknowledge the change of channel state to CLOSED on Chain A.

## MsgRecvPacket Objects

```python
@attr.s
class MsgRecvPacket(Msg)
```

MsgRecvPacket receives incoming IBC packet

## MsgTimeout Objects

```python
@attr.s
class MsgTimeout(Msg)
```

MsgTimeout receives timed-out packet

## MsgAcknowledgement Objects

```python
@attr.s
class MsgAcknowledgement(Msg)
```

MsgAcknowledgement receives incoming IBC acknowledgement

