---
sidebar_label: bech32
title: terra_sdk.core.bech32
---

Special Bech32 String Types

#### is\_acc\_address

```python
def is_acc_address(data: str) -> bool
```

Checks whether the given string is a properly formatted Terra account address.

**Arguments**:

- `data` _str_ - string to check
  

**Returns**:

- `bool` - whether the string is a proper account address

#### to\_acc\_address

```python
def to_acc_address(data: ValAddress) -> AccAddress
```

Converts a validator operator address into an account address.

**Arguments**:

- `data` _ValAddress_ - validator operator address
  

**Raises**:

- `ValueError` - if provided string is not Bech32
  

**Returns**:

- `AccAddress` - account address

#### is\_val\_address

```python
def is_val_address(data: str) -> bool
```

Checks whether the given string is a properly formatted Terra validator operator
address.

**Arguments**:

- `data` _str_ - string to check
  

**Returns**:

- `bool` - whether the string is a proper validator address

#### to\_val\_address

```python
def to_val_address(data: AccAddress) -> ValAddress
```

Converts an account address into a validator operator address.

**Arguments**:

- `data` _AccAddress_ - account address
  

**Raises**:

- `ValueError` - if provided string is not Bech32
  

**Returns**:

- `ValAddress` - validator operator address

#### is\_acc\_pubkey

```python
def is_acc_pubkey(data: str) -> bool
```

Checks whether the provided string is a properly formatted Terra account pubkey.

**Arguments**:

- `data` _str_ - string to check
  

**Returns**:

- `bool` - whether string is account pubkey

#### to\_acc\_pubkey

```python
def to_acc_pubkey(data: ValPubKey) -> AccPubKey
```

Converts a validator pubkey into an account pubkey.

**Arguments**:

- `data` _ValPubKey_ - validator pubkey
  

**Raises**:

- `ValueError` - if provided string is not Bech32
  

**Returns**:

- `AccPubKey` - account pubkey

#### is\_val\_pubkey

```python
def is_val_pubkey(data: str) -> bool
```

Checks whether provided string is a properly formatted Terra validator pubkey.

**Arguments**:

- `data` _str_ - string to check
  

**Returns**:

- `bool` - whether string is validator pubkey

#### to\_val\_pubkey

```python
def to_val_pubkey(data: AccPubKey) -> ValPubKey
```

Converts an account pubkey into a validator pubkey.

**Arguments**:

- `data` _AccPubKey_ - account pubkey
  

**Raises**:

- `ValueError` - if provided string is not Bech32
  

**Returns**:

- `ValPubKey` - validator pubkey

#### is\_valcons\_pubkey

```python
def is_valcons_pubkey(data: str) -> bool
```

Checks whether provided string is a properly formatted Terra validator consensus
pubkey.

**Arguments**:

- `data` _str_ - string to check
  

**Returns**:

- `bool` - whether string is validator consensus pubkey

