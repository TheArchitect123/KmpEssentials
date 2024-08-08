---
sidebar_label: lcdclient
title: terra_sdk.client.lcd.lcdclient
---

## AsyncLCDClient Objects

```python
class AsyncLCDClient()
```

#### wallet

```python
def wallet(key: Key) -> AsyncWallet
```

Creates a :class:`AsyncWallet` object from a key.

**Arguments**:

- `key` _Key_ - key implementation

## LCDClient Objects

```python
class LCDClient(AsyncLCDClient)
```

An object representing a connection to a node running the Terra LCD server.

#### url

URL endpoint of LCD server.

#### chain\_id

Chain ID of blockchain network connecting to.

#### gas\_prices

Gas prices to use for automatic fee estimation.

#### gas\_adjustment

Gas adjustment factor for automatic fee estimation.

#### last\_request\_height

Height of response of last-made made LCD request.

#### auth

:class:`AuthAPI&lt;terra_sdk.client.lcd.api.auth.AuthAPI&gt;`.

#### bank

:class:`BankAPI&lt;terra_sdk.client.lcd.api.bank.BankAPI&gt;`.

#### distribution

:class:`DistributionAPI&lt;terra_sdk.client.lcd.api.distribution.DistributionAPI&gt;`.

#### gov

:class:`GovAPI&lt;terra_sdk.client.lcd.api.gov.GovAPI&gt;`.

#### feegrant

:class:`FeeGrant&lt;terra_sdk.client.lcd.api.feegrant.FeeGrantAPI&gt;`.

#### mint

:class:`MintAPI&lt;terra_sdk.client.lcd.api.mint.MintAPI&gt;`.

#### authz

:class:`AuthzAPI&lt;terra_sdk.client.lcd.api.authz.AuthzAPI&gt;`.

#### slashing

:class:`SlashingAPI&lt;terra_sdk.client.lcd.api.slashing.SlashingAPI&gt;`.

#### staking

:class:`StakingAPI&lt;terra_sdk.client.lcd.api.staking.StakingAPI&gt;`.

#### tendermint

:class:`TendermintAPI&lt;terra_sdk.client.lcd.api.tendermint.TendermintAPI&gt;`.

#### wasm

:class:`WasmAPI&lt;terra_sdk.client.lcd.api.wasm.WasmAPI&gt;`.

#### tx

:class:`TxAPI&lt;terra_sdk.client.lcd.api.tx.TxAPI&gt;`.

#### ibc

:class:`IbcAPI&lt;terra_sdk.client.lcd.api.ibc.IbcAPI&gt;`.

#### ibc\_transfer

:class:`IbcTransferAPI&lt;terra_sdk.client.lcd.api.ibc_transfer.IbcTransferAPI&gt;`.

#### wallet

```python
def wallet(key: Key) -> Wallet
```

Creates a :class:`Wallet` object from a key for easy transaction creating and
signing.

**Arguments**:

- `key` _Key_ - key implementation

