---
sidebar_label: coins
title: terra_sdk.core.coins
---

## Coins Objects

```python
class Coins(JSONSerializable,  List[Coin_pb])
```

Represents an unordered collection of :class:`Coin` objects
-- analagous to ``sdk.Coins`` and ``sdk.DecCoins`` in Cosmos SDK. If one of the
input coins would be ``Dec``-amount type coin, the resultant Coins is converted to
``Dec``-amount coins.

**Arguments**:

- `arg` _Optional[Coins.Input], optional_ - argument to convert. Defaults to ``{}``.
  

**Raises**:

- `TypeError` - if ``arg`` is not an Iterable

#### Input

Types which can be converted into a :class:`Coins` object.

#### from\_str

```python
@classmethod
def from_str(cls, s: str) -> Coins
```

Converts a comma-separated list of Coin-format strings to :class:`Coins`.

&gt;&gt;&gt; Coins.from_str(&#x27;1000uluna,1234uluna&#x27;)
Coins(&quot;1000uluna,1234uluna&quot;)

**Arguments**:

- `s` _str_ - string to convert

#### \_\_init\_\_

```python
def __init__(arg: Optional[Coins.Input] = {}, **denoms)
```

Converts the argument into a :class:`Coins` object.

#### get

```python
def get(denom: str) -> Optional[Coin]
```

Get the Coin with the denom contained in the Coins set.

**Arguments**:

- `denom` _str_ - denom
  

**Returns**:

- `Optional[Coin]` - result (can be ``None``)

#### from\_data

```python
@classmethod
def from_data(cls, data: list) -> Coins
```

Converts list of Coin-data objects to :class:`Coins`.

**Arguments**:

- `data` _list_ - list of Coin-data objects

#### from\_amino

```python
@classmethod
def from_amino(cls, amino: list) -> Coins
```

Converts list of Coin-amino objects to :class:`Coins`.

**Arguments**:

- `amino` _list_ - list of Coin-data objects

#### from\_proto

```python
@classmethod
def from_proto(cls, proto: List[Coin_pb]) -> Coins
```

Converts list of Coin-data objects to :class:`Coins`.

**Arguments**:

- `data` _list_ - list of Coin-data objects

#### denoms

```python
def denoms() -> List[str]
```

Get the list of denoms for all Coin objects contained.

#### to\_dec\_coins

```python
def to_dec_coins() -> Coins
```

Creates new set of :class:`Coins` that have :class`Dec` amounts.

#### to\_int\_coins

```python
def to_int_coins() -> Coins
```

Creates new set of :class:`Coins` that have ``int`` amounts.

#### to\_int\_ceil\_coins

```python
def to_int_ceil_coins() -> Coins
```

Creates a new :class:`Coins` object with all ``int`` coins with ceiling the amount

#### add

```python
def add(addend: Union[Coin, Coins]) -> Coins
```

Performs addition, which combines the sets of Coin objects. Coins of similar denoms
will be merged into one Coin representing the denom.

**Arguments**:

- `addend` _Union[Coin, Coins]_ - addend

#### sub

```python
def sub(subtrahend: Union[Coin, Coins]) -> Coins
```

Performs subtraction, which combines the sets of Coin objects. Coins of similar denoms
will be merged into one Coin representing the denom.

**Arguments**:

- `subtrahend` _Union[Coin, Coins]_ - subtrahend

#### mul

```python
def mul(multiplier: Numeric.Input) -> Coins
```

Performs multiplicaiton, which multiplies all the Coin objects in the set by a
multiplier.

**Arguments**:

- `multiplier` _Numeric.Input_ - multiplier

#### div

```python
def div(divisor: Numeric.Input) -> Coins
```

Performs division, which divides all the Coin objects in the set by a divisor.

**Arguments**:

- `divisor` _Numeric.Input_ - divisor

#### to\_list

```python
def to_list() -> List[Coin]
```

Converts the set of :class:`Coin` objects contained into a sorted list by denom.

**Returns**:

- `List[Coin]` - list, sorted by denom

#### filter

```python
def filter(predicate: Callable[[Coin], bool]) -> Coins
```

Creates a new :class:`Coins` collection which filters out all Coin objects that
do not meet the predicate.

**Arguments**:

- `predicate` _Callable[[Coin], bool]_ - predicate for filtering

#### map

```python
def map(fn: Callable[[Coin], Any]) -> Iterator[Any]
```

Creates an iterable which applies the function to all coins in the set,
ordered by denomination.

**Arguments**:

- `fn` _Callable[[Coin], Any]_ - function to apply
  

**Returns**:

- `Iterator[Any]` - coin map
  

**Yields**:

- `Iterator[Any]` - coin map

