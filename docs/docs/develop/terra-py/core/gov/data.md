---
sidebar_label: data
title: terra_sdk.core.gov.data
---

Gov module data types.

## Proposal Objects

```python
@attr.s
class Proposal(JSONSerializable)
```

Contains information about a submitted proposal on the blockchain.

#### proposal\_id

Proposal&#x27;s ID.

#### content

Proposal contents.

#### status

Status of proposal.

#### final\_tally\_result

Final tallied result of the proposal (after vote).

#### submit\_time

Timestamp at which proposal was submitted.

#### deposit\_end\_time

Time at which the deposit period ended, or will end.

#### total\_deposit

Total amount deposited for proposal

#### voting\_start\_time

Time at which voting period started, or will start.

#### voting\_end\_time

Time at which voting period ended, or will end.

