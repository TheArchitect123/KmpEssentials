---
sidebar_label: localterra
title: terra_sdk.client.localterra
---

## AsyncLocalTerra Objects

```python
class AsyncLocalTerra(AsyncLCDClient)
```

An :class:`AsyncLCDClient` that comes preconfigured with the default settings for
connecting to a LocalTerra node.

#### wallets

Ready-to use :class:`Wallet` objects with LocalTerra default accounts.

## LocalTerra Objects

```python
class LocalTerra(LCDClient)
```

A :class:`LCDClient` that comes preconfigured with the default settings for
connecting to a LocalTerra node.

#### wallets

Ready-to use :class:`Wallet` objects with LocalTerra default accounts.

&gt;&gt;&gt; terra = LocalTerra()
&gt;&gt;&gt; terra.wallets[&#x27;test1&#x27;].key.acc_address
&#x27;terra1x46rqay4d3cssq8gxxvqz8xt6nwlz4td20k38v&#x27;

