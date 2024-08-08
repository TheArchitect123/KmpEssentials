---
sidebar_label: proposals
title: terra_sdk.core.params.proposals
---

Params module governance proposal types.

## ParameterChangeProposal Objects

```python
@attr.s
class ParameterChangeProposal(JSONSerializable)
```

Proposal to alter the blockchain parameters. Changes would be effective
as soon as the proposal is passed.

**Arguments**:

- `title` - proposal title
- `description` - proposal description
- `change` _List[ParamChange]_ - list of parameter changes

