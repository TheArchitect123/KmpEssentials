---
sidebar_label: msgs
title: terra_sdk.core.authz.msgs
---

Authz module message types.

## MsgExecAuthorized Objects

```python
@attr.s
class MsgExecAuthorized(Msg)
```

Execute a set of messages, exercising an existing authorization.

**Arguments**:

- `grantee` - grantee account (submitting on behalf of granter)
- `msg` _List[Msg]_ - list of messages to execute using authorization grant

## MsgGrantAuthorization Objects

```python
@attr.s
class MsgGrantAuthorization(Msg)
```

Grant an authorization to ``grantee`` to call messages on behalf of ``granter``.

**Arguments**:

- `granter` - account granting authorization
- `grantee` - account receiving authorization
- `grant` - pair of authorization, expiration

## MsgRevokeAuthorization Objects

```python
@attr.s
class MsgRevokeAuthorization(Msg)
```

Remove existing authorization grant of the specified message type.

**Arguments**:

- `granter` - account removing authorization
- `grantee` - account having authorization removed
- `msg_type_url` - type of message to remove authorization for

