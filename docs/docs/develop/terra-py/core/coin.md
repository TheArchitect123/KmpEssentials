---
sidebar_label: coin
title: terra_sdk.core.coin
---

## Coin Objects

```python
@attr.s(frozen=True)
class Coin(JSONSerializable)
```

Represents a (denom, amount) pairing, analagous to ``sdk.Coin`` and ``sdk.DecCoin``
in Cosmos SDK. Used for representing Terra native assets.

#### denom

Coin&#x27;s denomination, only ``uluna``.

#### amount

Coin&#x27;s amount -- can be a ``int`` or :class:`Dec`

#### parse

```python
@staticmethod
def parse(arg: Union[Coin, str, dict]) -> Coin
```

Converts the argument into a coin.

**Arguments**:

- `arg` _Union[Coin, str, dict]_ - value to be converted to coin

#### is\_int\_coin

```python
def is_int_coin() -> bool
```

Checks whether the coin&#x27;s amount is of type ``int``.

#### is\_dec\_coin

```python
def is_dec_coin() -> bool
```

Checks whether the coin&#x27;s amount is of type :class:`Dec`.

#### to\_int\_coin

```python
def to_int_coin() -> Coin
```

Creates a new :class:`Coin` with an ``int`` amount.

#### to\_int\_ceil\_coin

```python
def to_int_ceil_coin() -> Coin
```

Turns the :class:`coin` into an ``int`` coin with ceiling the amount.

#### to\_dec\_coin

```python
def to_dec_coin() -> Coin
```

Creates a new :class:`Coin` with a :class:`Dec` amount.

#### from\_str

```python
@classmethod
def from_str(cls, string: str) -> Coin
```

Creates a new :class:`Coin` from a coin-format string. Must match the format:
``283923uluna`` (``int``-Coin) or ``23920.23020uluna`` (:class:`Dec`-Coin).

&gt;&gt;&gt; int_coin = Coin.from_str(&quot;230920uluna&quot;)
&gt;&gt;&gt; int_coin.denom
&#x27;uluna&#x27;
&gt;&gt;&gt; int_coin.amount
230920
&gt;&gt;&gt; dec_coin = Coin.from_str(&quot;203922.223uluna&quot;)
&gt;&gt;&gt; dec_coin.denom
&#x27;uluna&#x27;
&gt;&gt;&gt; dec_coin.amount
Dec(&#x27;203922.223&#x27;)

**Arguments**:

- `string` _str_ - string to convert
  

**Raises**:

- `ValueError` - if string is in wrong format
  

**Returns**:

- `Coin` - converted string

#### add

```python
def add(addend: Union[Numeric.Input, Coin]) -> Coin
```

Creates a new :class:`Coin` with the sum as amount. If the ``addend`` is a
:class:`Coin`, its ``denom`` must match.

**Arguments**:

- `addend` _Union[Numeric.Input, Coin]_ - addend
  

**Raises**:

- `ArithmeticError` - if addedend has different ``denom``
  

**Returns**:

- `Coin` - sum

#### sub

```python
def sub(subtrahend: Union[Numeric.Input, Coin]) -> Coin
```

Creates a new :class:`Coin` with the difference as amount. If the ``subtrahend`` is a
:class:`Coin`, its ``denom`` must match.

**Arguments**:

- `subtrahend` _Union[Numeric.Input, Coin]_ - subtrahend
  

**Returns**:

- `Coin` - difference

#### mul

```python
def mul(multiplier: Numeric.Input) -> Coin
```

Creates a new :class:`Coin` with the product as amount. The ``multiplier``
argument is first coerced to either an ``int`` or :class:`Dec`.

**Arguments**:

- `multiplier` _Numeric.Input_ - multiplier
  

**Returns**:

- `Coin` - product

#### div

```python
def div(divisor: Numeric.Input) -> Coin
```

Creates a new :class:`Coin` with the quotient as amount. The ``divisor``
argument is first coerced to either an ``int`` or :class:`Dec`.

**Arguments**:

- `divisor` _Numeric.Input_ - divisor
  

**Returns**:

- `Coin` - quotient

#### mod

```python
def mod(modulo: Numeric.Input) -> Coin
```

Creates a new :class:`Coin` with the modulus as amount.

**Arguments**:

- `modulo` _Numeric.Input_ - modulo
  

**Returns**:

- `Coin` - modulo

#### from\_data

```python
@classmethod
def from_data(cls, data: dict) -> Coin
```

Deserializes a :class:`Coin` object from its JSON data representation.

**Arguments**:

- `data` _dict_ - data object

#### from\_amino

```python
@classmethod
def from_amino(cls, data: dict) -> Coin
```

Deserializes a :class:`Coin` object from its amino-codec representation.

**Arguments**:

- `data` _dict_ - data object

