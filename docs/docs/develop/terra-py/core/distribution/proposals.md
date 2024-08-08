---
sidebar_label: proposals
title: terra_sdk.core.distribution.proposals
---

Distribution module governance proposal types.

## CommunityPoolSpendProposal Objects

```python
@attr.s
class CommunityPoolSpendProposal(JSONSerializable)
```

Proposal for allocating funds from the community pool to an address.

**Arguments**:

- `title` - proposal title
- `description` - proposal description
- `recipient` - designated recipient of funds if proposal passes
- `amount` _Coins_ - amount to spend from community pool

