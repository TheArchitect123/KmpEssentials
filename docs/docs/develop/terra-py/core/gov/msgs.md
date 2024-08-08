---
sidebar_label: msgs
title: terra_sdk.core.gov.msgs
---

Gov module message types.

## MsgSubmitProposal Objects

```python
@attr.s
class MsgSubmitProposal(Msg)
```

Submit the attached proposal with an initial deposit.

**Arguments**:

- `content` _Content_ - type of proposal
- `initial_deposit` _Coins_ - initial deposit for proposal made by proposer
- `proposer` _AccAddress_ - proposal submitter

## MsgDeposit Objects

```python
@attr.s
class MsgDeposit(Msg)
```

Deposit funds for an active deposit-stage proposal.

**Arguments**:

- `proposal_id` _int_ - proposal number to deposit for
- `depositor` _AccAddress_ - account making deposit
- `amount` _Coins_ - amount to deposit

## MsgVote Objects

```python
@attr.s
class MsgVote(Msg)
```

Vote for an active voting-stage proposal.

**Arguments**:

- `proposal_id` _int_ - proposal to vote for
- `voter` _AccAddress_ - account casting vote
- `option` _VoteOption_ - vote option (must be one of: :data:`MsgVote.ABSTAIN`, :data:`MsgVote.YES`, :data:`MsgVote.NO`, or :data:`MsgVote.NO_WITH_VETO`),

#### EMPTY

Encodes an empty vote option.

#### option

```
def _check_option(self, attribute, value):
    possible_options = [
        self.EMPTY,
        self.YES,
        self.ABSTAIN,
        self.NO,
        self.NO_WITH_VETO,
    ]
    if value not in possible_options:
        raise TypeError(
            f"incorrect value for option: {value}, must be one of: {possible_options}";
        )
```

