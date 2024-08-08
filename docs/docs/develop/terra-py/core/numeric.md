---
sidebar_label: numeric
title: terra_sdk.core.numeric
---

Numeric types.

#### DEC\_NUM\_DIGITS

Number of digits for Decimal.

#### chop\_precision\_and\_round

```python
def chop_precision_and_round(d: int) -> int
```

Cosmos-SDK&#x27;s banker&#x27;s rounding:
https://github.com/cosmos/cosmos-sdk/blob/1d75e0e984e7132efd54c3526e36b3585e2d91c0/types/decimal.go#L491

## Dec Objects

```python
class Dec(JSONSerializable)
```

BigInt-based Decimal representation with basic arithmetic operations with
compatible Python numeric types (int, float, Decimal). Does not work with
``NaN``, ``Infinity``, ``+0``, ``-0``, etc. Serializes as a string with 18 points of
decimal precision.

&gt;&gt;&gt; Dec(5)
Dec(&quot;5.0&quot;)
&gt;&gt;&gt; Dec(&quot;121.1232&quot;)
Dec(&quot;121.1232&quot;)
&gt;&gt;&gt; Dec(121.1232)
Dec(&quot;121.1232&quot;)

**Arguments**:

- `arg` _Union[str, int, float, Decimal, Dec]_ - argument to coerce into Dec

#### zero

```python
@classmethod
def zero(cls) -> Dec
```

Dec representation of zero.

**Returns**:

- `Dec` - zero

#### one

```python
@classmethod
def one(cls)
```

Dec representation of one.

**Returns**:

- `Dec` - one

#### \_\_str\_\_

```python
def __str__() -> str
```

Converts to a string using all 18 decimal precision points.

**Returns**:

- `str` - string representation

#### to\_short\_str

```python
def to_short_str() -> str
```

Converts to a string, but truncates all unnecessary zeros.

**Returns**:

- `str` - string representation

#### parity

```python
@property
def parity() -> int
```

Get the parity of the Dec value. Returns -1 if value is below 0, and 1 otherwise.

**Returns**:

- `int` - parity

#### whole

```python
@property
def whole() -> str
```

Get the integral part of the Dec value.

**Returns**:

- `str` - integer, as string

#### frac

```python
@property
def frac() -> str
```

Get the fractional part of the Dec value.

**Returns**:

- `str` - fraction, as string

#### lt

```python
def lt(other: Union[str, int, float, Decimal, Dec]) -> bool
```

Check less than.

**Arguments**:

- `other` _Union[str, int, float, Decimal, Dec]_ - compared object

#### le

```python
def le(other: Union[str, int, float, Decimal, Dec]) -> bool
```

Check less than or equal to.

**Arguments**:

- `other` _Union[str, int, float, Decimal, Dec]_ - compared object

#### gt

```python
def gt(other: Union[str, int, float, Decimal, Dec]) -> bool
```

Check greater than.

**Arguments**:

- `other` _Union[str, int, float, Decimal, Dec]_ - compared object

#### ge

```python
def ge(other) -> bool
```

Check greater than or equal to.

**Arguments**:

- `other` _Union[str, int, float, Decimal, Dec]_ - compared object

#### add

```python
def add(addend: Union[str, int, float, Decimal, Dec]) -> Dec
```

Performs addition. ``addend`` is first converted into Dec.

**Arguments**:

- `addend` _Union[str, int, float, Decimal, Dec]_ - addend
  

**Returns**:

- `Dec` - sum

#### sub

```python
def sub(subtrahend: Union[str, int, float, Decimal, Dec]) -> Dec
```

Performs subtraction. ``subtrahend`` is first converted into Dec.

**Arguments**:

- `subtrahend` _Union[str, int, float, Decimal, Dec]_ - subtrahend
  

**Returns**:

- `Dec` - difference

#### mul

```python
def mul(multiplier: Union[str, int, float, Decimal, Dec]) -> Dec
```

Performs multiplication. ``multiplier`` is first converted into Dec.

**Arguments**:

- `multiplier` _Union[str, int, float, Decimal, Dec]_ - multiplier
  

**Returns**:

- `Dec` - product

#### div

```python
def div(divisor: Union[str, int, float, Decimal, Dec]) -> Dec
```

Performs division. ``divisor`` is first converted into Dec.
It works like truediv(&#x27;/&#x27;)

**Arguments**:

- `divisor` _Union[str, int, float, Decimal, Dec]_ - divisor
  

**Raises**:

- `ZeroDivisionError` - if ``divisor`` is 0
  

**Returns**:

- `Dec` - quotient

#### mod

```python
def mod(modulo: Union[str, int, float, Decimal, Dec]) -> Dec
```

Performs modulus. ``modulo`` is first converted into Dec.

**Arguments**:

- `modulo` _Union[str, int, float, Decimal, Dec]_ - modulo
  

**Returns**:

- `Dec` - modulus

#### from\_data

```python
@classmethod
def from_data(cls, data: str) -> Dec
```

Converts Dec-formatted string into proper :class:`Dec` object.

#### with\_prec

```python
@classmethod
def with_prec(cls, i: Union[int, str], prec: int) -> Dec
```

Replicates Cosmos SDK&#x27;s ``Dec.withPreic(i, prec)``.

**Arguments**:

- `i` _Union[int, str]_ - numeric value
- `prec` _int_ - precision
  

**Returns**:

- `Dec` - decimal

## Numeric Objects

```python
class Numeric()
```

#### parse

```python
@staticmethod
def parse(value: Numeric.Input) -> Numeric.Output
```

Parses the value and coerces it into an ``int`` or :class:`Dec`.

**Arguments**:

- `value` _Numeric.Input_ - value to be parsed
  

**Raises**:

- `TypeError` - if supplied value could not be parsed
  

**Returns**:

- `Numeric.Output` - coerced number

