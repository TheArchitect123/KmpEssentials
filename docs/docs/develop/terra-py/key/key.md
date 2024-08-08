---
sidebar_label: key
title: terra_sdk.key.key
---

## Key Objects

```python
class Key()
```

Abstract Key interface, representing an agent with transaction-signing capabilities.

**Arguments**:

- `public_key` _Optional[bytes]_ - compressed public key bytes,

#### public\_key

Compressed public key bytes, used to derive :data:`raw_address` and :data:`raw_pubkey`.

#### raw\_address

Raw Bech32 words of address, used to derive associated account and validator
operator addresses.

#### raw\_pubkey

Raw Bech32 words of pubkey, used to derive associated account and validator
pubkeys.

#### sign

```python
@abc.abstractmethod
def sign(payload: bytes) -> bytes
```

Signs the data payload. An implementation of Key is expected to override this method.

**Arguments**:

- `payload` _bytes_ - arbitrary data payload
  

**Raises**:

- `NotImplementedError` - if not implemented
  

**Returns**:

- `bytes` - signed payload

#### acc\_address

```python
@property
def acc_address() -> AccAddress
```

Terra Bech32 account address. Default derivation via :data:`public_key` is provided.

**Raises**:

- `ValueError` - if Key was not initialized with proper public key
  

**Returns**:

- `AccAddress` - account address

#### val\_address

```python
@property
def val_address() -> ValAddress
```

Terra Bech32 validator operator address. Default derivation via :data:`public_key` is provided.

**Raises**:

- `ValueError` - if Key was not initialized with proper public key
  

**Returns**:

- `ValAddress` - validator operator address

#### acc\_pubkey

```python
@property
def acc_pubkey() -> AccPubKey
```

Terra Bech32 account pubkey. Default derivation via :data:`public_key` is provided.

**Raises**:

- `ValueError` - if Key was not initialized with proper public key
  

**Returns**:

- `AccPubKey` - account pubkey

#### val\_pubkey

```python
@property
def val_pubkey() -> ValPubKey
```

Terra Bech32 validator pubkey. Default derivation via ``public_key`` is provided.

**Raises**:

- `ValueError` - if Key was not initialized with proper public key
  

**Returns**:

- `ValPubKey` - validator pubkey

#### create\_signature

```python
def create_signature(sign_doc: SignDoc) -> SignatureV2
```

Signs the transaction with the signing algorithm provided by this Key implementation,
and outputs the signature. The signature is only returned, and must be manually added to
the ``signatures`` field of an :class:`Tx`.

**Arguments**:

- `sign_doc` _SignDoc_ - unsigned transaction
  

**Raises**:

- `ValueError` - if missing ``public_key``
  

**Returns**:

- `SignatureV2` - signature object

#### sign\_tx

```python
def sign_tx(tx: Tx, options: SignOptions) -> Tx
```

Signs the transaction with the signing algorithm provided by this Key implementation,
and creates a ready-to-broadcast :class:`Tx` object with the signature applied.

**Arguments**:

- `tx` _Tx_ - unsigned transaction
- `options` _SignOptions_ - options for signing
  

**Returns**:

- `Tx` - ready-to-broadcast transaction object

