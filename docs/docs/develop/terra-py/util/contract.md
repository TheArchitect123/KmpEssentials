---
sidebar_label: contract
title: terra_sdk.util.contract
---

Useful contract-related functions.

#### read\_file\_as\_b64

```python
def read_file_as_b64(path: Union[str, bytes, int]) -> str
```

Reads a file&#x27;s contents as binary bytes and encodes it in a base64-string.

**Arguments**:

- `path` _Union[str, bytes, int]_ - binary file path
  

**Returns**:

- `str` - file&#x27;s bytes in base64-encoded string

#### get\_code\_id

```python
def get_code_id(tx_result: Union[BlockTxBroadcastResult, TxInfo], msg_index: int = 0) -> str
```

Utility function for extracting the code id from a ``MsgStoreCode`` message.

**Arguments**:

- `tx_result` _BlockTxBroadcastResult_ - broadcast result
- `msg_index` _int, optional_ - index of ``MsgStoreCode`` inside tx. Defaults to 0.
  

**Returns**:

- `str` - extracted code id

#### get\_contract\_address

```python
def get_contract_address(tx_result: Union[BlockTxBroadcastResult, TxInfo], msg_index: int = 0) -> AccAddress
```

Utility function for extracting the contract address from a ``MsgInstantiateContract``
message.

**Arguments**:

- `tx_result` _BlockTxBroadcastResult_ - broadcast result
- `msg_index` _int, optional_ - index of ``MsgInstantiateContract`` inside tx. Defaults to 0.
  

**Returns**:

- `str` - extracted contract address

