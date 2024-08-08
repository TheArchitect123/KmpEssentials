---
sidebar_label: proposals
title: terra_sdk.core.ibc.proposals.proposals
---

## ClientUpdateProposal Objects

```python
@attr.s
class ClientUpdateProposal(JSONSerializable)
```

Proposal that allows updating IBC clients. If it passes, the substitute
client&#x27;s latest consensus state is copied over to the subject client.

