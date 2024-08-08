---
sidebar_label: connection
title: terra_sdk.core.ibc.msgs.connection
---

ibc connection module message types.

## MsgConnectionOpenInit Objects

```python
@attr.s
class MsgConnectionOpenInit(Msg)
```

MsgConnectionOpenInit defines the msg sent by an account on Chain A to initialize a connection with Chain B.

## MsgConnectionOpenTry Objects

```python
@attr.s
class MsgConnectionOpenTry(Msg)
```

MsgConnectionOpenTry defines a msg sent by a Relayer to try to open a connection on Chain B.

## MsgConnectionOpenAck Objects

```python
@attr.s
class MsgConnectionOpenAck(Msg)
```

MsgConnectionOpenAck defines a msg sent by a Relayer to Chain A to acknowledge the change of connection state to TRYOPEN on Chain B.

## MsgConnectionOpenConfirm Objects

```python
@attr.s
class MsgConnectionOpenConfirm(Msg)
```

MsgConnectionOpenConfirm defines a msg sent by a Relayer to Chain B to acknowledge the change of connection state to OPEN on Chain A.

