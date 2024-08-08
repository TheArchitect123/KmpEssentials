---
sidebar_label: proposals
title: terra_sdk.core.gov.proposals
---

Gov module governance proposal types.

## TextProposal Objects

```python
@attr.s
class TextProposal(JSONSerializable)
```

Generic proposal type with only title and description that does nothing if
passed. Primarily used for assessing the community sentiment around the proposal.

**Arguments**:

- `title` - proposal title
- `description` - proposal description

