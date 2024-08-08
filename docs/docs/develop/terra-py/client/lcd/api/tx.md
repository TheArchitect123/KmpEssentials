---
sidebar_label: tx
title: terra_sdk.client.lcd.api.tx
---

## SignerOptions Objects

```python
@attr.s
class SignerOptions()
```

SignerOptions specifies infomations about signers

**Arguments**:

- `address` _AccAddress_ - address of the signer
- `sequence` _int, optional_ - nonce of the messages from the signer
- `public_key` _PublicKey, optional_ - signer&#x27;s PublicKey

## CreateTxOptions Objects

```python
@attr.s
class CreateTxOptions()
```

**Arguments**:

- `msgs` _List[Msg]_ - list of messages to include
- `fee` _Optional[Fee], optional_ - transaction fee. If ``None``, will be estimated.
  See more on `fee estimation`_.
- `memo` _str, optional_ - optional short string to include with transaction.
- `gas` _str, optional_ - gas limit to set per-transaction; set to &quot;auto&quot; to calculate sufficient gas automatically
- `gas_prices` _Coins.Input, optional_ - gas prices for fee estimation.
- `gas_adjustment` _Numeric.Input, optional_ - gas adjustment for fee estimation.
- `fee_denoms` _List[str], optional_ - list of denoms to use for fee after estimation.
- `account_number` _int, optional_ - account number (overrides blockchain query if
  provided)
- `sequence` _int, optional_ - sequence (overrides blockchain qu ery if provided)
- `timeout_height` _int, optional_ - specifies a block timeout height to prevent the tx from being committed past a certain height.
- `sign_mode` - (SignMode, optional): SignMode.SIGN_MODE_DIRECT by default. multisig needs SignMode.SIGN_MODE_LEGACY_AMINO_JSON.

## AsyncTxAPI Objects

```python
class AsyncTxAPI(BaseAsyncAPI)
```

#### tx\_info

```python
async def tx_info(tx_hash: str) -> TxInfo
```

Fetches information for an included transaction given a tx hash.

**Arguments**:

- `tx_hash` _str_ - hash of transaction to lookup
  

**Returns**:

- `TxInfo` - transaction info

#### create

```python
async def create(signers: List[SignerOptions], options: CreateTxOptions) -> Tx
```

Create a new unsigned transaction, with helpful utilities such as lookup of
chain ID, account number, sequence and fee estimation.

**Arguments**:

- `signers` _List[SignerOptions]_ - options about signers
- `options` _CreateTxOptions_ - options about creating a tx
  

**Returns**:

- `Tx` - unsigned tx

#### estimate\_fee

```python
async def estimate_fee(signers: List[SignerOptions], options: CreateTxOptions) -> Fee
```

Estimates the proper fee to apply by simulating it within the node.

**Arguments**:

- `signers` _[SignerOptions]_ - signers
- `options` _CreateTxOptions_ - transaction info to estimate fee
  

**Returns**:

- `Fee` - estimated fee

#### encode

```python
async def encode(tx: Tx) -> str
```

Encode a Tx to base64 encoded proto string

#### decode

```python
async def decode(tx: str) -> Tx
```

Decode base64 encoded proto string to a Tx

#### hash

```python
async def hash(tx: Tx) -> str
```

Compute hash for a transaction.

**Arguments**:

- `tx` _Tx_ - transaction to hash
  

**Returns**:

- `str` - transaction hash

#### broadcast\_sync

```python
async def broadcast_sync(tx: Tx, options: BroadcastOptions = None) -> SyncTxBroadcastResult
```

Broadcasts a transaction using the ``sync`` broadcast mode.

**Arguments**:

- `tx` _Tx_ - transaction to broadcast
- `options` _BroadcastOptions_ - broacast options, optional
  

**Returns**:

- `SyncTxBroadcastResult` - result

#### broadcast\_async

```python
async def broadcast_async(tx: Tx, options: BroadcastOptions = None) -> AsyncTxBroadcastResult
```

Broadcasts a transaction using the ``async`` broadcast mode.

**Arguments**:

- `tx` _Tx_ - transaction to broadcast
- `options` _BroadcastOptions_ - broacast options, optional
  

**Returns**:

- `AsyncTxBroadcastResult` - result

#### broadcast

```python
async def broadcast(tx: Tx, options: BroadcastOptions = None) -> BlockTxBroadcastResult
```

Broadcasts a transaction using the ``block`` broadcast mode.

**Arguments**:

- `tx` _Tx_ - transaction to broadcast
- `options` _BroadcastOptions_ - broacast options, optional
  

**Returns**:

- `BlockTxBroadcastResult` - result

#### search

```python
async def search(events: List[list], params: Optional[APIParams] = None) -> dict
```

Searches for transactions given criteria.

**Arguments**:

- `events` _dict_ - dictionary containing options
- `params` _APIParams_ - optional parameters
  

**Returns**:

- `dict` - transaction search results

#### tx\_infos\_by\_height

```python
async def tx_infos_by_height(height: Optional[int] = None) -> List[TxInfo]
```

Fetches information for an included transaction given block height or latest

**Arguments**:

- `height` _int, optional_ - height to lookup. latest if height is None.
  

**Returns**:

- `List[TxInfo]` - transaction info

