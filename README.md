
# Furnshop : Java Simple HttpServer without frameworks 

Implementing Basic CRUD for Furniture Shop with HttpServer




## API Reference

#### Get all Furniture

```http
  GET /api/v1/furniture
```

#### Get Furniture By Id

```http
  GET /api/v1/furniture?id=${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required** Id of item to fetch |

#### Get Furniture By Status

```http
  GET /api/v1/furniture?status=${status}
```

| Parameter | Type     | Description                        |
| :-------- | :------- | :--------------------------------  |
| `status`  | `string` | **Required** Status of items to fetch |


#### Add Furniture

```http
  POST /api/v1/furniture
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `furnitureName`  | `string` | **Required** Furniture Name |
| `category`  | `string` | **Required** Category of Furniture |
| `stock`  | `int` | **Required** Stock of Furniture  |
| `price`  | `float` | **Required** Price of Furniture  |
| `status`  | `string` | **Required** Status of Furniture  |

#### Update Furniture By Id

```http
  PATCH /api/v1/furniture?id=${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required** Id of item to fetch |
| `furnitureName`  | `string` | **Required** Furniture Name |
| `category`  | `string` | **Required** Category of Furniture |
| `stock`  | `int` | **Required** Stock of Furniture  |
| `price`  | `float` | **Required** Price of Furniture  |
| `status`  | `string` | **Required** Status of Furniture  |

#### Delete Furniture By Id

```http
  DELETE /api/v1/furniture?id=${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required** Id of item to fetch |





