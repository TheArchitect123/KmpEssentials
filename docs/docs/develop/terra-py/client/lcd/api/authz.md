---
sidebar_label: authz
title: terra_sdk.client.lcd.api.authz
---

## AsyncAuthzAPI Objects

```python
class AsyncAuthzAPI(BaseAsyncAPI)
```

#### grants

```python
async def grants(granter: AccAddress, grantee: AccAddress, msg_type: Optional[str] = None, params: Optional[APIParams] = None) -> List[AuthorizationGrant]
```

Fetches current active message authorization grants.

**Arguments**:

- `granter` _AccAddress_ - granter account address
- `grantee` _AccAddress_ - grantee account address
- `msg_type` _str, optional_ - message type.
- `params` _APIParams, optional_ - additional params for the API like pagination
  

**Returns**:

- `List[AuthorizationGrant]` - message authorization grants matching criteria

#### granter

```python
async def granter(granter: AccAddress, params: Optional[APIParams] = None) -> List[AuthorizationGrant]
```

Fetches list of `GrantAuthorization` granted by granter.

**Arguments**:

- `granter` _AccAddress_ - granter account address
- `params` _APIParams, optional_ - additional params for the API like pagination
  

**Returns**:

- `List[AuthorizationGrant]` - message authorization grants matching criteria

#### grantee

```python
async def grantee(grantee: AccAddress, params: Optional[APIParams] = None) -> List[AuthorizationGrant]
```

Fetches list of `GrantAuthorization` by grantee.

**Arguments**:

- `grantee` _AccAddress_ - grantee account address
- `params` _APIParams, optional_ - additional params for the API like pagination
  

**Returns**:

- `List[AuthorizationGrant]` - message authorization grants matching criteria

