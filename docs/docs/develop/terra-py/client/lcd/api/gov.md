---
sidebar_label: gov
title: terra_sdk.client.lcd.api.gov
---

## AsyncGovAPI Objects

```python
class AsyncGovAPI(BaseAsyncAPI)
```

#### proposals

```python
async def proposals(options: dict = {}, params: Optional[APIParams] = None) -> [List[Proposal], dict]
```

Fetches all proposals.

**Arguments**:

- `options` _dict, optional_ - dictionary containing options. Defaults to {}. you can use one or more below:
- `"proposal_status"` - terra_sdk.core.gov.ProposalStatus (int)
- `"voter"` - voter address (str),
- `"depositor"` - depositor address(str)
- `params` _APIParams, optional_ - additional params for the API like pagination
  

**Returns**:

- `List[Proposal]` - proposals

#### proposal

```python
async def proposal(proposal_id: int) -> Proposal
```

Fetches a single proposal by id.

**Arguments**:

- `proposal_id` _int_ - proposal ID
  

**Returns**:

- `Proposal` - proposal

#### proposer

```python
async def proposer(proposal_id: int) -> str
```

Fetches the proposer of a proposal.

**Arguments**:

- `proposal_id` _int_ - proposal ID
  

**Returns**:

- `str` - proposal&#x27;s proposer, None if proposal is not exist

#### deposits

```python
async def deposits(proposal_id: int, params: Optional[APIParams] = None)
```

Fetches the deposit information about a proposal.

**Arguments**:

- `proposal_id` _int_ - proposal ID
- `params` _APIParams, optional_ - additional params for the API like pagination

#### votes

```python
async def votes(proposal_id: int, params: Optional[APIParams] = None)
```

Fetches the votes for a proposal.

**Arguments**:

- `proposal_id` _int_ - proposal ID
- `params` _APIParams, optional_ - additional params for the API like pagination

#### tally

```python
async def tally(proposal_id: int)
```

Fetches the tally for a proposal.

**Arguments**:

- `proposal_id` _int_ - proposal ID

#### deposit\_parameters

```python
async def deposit_parameters() -> dict
```

Fetches the Gov module&#x27;s deposit parameters.

**Returns**:

- `dict` - deposit parameters

#### voting\_parameters

```python
async def voting_parameters() -> dict
```

Fetches the Gov module&#x27;s voting parameters.

**Returns**:

- `dict` - voting parameters

#### tally\_parameters

```python
async def tally_parameters() -> dict
```

Fetches the Gov module&#x27;s tally parameters.

**Returns**:

- `dict` - tally parameters

#### parameters

```python
async def parameters() -> dict
```

Fetches the Gov module&#x27;s parameters.

**Returns**:

- `dict` - Gov module parameters

