---
sidebar_label: json
title: terra_sdk.util.json
---

#### dict\_to\_data

```python
def dict_to_data(d: dict) -> dict
```

Recursively calls to_data on dict

## JSONSerializable Objects

```python
class JSONSerializable(ABC)
```

#### to\_data

```python
def to_data() -> Any
```

Converts the object to its JSON-serializable Python data representation.

#### to\_json

```python
def to_json() -> str
```

Marshals the object into a stringified JSON serialization. Keys are first sorted
and the JSON rendered removes all unnecessary whitespace.

**Returns**:

- `str` - JSON string representation

