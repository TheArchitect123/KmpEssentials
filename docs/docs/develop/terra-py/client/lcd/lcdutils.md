---
sidebar_label: lcdutils
title: terra_sdk.client.lcd.lcdutils
---

## AsyncLCDUtils Objects

```python
class AsyncLCDUtils(BaseAsyncAPI)
```

#### validators\_with\_voting\_power

```python
async def validators_with_voting_power() -> Dict[str, dict]
```

Gets current validators and merges their voting power from the validator set query.

**Returns**:

  Dict[str, dict]: validators with voting power

