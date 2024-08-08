---
sidebar_label: params
title: terra_sdk.client.lcd.params
---

## PaginationOptions Objects

```python
class PaginationOptions(APIParams)
```

This could be used when you need pagination options for APIs

**Arguments**:

- `key` _str_ - key is a value returned in PageResponse.next_key to begin
  querying the next page most efficiently. Only one of offset or key
  should be set.
- `offset` _int_ - offset is a numeric offset that can be used when key is unavailable.
  It is less efficient than using key. Only one of offset or key should be set.
- `limit` _int_ - limit is the total number of results to be returned in the result page.
  If left empty it will default to a value to be set by each app.
- `count_total` _bool_ - count_total is set to true to indicate that the result set should include a count of
  the total number of items available for pagination in UIs.
  count_total is only respected when offset is used. It is ignored when key is set.
- `reverse` _bool_ - reverse is set to true if results are to be returned in the descending order.

