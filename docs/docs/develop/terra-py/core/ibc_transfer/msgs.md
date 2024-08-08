---
sidebar_label: msgs
title: terra_sdk.core.ibc_transfer.msgs
---

ibc-transfer module message types.

## MsgTransfer Objects

```python
@attr.s
class MsgTransfer(Msg)
```

MsgTransfer defines a msg to transfer fungible tokens (i.e Coins) between ICS20 enabled chains.

**Arguments**:

- `source_port` _str_ - the port on which the packet will be sent
- `source_channel` _str_ - the channel by which the packet will be sent
- `token` _Coin_ - the tokens to be transferred
- `sender` _AccAddress_ - the sender address
- `receiver` _str_ - the recipient address on the destination chain
- `timeout_height` _Height_ - Timeout height relative to the current block height.
  The timeout is disabled when set to 0.
- `timeout_timestamp` _int_ - Timeout timestamp (in nanoseconds) relative to the current block timestamp.
  The timeout is disabled when set to 0.

