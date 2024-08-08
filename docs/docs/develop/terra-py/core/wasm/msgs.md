---
sidebar_label: msgs
title: terra_sdk.core.wasm.msgs
---

Wasm module messages.

## MsgStoreCode Objects

```python
@attr.s
class MsgStoreCode(Msg)
```

Upload a new smart contract WASM binary to the blockchain.

**Arguments**:

- `sender` - address of sender
- `wasm_byte_code` - base64-encoded string containing bytecode
- `instantiate_permission` - access control to apply on contract creation, optional

## MsgInstantiateContract Objects

```python
@attr.s
class MsgInstantiateContract(Msg)
```

Creates a new instance of a smart contract from existing code on the blockchain.

**Arguments**:

- `sender` - address of sender
- `admin` - address of contract admin
- `code_id` _int_ - code ID to use for instantiation
- `label` _str_ - label for the contract.
- `msg` _dict|str_ - InitMsg to initialize contract
- `funds` _Coins_ - initial amount of coins to be sent to contract

## MsgExecuteContract Objects

```python
@attr.s
class MsgExecuteContract(Msg)
```

Execute a state-mutating function on a smart contract.

**Arguments**:

- `sender` - address of sender
- `contract` - address of contract to execute function on
- `msg` _dict|str_ - ExecuteMsg to pass
- `coins` - coins to be sent, if needed by contract to execute.
  Defaults to empty ``Coins()``

## MsgMigrateContract Objects

```python
@attr.s
class MsgMigrateContract(Msg)
```

Migrate the contract to a different code ID.

**Arguments**:

- `sender` - address of contract admin
- `contract` - address of contract to migrate
- `code_id` _int_ - new code ID to migrate to
- `msg` _dict|str_ - MigrateMsg to execute

## MsgUpdateAdmin Objects

```python
@attr.s
class MsgUpdateAdmin(Msg)
```

Update a smart contract&#x27;s admin.

**Arguments**:

- `sender` - address of current admin (sender)
- `new_admin` - address of new admin
- `contract` - address of contract to change

## MsgClearAdmin Objects

```python
@attr.s
class MsgClearAdmin(Msg)
```

Clears the contract&#x27;s admin field.

**Arguments**:

- `admin` - address of current admin (sender)
- `contract` - address of contract to change

