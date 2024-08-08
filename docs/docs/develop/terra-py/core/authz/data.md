---
sidebar_label: data
title: terra_sdk.core.authz.data
---

Authz module data types.

## Authorization Objects

```python
class Authorization(BaseTerraData)
```

Base class for authorization types.

## SendAuthorization Objects

```python
@attr.s
class SendAuthorization(Authorization)
```

Type of :class:`Authorization` for :class:`MsgSend&lt;terra_sdk.core.bank.msgs.MsgSend&gt;`,
which can be parameterized by setting a ``spend_limit`` allowance for the grantee.

**Arguments**:

- `spend_limit` _Coins.Input_ - coins representing allowance of grant

## GenericAuthorization Objects

```python
@attr.s
class GenericAuthorization(Authorization)
```

Generic type of :class:`Authorization`, specifying the type of message to allow.

**Arguments**:

- `msg` - type of message allowed by authorization

## AuthorizationGrant Objects

```python
@attr.s
class AuthorizationGrant(JSONSerializable)
```

Contains information about an existing granted authorization between two users.

#### authorization

Grant authorization details.

#### expiration

Grant expiration.

