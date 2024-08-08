---
sidebar_label: mnemonic
title: terra_sdk.key.mnemonic
---

## MnemonicKey Objects

```python
class MnemonicKey(RawKey)
```

A MnemonicKey derives a private key using a BIP39 mnemonic seed phrase, and provides key-derivation options based on the BIP44 HD path standard.

.. note:: You can change ``coin_type`` to 118 to derive the key for a legacy Terra
wallet (shares ``coin_type`` with ATOM).

**Arguments**:

- `mnemonic` _str, optional_ - space-separated mnemonic seed phrase. If not provided,
  a 24-word mnemonic will be generated.
- `account` _int, optional_ - HD path parameter - account number.
- `index` _int, optional_ - HD path parameter - account index.
- `coin_type` _int, optional_ - HD path parameter - coin type.

#### mnemonic

Mnemonic key phrase associated with the account (space-separated).

#### account

HD path parameter: account number.

#### index

HD path parameter: account index.

#### coin\_type

HD path parameter: coin type

#### hd\_path

```python
@property
def hd_path() -> str
```

Returns the BIP32 HD path for key-derivation:

``m/44&#x27;/COIN_TYPE&#x27;/ACCOUNT&#x27;/0/INDEX&#x27;``

**Returns**:

- `str` - full BIP32 HD path

