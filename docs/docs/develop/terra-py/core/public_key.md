---
sidebar_label: public_key
title: terra_sdk.core.public_key
---

## PublicKey Objects

```python
class PublicKey(JSONSerializable,  ABC)
```

Data object holding the public key component of an account or signature.

## SimplePublicKey Objects

```python
@attr.s
class SimplePublicKey(PublicKey)
```

Data object holding the SIMPLE public key component of an account or signature.

#### type\_url

Normal signature public key type.

## ValConsPubKey Objects

```python
@attr.s
class ValConsPubKey(PublicKey)
```

Data object holding the public key component of a validator&#x27;s account or signature.

#### type\_url

an ed25519 tendermint public key type.

## LegacyAminoMultisigPublicKey Objects

```python
@attr.s
class LegacyAminoMultisigPublicKey(PublicKey)
```

Data object holding the Legacy Amino-typed public key component of an account or signature.

#### type\_url

Multisig public key type.

