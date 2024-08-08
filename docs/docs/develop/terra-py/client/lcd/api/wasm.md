---
sidebar_label: wasm
title: terra_sdk.client.lcd.api.wasm
---

## AsyncWasmAPI Objects

```python
class AsyncWasmAPI(BaseAsyncAPI)
```

#### code\_info

```python
async def code_info(code_id: int, params: Optional[APIParams] = None) -> dict
```

Fetches information about an uploaded code.

**Arguments**:

- `code_id` _int_ - code ID
- `params` _APIParams_ - optional parameters
  

**Returns**:

- `dict` - code information

#### contract\_history

```python
async def contract_history(contract_address: str, params: Optional[APIParams] = None) -> List[HistoryEntry]
```

Fetches contract history.

**Arguments**:

- `contract_address` _str_ - contract address
- `params` _APIParams_ - optional parameters
  

**Returns**:

- `List[HistoryEntry]` - contract histories

#### contract\_info

```python
async def contract_info(contract_address: str, params: Optional[APIParams] = None) -> dict
```

Fetches information about an instantiated contract.

**Arguments**:

- `contract_address` _str_ - contract address
- `params` _APIParams_ - optional parameters
  

**Returns**:

- `dict` - contract information

#### contract\_query

```python
async def contract_query(contract_address: str, query: Union[dict, str], params: Optional[APIParams] = None) -> Any
```

Runs a QueryMsg on a contract.

**Arguments**:

- `contract_address` _str_ - contract address
- `query` _dict_ - QueryMsg to run
- `params` _APIParams_ - optional parameters
  

**Returns**:

- `Any` - results of query

#### pinned\_codes

```python
async def pinned_codes(params: Optional[APIParams] = None) -> dict
```

Fetches the Wasm module pinned codes.

**Arguments**:

- `params` _APIParams_ - optional parameters
  

**Returns**:

- `dict` - Wasm module pinned codes

