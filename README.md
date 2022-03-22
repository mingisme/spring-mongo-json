# spring-mongo-json

## 1.Persist heritage entities in collections
## 2.Retrieve heritage entities from collections
## 3.Persist object with field which is heritage array 
## 4.Retrieve #3 from collection 
## 5.Pares complicated JSON which contains heritage entities from HTTP request
## 6.Write complicated JSON which contains heritage entities to HTTP response

## case5
```shell
curl --location --request POST 'localhost:8080/case3read' \
--header 'Content-Type: application/json' \
--data-raw '{
    "siteId": "SDAWC1",
    "orgId": "oAFSAFXZEW",
    "emissions": [
        {
            "type":"com.example.springmongojson.model.Fuel",
            "quantity": 2,
            "carbonContent": 1,
            "carbonOxidationRate": 3
        },
        {
            "type":"com.example.springmongojson.model.Carbonate",
            "quantity": 6,
            "purity": 5,
            "factor": 4
        }
    ]
}'
```

## 7.Parse list as Object Array from HTTP request
## 8.Persist Object list

## Case7
```shell
curl --location --request POST 'http://localhost:8080/case4' \
--header 'Content-Type: application/json' \
--data-raw '{
    "siteId": "SDAWC1",
    "orgId": "oAFSAFXZEW",
    "emissions": [
        {
            "quantity": 2,
            "carbonContent": 1,
            "carbonOxidationRate": 3
        },
        {
            "quantity": 6,
            "purity": 5,
            "factor": 4
        }
    ]
}'
```

