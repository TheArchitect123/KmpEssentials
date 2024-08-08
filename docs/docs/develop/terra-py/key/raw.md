---
sidebar_label: raw
title: terra_sdk.key.raw
---

## RawKey Objects

```python
class RawKey(Key)
```

RawKey directly uses a raw (plaintext) private key in memory, and provides
the implementation for signing with ECDSA on curve Secp256k1.

**Arguments**:

- `private_key` _bytes_ - private key in bytes

#### private\_key

Private key, in bytes.

#### from\_hex

```python
@classmethod
def from_hex(cls, private_key_hex: str) -> RawKey
```

Create a new RawKey from a hex-encoded private key string.

**Arguments**:

- `private_key_hex` _str_ - hex-encoded private key

#### sign

```python
def sign(payload: bytes) -> bytes
```

Signs the data payload using ECDSA and curve Secp256k1 with the private key as
the signing key.

**Arguments**:

- `payload` _bytes_ - data to sign

