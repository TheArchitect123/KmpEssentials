---
sidebar_label: proposals
title: terra_sdk.core.wasm.proposals
---

wasm module governance proposal types.

## ClearAdminProposal Objects

```python
@attr.s
class ClearAdminProposal(JSONSerializable)
```

**Arguments**:

  title : a short summary
  description : a human readable text
  contract : the address of the smart contract

## ExecuteContractProposal Objects

```python
@attr.s
class ExecuteContractProposal(JSONSerializable)
```

**Arguments**:

  title : a short summary
  description : a human readable text
  run_as : contract user
  contract : the address of the smart contract
  execute_msg : HandleMsg to pass as arguments for contract invocation
  coins : coins to be sent to contract

## InstantiateContractProposal Objects

```python
@attr.s
class InstantiateContractProposal(JSONSerializable)
```

**Arguments**:

  title : a short summary
  description : a human readable text
  run_as : contract user
  admin : an optional contract admin address who can migrate the contract, put empty string to disable migration
  code_id : the reference to the stored WASM code
  init_msg : json encoded message to be passed to the contract on instantiation
  init_coins : transferred to the contract on execution
  label : label for the contract. v2 supported only

## MigrateContractProposal Objects

```python
@attr.s
class MigrateContractProposal(JSONSerializable)
```

**Arguments**:

  title : a short summary
  description : a human readable text
  contract : contract address to be migrated from
  new_code_id : reference to the new code on the blockchain
  migrate_msg : JSON message to configure the migrate state of the contract

## PinCodesProposal Objects

```python
@attr.s
class PinCodesProposal(JSONSerializable)
```

**Arguments**:

  title : a short summary
  description : a human readable text
  code_ids : the address of the smart code_ids

## StoreCodeProposal Objects

```python
@attr.s
class StoreCodeProposal(JSONSerializable)
```

**Arguments**:

  title : a short summary
  description : a human readable text
  run_as : the address that is passed to the contract&#x27;s environment as sender
  wasm_byte_code : can be raw or gzip compressed
  instantiate_permission : to apply on contract creation, optional

## SudoContractProposal Objects

```python
@attr.s
class SudoContractProposal(JSONSerializable)
```

**Arguments**:

  title : a short summary
  description : a human readable text
  contract :  contract address to be migrated from
  msg : JSON message to configure the migrate state of the contract

## UnpinCodesProposal Objects

```python
@attr.s
class UnpinCodesProposal(JSONSerializable)
```

**Arguments**:

  title : a short summary
  description : a human readable text
  code_ids : the address of the smart code_ids

## UpdateAdminProposal Objects

```python
@attr.s
class UpdateAdminProposal(JSONSerializable)
```

**Arguments**:

  title : a short summary
  description : a human readable text
  contract : the address of the smart contract
  new_admin : address to be set

## UpdateInstantiateConfigProposal Objects

```python
@attr.s
class UpdateInstantiateConfigProposal(JSONSerializable)
```

**Arguments**:

  title : a short summary
  description : a human readable text
  access_config_updates : the address of the smart access_config_updates

